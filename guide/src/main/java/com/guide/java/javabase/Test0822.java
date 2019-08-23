package com.guide.java.javabase;

/***************************************************************************
 * @className: Test0822
 * @date     : 2019/8/22 17:09
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class Test0822 {
    public static void main(String[] args) {
        People people = new People("ls", 24);
        people.sayHello();
        Human human = new Human("ww", 20, "boy");
        System.out.println(human.toString());
    }
}
class People {
    private String name = "zs";
    private int age = 30;
    public static void sayHello() {
        System.out.println();
    }
    People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "People [name: " + name + ", age: " + age + "]";
    }
}
class Human extends People{
    private String sex;
    Human(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
