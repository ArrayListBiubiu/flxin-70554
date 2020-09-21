package reflect.get.clas.object;

/**
 * 获取Class对象（字节码对象）：
 *     1.java代码处在第一个阶段，即编译成字节码文件，但还未进入内存中。（source源代码阶段）
 *         Class.forName("全类名")：将字节码文件加载进内存，返回class对象。
 *         ***多用于配置文件，将类名定义在配置文件中，读取文件加载类。
 *     2.java代码处在第二个阶段，即字节码文件已经进入到内存中。（class类对象阶段）
 *         类名.class：通过类名的属性class获取。
 *         ***多用于参数的传递。
 *     3.java代码处在第三个阶段，即已经存在类对象。（runtime运行时阶段）
 *         对象.getClass()：getClass()方法在Object类中定义。
 *         ***多用于通过对象获取字节码文件。
 *     4.通过类加载器
 */
public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过Class的静态方法获取：体现反射的动态性
        Class clazz01 = Class.forName("javaee.reflect.get.clas.object.Dog");
        System.out.println(clazz01);

        //2.调用运行时类本身的.class属性
        Class clazz02 = Dog.class;
        System.out.println(clazz02);

        //3.通过运行时类的对象的getClass()方法
        Dog dog = new Dog();
        Class clazz03 = dog.getClass();
        System.out.println(clazz03);

        //4.通过类的加载器
        String className = "javaee.reflect.get.clas.object.Dog";
        ClassLoader classLoader = new Demo01().getClass().getClassLoader();
        Class clazz04 = classLoader.loadClass(className);
        System.out.println(clazz04.toString());

        //比较三个对象。
        //    结论：同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，即单例。
        System.out.println(clazz01 == clazz02);
        System.out.println(clazz01 == clazz03);
        System.out.println(clazz01 == clazz04);
    }

}
