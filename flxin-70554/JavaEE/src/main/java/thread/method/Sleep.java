package thread.method;


/**
 * sleep阻塞，必须捕获InterruptedException异常。
 *
 * 1. 以主线程为例，设定3秒阻塞。
 * 2. 没过1秒，输出一次hello。
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始了。。。");

        Thread.sleep(3000);

        System.out.println("结束了。。。");
        System.out.println("--------------------------------");

        while (true) {
            Thread.sleep(1000);
            System.out.println("hello!!!");
        }
    }

}
