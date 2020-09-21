package ajax;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo05 {

    public static void main(String[] args) {

        /**
         * 加载spring位置文件，获取spring容器。
         * ***只要加载spring配置文件，spring自动new出相应对象。
         * ApplicationContext是一个接口，定义了spring容器需要定义的方法。
         * ClassPathXmlApplicationContext实现了ApplicationContext接口的一个类，该类会依据类路径去查找配置文件，然后启动spring容器。
         */
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("ajax.xml");

        //通过spring容器获取对象
        Owl owl = (Owl) ac.getBean("owl");

        System.out.println(owl);

    }

}
