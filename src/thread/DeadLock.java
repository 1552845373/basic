package thread;

public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {                  // 调用Runnable这个构造器
            synchronized (a) {
                System.out.println("get a");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("get b");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println("get b");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("get a");
                }
            }
        }).start();
    }
}
