package thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        Runnable mr3 = new MyRunnable();
        new Thread(mr1).start();
        new Thread(mr2).start();
        new Thread(mr3).start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}