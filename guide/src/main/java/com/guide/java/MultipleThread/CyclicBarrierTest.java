package com.guide.java.MultipleThread;

import java.util.concurrent.CyclicBarrier;

/***************************************************************************
 * @className: CyclicBarrierTest
 * @date     : 2020/3/9 14:48
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class CyclicBarrierTest {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            final int no = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(no + "号到达，目前已有" + (cyclicBarrier.getNumberWaiting() + 1) + "人到达");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        System.out.println("Game Over");
    }
}
