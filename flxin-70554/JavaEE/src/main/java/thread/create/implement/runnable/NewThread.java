package thread.create.implement.runnable;

public class NewThread {

    public static void main(String[] args) {

        Runnable r1 = new MyRunnable01();
        Runnable r2 = new MyRunnable02();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }

}

class MyRunnable01 implements Runnable{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是干嘛的？");
        }
    }

}


class MyRunnable02 implements Runnable{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的。");
        }
    }

}