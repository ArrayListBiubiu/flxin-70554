package thread.method;

/**
 * t2.setDaemon(true);设置为守护线程。
 *
 * 在此类中，共有3个线程，t1，t2，main，但是main线程是最先结束的。
 */
public class Daemon {

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("我要跳了。");
                        Thread.sleep(1000);
                    }
                    System.out.println("game over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    while (true) {
                        System.out.println("不要跳。");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();

        t2.setDaemon(true);     //设置为守护线程。
        t2.start();

    }

}
