package example;


/**
 * 方法的参数传递机制
 */
public class Demo__01 {


    public static void main(String[] args) {

        Demo__01 d = new Demo__01();

        int age = 20;
        d.function1(age);
        System.out.println(age);

        Person p = new Person("aaa");
        d.function2(p);
        System.out.println(p.name);

        String str = "hello";
        System.out.println(str);


    }

    public void function1(int age) {
        age = 30;
    }
    public void function2(Person p) {
        p.setName("bbb");
    }
    public void function3(String str) {
        str = "world";
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
