package net.noncore.fdx.domains.services;

import javafx.concurrent.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskService implements Service<Task<?>, Void> {
    private static TaskService instance = new TaskService();
    private ExecutorService service = Executors.newSingleThreadExecutor();

    private TaskService() {
    }

    public static TaskService getInstance() {
        return instance;
    }

    @Override
    public Void execute(Task<?> task) {
        service.submit(task);
        return null;
    }

    public void shutdown() {
        service.shutdown();
    }
}
