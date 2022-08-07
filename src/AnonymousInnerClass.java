public class AnonymousInnerClass {
    public static void main(String[] args) {
        Father father = new Father() {
            @Override
            public void test() {
                System.out.println("匿名内部类重写了 test 方法");
            }
        };
        System.out.println("father 对象的运行类型= " + father.getClass());
        father.test();
    }
}

class Father {
    String name;

    public Father(){}

    public Father(String name) {
        this.name = name;
        System.out.println(name);
    }

    public void test(){}
}