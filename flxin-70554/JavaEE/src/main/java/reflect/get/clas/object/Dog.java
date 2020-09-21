package reflect.get.clas.object;


/**
 * 用于反射演示的实体类
 */
public class Dog {

    private String name = "哈士奇";
    protected int age = 2;
    public String address = "北京";
    public String color = "黄色";

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String address, int age) {
        this.address = address;
        this.age = age;
    }

    public void eat() {
        System.out.println("无参数，公共方法eat");
    }

    public void eat(String name) {
        System.out.println(name + "有参数，公共方法eat");
    }

    private void run() {
        System.out.println("私有方法run");
    }

    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
