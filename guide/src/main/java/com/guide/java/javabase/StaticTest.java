package com.guide.java.javabase;

/***************************************************************************
 * @className: StaticTest
 * @date     : 2019/8/22 17:18
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
        StaticTest staticTest = new StaticTest();
    }
    static StaticTest st = new StaticTest();
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }
    public static void staticFunction() {
        System.out.println("4");
    }
    int a = 100;
    static int b = 112;
    //
}
