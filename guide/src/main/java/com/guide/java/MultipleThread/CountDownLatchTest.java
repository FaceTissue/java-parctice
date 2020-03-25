package com.guide.java.MultipleThread;

import java.util.concurrent.CountDownLatch;

/***************************************************************************
 * @className: CountDownLatchTest
 * @date     : 2020/1/13 18:40
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int NUM = 10;
        CountDownLatch count = new CountDownLatch(10);
        for (int i = 1; i <= NUM; i++) {
            final int No = i;
            Thread th = new Thread(() -> {
                try {
                    Thread.sleep((long) Math.random() * 100000);
                    System.out.println("RUNNER " + No + " arrived!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count.countDown();
                }
            });
            th.start();
        }
        count.await();
        System.out.println("Game Over!");
    }
}
