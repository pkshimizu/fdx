package net.noncore.fdx.domains.watchers;

import java.io.IOException;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileCreateWatcher extends FileWatcher {

    protected FileCreateWatcher() throws IOException {
        super(ENTRY_CREATE);
    }
}
