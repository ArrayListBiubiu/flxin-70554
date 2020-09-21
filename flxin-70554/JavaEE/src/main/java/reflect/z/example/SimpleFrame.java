package reflect.z.example;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 在不改变代码情况下，任意创建对象，并使用方法。
 */
public class SimpleFrame {

    public static void main(String[] args) throws Exception {

        // 1. 加载配置文件。
        // 1.1 创建propertie对象。
        Properties properties = new Properties();

        ClassLoader classLoader = SimpleFrame.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("reflect.properties");
        properties.load(is);

        // 2. 获取配置文件中的数据。
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3. 加载该类进内存中。
        Class cls = Class.forName(className);

        // 4. 创建对象。
        Object object = cls.newInstance();

        // 5. 获取方法对象。
        Method method = cls.getMethod(methodName);

        // 6. 执行方法。
        method.invoke(object);



    }

}
