package thread.method;

/**
 * 互斥锁。
 * 当有多个代码被不同的synchronized修饰时，且同步监视器对象是同一个，即本案例中的Student对象。
 * 这些被修饰的代码是互斥的，有同步效果。
 *
 * ***本案例与Synchronized03案例不同，必须是同一个监视器对象，Synchronized03中的是静态方法。
 */
public class Synchronized04 {

    public static void main(String[] args) {

        Student student = new Student();

        Thread t1 = new Thread() {
            public void run() {
                student.read();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                student.write();
            }
        };

        t1.start();
        t2.start();

    }

}

class Student {
    public synchronized void read() {
        try {
            System.out.println("准备读课文。");
            Thread.sleep(2000);
            System.out.println("读完了。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void write() {
        try {
            System.out.println("准备写文章。");
            Thread.sleep(2000);
            System.out.println("写完了。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
