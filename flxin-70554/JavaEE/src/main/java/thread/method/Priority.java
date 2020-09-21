package thread.method;

public class Priority {

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hello");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hi");
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);    //MAX_PRIORITY=10，优先级最高。
        t2.setPriority(Thread.MIN_PRIORITY);    //MIN_PRIORITY=1，优先级最低。

        t1.start();
        t2.start();

    }

}
