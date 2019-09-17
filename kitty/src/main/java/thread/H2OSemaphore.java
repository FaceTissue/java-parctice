package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***************************************************************************
 * @className: H2OSemaphore
 * @date     : 2019/9/16 14:29
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class H2OSemaphore {
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);
    public H2OSemaphore() {

    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
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
