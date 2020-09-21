package juc.cas;
import java.util.concurrent.atomic.AtomicReference;


/**
 * AtomicReference原子引用，可以对某个类做原子包装
 */
public class MyAtomicReference__02 {

    public static void main(String[] args) {

        User z3 = new User("张三",20);
        User li4 = new User("李四",22);

        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(z3);

        atomicReference.compareAndSet(z3, li4);
        System.out.println(atomicReference.get().toString());   //atomicReference.get()返回的是z3对象
    }
}

class User {
    String name;
    Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}