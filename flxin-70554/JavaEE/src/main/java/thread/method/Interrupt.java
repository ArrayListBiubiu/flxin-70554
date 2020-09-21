package thread.method;

/**
 * interrupt中断线程。
 */
public class Interrupt {

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println("开始睡觉。");
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    System.out.println("醒了，去开门。");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("敲门，咚咚咚。");
                        Thread.sleep(1000);
                    }
                    t1.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();

    }

}
