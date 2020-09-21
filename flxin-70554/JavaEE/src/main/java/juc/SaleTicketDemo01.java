package juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SaleTicketDemo01 {

    static Ticket ticket = new Ticket();

    public static void main(String[] args) {

        new Thread(() ->  {for(int i = 0; i < 40; i++) ticket.sale();},"A").start();
        new Thread(() ->  {for(int i = 0; i < 40; i++) ticket.sale();},"B").start();
        new Thread(() ->  {for(int i = 0; i < 40; i++) ticket.sale();},"C").start();

//		new Thread(new Runnable() {
//			public void run() {
//				for(int i = 0; i < 40; i++) {
//					ticket.sale();
//				}
//			}
//		},"A").start();
//		new Thread(new Runnable() {
//			public void run() {
//				for(int i = 0; i < 40; i++) {
//					ticket.sale();
//				}
//			}
//		},"B").start();
//		new Thread(new Runnable() {
//			public void run() {
//				for(int i = 0; i < 40; i++) {
//					ticket.sale();
//				}
//			}
//		},"C").start();

    }

}


class Ticket{
    private int number = 40;
    Lock lock = new ReentrantLock();
    public void sale() {
        lock.lock();
        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出" + (number--) + "\t还剩下" + number);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}