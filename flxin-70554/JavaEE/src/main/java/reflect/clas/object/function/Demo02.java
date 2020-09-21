package reflect.clas.object.function;


import javaee.reflect.get.clas.object.Dog;

import java.lang.reflect.Field;


/**
 * 获取成员变量。
 *     Field[] getFields()：获取所有public修饰的成员变量。
 *     Field getField(String name)：获取指定名字的public修饰的成员变量。
 *
 *     Field[] getDeclaredFields()：获取所有的成员的变量，不考虑修饰符。
 *     Field getDeclaredField(String name)：获取指定名字的成员的变量，不考虑修饰符。
 */
public class Demo02 {

    public static void main(String[] args) throws Exception {
        //获取Dog的Class对象。
        Class dogClass = Dog.class;
        System.err.println(dogClass);
        System.err.println(dogClass.getName());

        //1.Field[] getFields()：获取所有public修饰的成员变量。
        Field[] fields = dogClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //2.Field getField(String name)：获取指定名字的public修饰的成员变量。
        Field address = dogClass.getField("address");
        // 获取成员变量address的值。
        Dog dog = new Dog();
        Object value = address.get(dog);
        System.out.println("value：" + value);

        //3.Field[] getDeclaredFields()：获取所有的成员的变量，不考虑修饰符。
        Field[] declaredFields = dogClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //4.Field getDeclaredField(String name)：获取所有的成员的变量，不考虑修饰符。
        Field name = dogClass.getDeclaredField("name");
        //***忽略访问权限修饰的安全检查，即暴力反射。
        name.setAccessible(true);
        Object value02 = name.get(dog);
        System.out.println("value02：" + value02);
    }

}
