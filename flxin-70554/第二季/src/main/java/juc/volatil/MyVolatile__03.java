package juc.volatil;


/**
 * volatile禁止指令重排在单利模式中的应用
 */
public class MyVolatile__03 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            },  String.valueOf(i)).start();
        }
    }
}

/**
 * 双重检查 DCL
 * 优点：既有线程安全，又能保证效率
 * 2个if 、 volatile 都必不可少
 *
 * 由于存在指令重排现象，需要有volatile修饰，禁止指令重排（指令重排现象很难通过代码得到验证，发生率极低）
 * instance = new Singleton();可以分解为一下3步：
 *      1.  memory =  allocate(); //分配对象内存空间
 *      2.  instance(memory)  //初始化对象
 *      3.  instance = memory   //设置instance指向分配好的内存地址
 * 由于2和3不存在数据依赖关系，允许指令重排
 *      1.
 *      3.
 *      2.
 * 最终得到，一个没有初始化的引用对象
 * 所以第一个if判断为
 *      1.  instance != null
 *      2.  return instance
 */
class Singleton {

    //1.提供内部创建对象的实例、生命
    private static volatile Singleton instance;

    //2.构造器私有化
    private Singleton() {
        System.out.println("创建一个Singleton对象！！！");
    }

    //3.双重检查
    public static Singleton getInstance() {
        //不用等待进入同步代码块内的if判断，提高效率
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}