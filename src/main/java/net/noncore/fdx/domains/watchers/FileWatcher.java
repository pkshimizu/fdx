package net.noncore.fdx.domains.watchers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.Map;

public abstract class FileWatcher implements Watcher<FileEvent> {
    private boolean watching;
    private WatchService watcher;
    private Kind<Path> kind;
    private Map<Path, WatchKey> keys;
    private List<Handler<FileEvent>> handlers;

    protected FileWatcher(Kind<Path> kind) throws IOException {
        watcher = FileSystems.getDefault().newWatchService();
        this.kind = kind;
    }

    public void add(Path path) throws IOException {
        path.register(watcher, kind);
    }

    public void remove(Path path) {
        keys.get(path).cancel();
    }

    @Override
    public void add(Handler<FileEvent> handler) {

    }

    @Override
    public void start() {
        watching = true;
        while(watching) {
            try {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    handlers.stream().forEach(handler -> {
                        handler.handle(new FileEvent());
                    });
                }
                key.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        watching = false;
    }
}
