package thread;

public class StartAndRun {

    public static void test() {
        System.out.println("test");
        System.out.println("Current Thread is " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                test();
            }
        };
        System.out.println("Current Thread is " + Thread.currentThread().getName());
        thread.start();
    }
}
