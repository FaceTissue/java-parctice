package thread;

import java.util.concurrent.*;

/***************************************************************************
 * @className: H2OCyclicBarrier
 * @date     : 2019/9/16 14:39
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class H2OCyclicBarrier {
    public H2OCyclicBarrier() {

    }
    private ConcurrentLinkedQueue<Runnable> callbackOQ = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Runnable> callbackHQ = new ConcurrentLinkedQueue<>();
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        callbackHQ.poll().run();
        callbackHQ.poll().run();
        while (callbackOQ.size() == 0);
        callbackOQ.poll().run();
    });
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        callbackHQ.offer(releaseHydrogen);
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        callbackOQ.offer(releaseOxygen);
    }

    public static void main(String[] args) {

        H2O h2O = new H2O();
        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");
        String str = "OOHHHHHHO";
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
