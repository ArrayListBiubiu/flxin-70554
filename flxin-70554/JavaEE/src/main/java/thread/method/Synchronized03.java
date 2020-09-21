package thread.method;

/**
 * 只要是synchronized修饰静态方法，一定是同步的，即使创建两个不同的对象。
 */
public class Synchronized03 {

    Airplane airplane1 = new Airplane();
    Airplane airplane2 = new Airplane();

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                Airplane.fly();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Airplane.fly();
            }
        };

        t1.start();
        t2.start();

    }

}

class Airplane {
    public synchronized static void fly() {
        try {
            System.out.println(Thread.currentThread().getName() + ":准备起飞。");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":起飞成功。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
