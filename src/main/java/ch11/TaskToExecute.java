package ch11;

import org.springframework.core.task.TaskExecutor;

public class TaskToExecute {
    private TaskExecutor taskExecutor;

    public void executeTask() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello from thread: " + Thread.currentThread().getName());
                }
            });
        }
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
}

