package thread;

import java.util.concurrent.locks.ReentrantLock;

/***************************************************************************
 * @className: ReentrantLockTest
 * @date     : 2019/9/25 14:38
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
           lock.lock();
           try {
               for (int i = 1; i <= 5; i++) {
                   System.out.print("睡眠" + i + "s;");
                   Thread.sleep(100000);
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread t2 get lock");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread t3 get lock");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t3.start();
    }
}
