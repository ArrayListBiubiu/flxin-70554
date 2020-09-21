package thread.create.extend.thread;

public class MyThread02 extends Thread{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的。");
        }
    }

}
