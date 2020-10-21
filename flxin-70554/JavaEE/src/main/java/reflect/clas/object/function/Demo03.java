package reflect.clas.object.function;




import reflect.get.clas.object.Dog;

import java.lang.reflect.Constructor;


/**
 * 获取构造方法：
 *     Constructor getConstructor()  获取无参数的构造方法
 *     Constructor getConstructor(String.class)  获取1个参数的构造方法，且参数是String
 *     Constructor getConstructor(String.class,Integer.class)  获取2个参数的构造方法，且参数是String、Integer
 *     这里要注意：如果实体类是int，这里的参数是int.class
 *                如果实体类是Integer，这里的参数就是Integer.class
 */
public class Demo03 {

    public static void main(String[] args) throws Exception {
        //获取Dog的Class对象。
        Class dogClass = Dog.class;
        System.err.println(dogClass.getName());

        //1.Constructor getConstructor(parameter...)。
        Constructor constructor = dogClass.getConstructor(String.class);
        System.out.println(constructor);
        //创建对象。
        Object dog = constructor.newInstance("阿拉斯加");
        System.out.println(dog);

        //2.Constructor getConstructor()。
        Constructor constructor02 = dogClass.getConstructor();
        System.out.println(constructor);
        //创建对象。
        Object dog02 = constructor02.newInstance();
        System.out.println(dog02);

        //3.对于使用空参数构造方法，直接使用newInstance()获取。
        Object o = dogClass.newInstance();
        System.out.println(o);

    }

}
