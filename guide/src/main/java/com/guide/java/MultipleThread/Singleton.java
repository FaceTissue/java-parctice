package com.guide.java.MultipleThread;

/***************************************************************************
 * @className: Singleton
 * @date     : 2020/1/13 17:03
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 *
 * 多线程问题的根源在于：原子性、有序性、可见性
 ***********************************************************************/
public class Singleton {
    public static volatile Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
