package net.noncore.fdx.domains.watchers;

import java.io.IOException;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileChangeWatcher extends FileWatcher {

    protected FileChangeWatcher() throws IOException {
        super(ENTRY_MODIFY);
    }
}
