package com.guide.java.javabase;

/***************************************************************************
 * @className: ThreadTest
 * @date     : 2019/8/23 9:10
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class ThreadTest {
    public void function() {
        final String a = "b";
        new Thread() {
            @Override
            public void run() {
                System.out.println(a);
            }
        }.start();
    }

    public static void main(String[] args) {
        new ThreadTest().function();
    }
}
