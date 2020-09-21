package thread.method;

/**
 * 在多线程下出现并发安全问题。
 */
public class Synchronized01 {

    static int bean = 20;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    getBean();
                    System.out.println("线程1，bean:" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    getBean();
                    System.out.println("线程2，bean:" + bean);
                }
            }
        };

        t1.start();
        t2.start();

    }

    /**
     * synchronized，加在方法上。
     */
    public synchronized static int getBean() {
        if (bean == 0) {
            throw new RuntimeException("没有豆子了。");
        }
        Thread.yield();     // 提高并发安全问题出现的可能性。
        return bean--;
    }

}
