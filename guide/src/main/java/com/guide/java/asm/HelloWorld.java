package com.guide.java.asm;

import org.junit.Test;

/***************************************************************************
 * @className: HelloWorld
 * @date     : 2019/10/28 15:24
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    @Test
    public void test() {
        String str1 = new StringBuilder("计算机").append("信息").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        String str3 = new StringBuilder("fo").append("r").toString();
        System.out.println(str3.intern() == str3);

//        String str3 = new String("hello");
//        System.out.println(str3.intern() == "hello");
    }
}
