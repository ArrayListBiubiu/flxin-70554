package reflect.clas.object.function;


import javaee.reflect.get.clas.object.Dog;

import java.lang.reflect.Method;


/**
 * 获取成员方法：
 *     Method[] getMethods()：获取所有public修饰的成员方法。    ***但是也同时会输出继承于Object的方法。***
 *     Method getMethod(parameter...)：获取指定名字的public修饰的成员方法。
 *
 *     Method[] getDeclaredMethods()：获取所有方法    ***不会输出继承于Object的方法***
 *     Method getDeclaredMethod(parameter...)：获取指定名字的成员方法
 */
public class Demo04 {

    public static void main(String[] args) throws Exception {
        //获取Dog的Class对象。
        Class dogClass = Dog.class;
        System.err.println(dogClass.getName());

        //1.Method[] getMethods()：获取所有public修饰的成员方法。
        //**但是也同时会输出继承于Object的方法。
        Method[] methods = dogClass.getMethods();
        for (Method method : methods) {
            System.out.println("method：" + method);
            System.out.println("method.getName()：" + method.getName());
        }

        //2.Method getMethod(parameter...)：获取指定名字的public修饰的成员方法。
        Method eatMethod = dogClass.getMethod("eat");
        Dog dog = new Dog();
        //执行方法。
        eatMethod.invoke(dog);

        //eat方法重载时的使用。
        Method eatMethod02 = dogClass.getMethod("eat", String.class);
        //执行方法。
        eatMethod02.invoke(dog, "萨摩");

        //3.访问私有方法
        Method runMethod = dogClass.getDeclaredMethod("run");
        runMethod.setAccessible(true);
        runMethod.invoke(dog);

    }

}
