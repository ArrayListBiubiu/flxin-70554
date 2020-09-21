package thread.method;




public class Join {

    /**
     * 一个方法的局部变量若要被内部类调用，必须是final修饰的，不能被再次赋值不符合业务，所以提升为成员变量。
     */
    static Boolean isFinish = false;

    public static void main(String[] args) {

        //final Boolean isFinish = false;

        Thread t1 = new Thread() {
            public void run() {
                if (isFinish == false) {
                    try {
                        for(int i = 0; i < 100; i++) {
                            System.out.println("已下载：" + i + "%");
                            Thread.sleep(20);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isFinish = true;
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("图片开始下载。");
                try {
                    t1.join();  // 使nt2进入阻塞状态，等待t1结束后，才能继续执行。t2->t1->t2。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isFinish == true) {
                    System.out.println("图片下载完毕。");
                }
            }
        };

        t1.start();
        t2.start();

    }

}
