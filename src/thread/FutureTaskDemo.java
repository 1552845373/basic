package thread;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                String value = "is Done";
//                Thread.sleep(2000);
//                return value;
//            }
//        });
//
//        new Thread(task).start();
//        while (!task.isDone()) {
//            System.out.println("please wait");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(task.get());

        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String value = "is Done";
                Thread.sleep(2000);
                return value;
            }
        });

        if (!future.isDone()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
