package generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Generic {
    public static void main(String[] args) {
        HashSet<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("hh", 1));
        dogs.add(new Dog("aa", 3));
        dogs.add(new Dog("bb", 5));
        for (Dog dog : dogs) {
            System.out.println(dog.getName() + dog.getAge());
        }

        HashMap<String, Dog> hashMap = new HashMap<>();
        hashMap.put("hh", new Dog("hh", 1));
        hashMap.put("aa", new Dog("aa", 3));
        hashMap.put("bb", new Dog("bb", 5));
        for (Map.Entry<String, Dog> entry : hashMap.entrySet()) {
            Dog dog = entry.getValue();
            System.out.println(dog.getName() + dog.getAge());
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
