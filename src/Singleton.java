//// 饿汉式
//public class Singleton {
//    private static Singleton singleton = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return singleton;
//    }
//}

//// 懒汉式
//public class Singleton {
//    private static Singleton singleton;
//    private Singleton() {}
//    public static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}

//// 静态内部类
//public class Singleton {
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}

//// 双重校验锁
//public class Singleton {
//    private static Singleton singleton;
//    private Singleton() {}
//    private static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}

// 枚举
public enum Singleton {
    INSTANCE;
    public void whateverMethod() {
    }
}
