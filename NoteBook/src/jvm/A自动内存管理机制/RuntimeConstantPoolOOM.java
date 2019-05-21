package jvm.A自动内存管理机制;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // jdk 1.6会报错，jck 1.7不报错
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }

        List<String> list = new ArrayList<>();
        String base = "string";
        while (true) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }

//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
//
//        String str3 = new String("1");
//        str3.intern();
//        String str4 = "1";
//        System.out.println(str3 == str4);
//
//        String str5 = new String("1") + new String("1");
//        String str5 = new String("11");
//        str5.intern();
//        String str6 = "11";
//        System.out.println(str5 == str6);
    }


}
