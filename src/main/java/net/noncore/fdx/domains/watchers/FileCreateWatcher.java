package net.noncore.fdx.domains.watchers;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileCreateWatcher extends FileWatcher {
    private static final FileCreateWatcher instance = new FileCreateWatcher();

    private FileCreateWatcher() {
        super(ENTRY_CREATE);
    }

    public static FileCreateWatcher getInstance() {
        return instance;
    }
}
