package wechat.fangzhipeng;

import java.io.*;

/***************************************************************************
 * @className: SerializableDemo
 * @date     : 2019/9/17 9:04
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class SerializableDemo {
    public static void main(String[] args) {
//        User user = new User();
//        user.setName("zhangsan");
//        user.setAge(20);
//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("F:\\code\\output\\tempFile1.txt"));
//            oos.writeObject(user);
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("F:\\code\\output\\tempFile1.txt"));
            User user1 = (User) ois.readObject();
            System.out.println(user1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public User() {
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
    public String toString() {
        return "User[name: " + this.name + ", age: " + this.age + "]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
    }
}
