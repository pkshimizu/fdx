package net.noncore.fdx.domains.watchers;

import java.nio.file.Path;

public class FileEvent {
    private Path path;

    private FileEvent(Path path) {
        this.path = path;
    }

    public static FileEvent of(Path path) {
        return new FileEvent(path);
    }

    public Path getPath() {
        return path;
    }
}
