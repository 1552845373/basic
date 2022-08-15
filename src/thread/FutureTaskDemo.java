package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        while (!task.isDone()) {
            System.out.println("please wait");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(task.get());
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "is Done";
        Thread.sleep(2000);
        return value;
    }
}
