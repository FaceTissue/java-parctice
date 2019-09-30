package com.guide.java.javabase;

import org.junit.Test;

import java.util.HashSet;

/***************************************************************************
 * @className: Base
 * @date     : 2019/9/17 15:59
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class Base {
    // 27.HashCode与equals
    @Test
    public void test27() {
        User user1 = new User("zhangsan", 20);
        User user2 = new User("zhangsan", 20);
        System.out.println(user1.equals(user2));
        System.out.println(user1 == user2);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        HashSet<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        System.out.println(set);
    }

}
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public String toString() {
        return name + "-" + age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ age;
    }
}
