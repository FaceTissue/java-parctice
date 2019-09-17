package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***************************************************************************
 * @className: H2OLockCondition
 * @date     : 2019/9/16 14:32
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class H2OLockCondition {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile int idx = 0;
    public H2OLockCondition() {

    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (idx == 2) {
                condition.await();
            }
            releaseHydrogen.run();
            idx++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (idx < 2) {
                condition.await();
            }
            releaseOxygen.run();
            idx = 0;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        H2O h2O = new H2O();
        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");
        String str = "OOHHHH";
        int n = str.length();
        char[] arr = str.toCharArray();
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        for (char c : arr) {
            if (c == 'H') {
                executorService.execute(() -> {
                    try {
                        h2O.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else if (c == 'O') {
                executorService.execute(() -> {
                    try {
                        h2O.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        executorService.shutdown();
    }
}
