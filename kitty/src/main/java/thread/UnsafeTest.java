package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/***************************************************************************
 * @className: UnsafeTest
 * @date     : 2019/9/27 11:19
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class UnsafeTest {
    private static final sun.misc.Unsafe UNSAFE;
    static {
        try {
            Field field = Class.forName("sun.misc.Unsafe").getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new Error(e);
        }
    }
    public static void main(String[] args) {
        User user = new User("john", 20);
        System.out.println(user.toString());
        Field name = null;
        try {
            name = User.class.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        long nameOffset = UNSAFE.objectFieldOffset(name);
        UNSAFE.putObject(user, nameOffset, "pivot");
        System.out.println(user.toString());
    }
}

class User {
    private String name;
    private int age;
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "User[name:" + name + ", age:" + age + "]";
    }
}
