package thread.create.extend.thread;

public class NewThread {

    public static void main(String[] args) {

        MyThread01 t1 = new MyThread01();
        MyThread02 t2 = new MyThread02();

        t1.start();
        t2.start();

    }

}