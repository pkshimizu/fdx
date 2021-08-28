package net.noncore.fdx.domains.watchers;

import java.io.IOException;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileDeleteWatcher extends FileWatcher {

    protected FileDeleteWatcher() throws IOException {
        super(ENTRY_DELETE);
    }
}
