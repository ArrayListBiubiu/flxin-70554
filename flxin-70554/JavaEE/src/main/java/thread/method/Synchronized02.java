package thread.method;


public class Synchronized02 {

    public static void main(String[] args) {

//        long startTime = System.currentTimeMillis();

        Shop shop = new Shop();

        Thread t1 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                shop.buy();
            }
        };

//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (startTime - endTime));

        t1.start();
        t2.start();

    }

}

/**
 * 使用同步块，缩小同步范围。
 * 在本案例中，只有试衣服需要同步，有效减少运行时间。
 */
class Shop {
    public void buy() {
        try {
            System.out.println(Thread.currentThread().getName() + "：开始挑衣服。");
            Thread.sleep(2000);

            /**
             * this指代，当前方法buy()所属的对象，即shop。
             * 确保多个线程t1，t2看到的是同一个对象。
             * 如，synchronized (new Object())，t1，t2看到的是不同的两个object实例，没有同步效果。
             */
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "：试衣服。");
                Thread.sleep(2000);
            }
            System.out.println(Thread.currentThread().getName() + "：结账。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}