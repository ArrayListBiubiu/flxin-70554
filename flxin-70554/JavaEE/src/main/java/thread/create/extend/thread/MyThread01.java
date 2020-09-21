package thread.create.extend.thread;

public class MyThread01 extends Thread{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是干嘛的？");
        }
    }

}
