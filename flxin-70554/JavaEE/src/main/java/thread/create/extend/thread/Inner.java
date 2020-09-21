package thread.create.extend.thread;

/**
 * 匿名内部类创建线程。
 */
public class Inner {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();


        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("hi");
                }
            }
        };
        t2.start();



    }

}
