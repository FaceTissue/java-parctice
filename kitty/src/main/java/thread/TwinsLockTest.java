package thread;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/***************************************************************************
 * @className: TwinsLockTest
 * @date     : 2019/9/26 10:30
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200L);
                    System.out.println();
                } catch (Exception e) {

                }
            }
        }).start();
        try {
            Thread.sleep(20000L);
        } catch (Exception e) {

        }
    }
}
