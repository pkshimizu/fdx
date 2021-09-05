package net.noncore.fdx.domains.watchers;

import javafx.concurrent.Task;
import net.noncore.fdx.domains.services.TaskService;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FileWatcher implements Watcher<FileEvent> {
    private boolean watching;
    private WatchService watcher;
    private Kind<Path> kind;
    private Map<WatchKey, WatchContext> contexts = new HashMap<>();

    private static class WatchContext {
        private Path path;
        private List<Handler<FileEvent>> handlers = new ArrayList<>();

        private WatchContext(Path path, Handler<FileEvent> handler) {
            this.path = path;
            this.handlers.add(handler);
        }

        public static WatchContext of(Path path, Handler<FileEvent> handler) {
            return new WatchContext(path, handler);
        }

        public void handle(WatchEvent<?> event) {
            handlers.stream().forEach(handler -> {
                String name = (String) event.context();
                handler.handle(FileEvent.of(this.path.resolve(name)));
            });
        }
    }

    protected FileWatcher(Kind<Path> kind) {
        try {
            watcher = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.kind = kind;
    }

    public void watch(Path path, Handler<FileEvent> handler) throws IOException {
        WatchKey key = path.register(watcher, kind);
        contexts.put(key, WatchContext.of(path, handler));
    }

    @Override
    public void start() {
        watching = true;
        TaskService.getInstance().execute(new Task<Void>() {
            @Override
            protected Void call() {
                while(watching) {
                    try {
                        WatchKey key = watcher.take();
                        for (WatchEvent<?> event : key.pollEvents()) {
                            contexts.get(key).handle(event);
                        }
                        key.reset();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    @Override
    public void destroy() {
        watching = false;
    }
}
