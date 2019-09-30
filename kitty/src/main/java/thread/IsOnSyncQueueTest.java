package thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***************************************************************************
 * @className: IsOnSyncQueueTest
 * @date     : 2019/9/27 19:07
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class IsOnSyncQueueTest {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Test
    public void test() {
        System.out.println("hello");
        Thread t1 = new Thread(() -> {
            System.out.println("thread");
            lock.lock();
            try {
                System.out.println("-----------");
                Thread.sleep(50000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("unlock");
                lock.unlock();
                condition.signal();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("+++++++++++");
//                Thread.sleep(1000);
                System.out.println("+++++++++++");
                while (!lock.tryLock()) {
                    condition.await();
                }
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
