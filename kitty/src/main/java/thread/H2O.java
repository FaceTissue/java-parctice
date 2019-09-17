package thread;

import sun.misc.Unsafe;
import sun.misc.VM;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/***************************************************************************
 * @className: H2O
 * @date     : 2019/9/16 8:55
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class H2O {
    private Semaphore semaphoreHydrogen = new Semaphore(2);
    private Semaphore semaphoreOxygen = new Semaphore(0);
    private AtomicInteger count = new AtomicInteger(0);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreHydrogen.acquire();
        releaseHydrogen.run();
        count.getAndIncrement();
        if (count.get() > 0 && (count.get() & 1) == 0) {
            semaphoreOxygen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreOxygen.acquire();
        releaseOxygen.run();
        semaphoreHydrogen.release(2);
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
