package thread.method;


/**
 * static void yield()强制终止时间片。
 * 在此demo中有更高的几率出现，hello、hi交替出现的现象。
 */
public class Yield {

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    System.out.println("hello");
                    Thread.yield();
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    System.out.println("hi");
                    Thread.yield();
                }
            }
        };

        t1.start();
        t2.start();


    }

}
