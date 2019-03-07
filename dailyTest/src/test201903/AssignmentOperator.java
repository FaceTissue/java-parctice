package test201903;

public class AssignmentOperator {
    public static void main(String[] args) {
//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Hel" + "lo";
//        String s4 = "Hel" + new String("lo");
//        String s5 = new String("Hello");
//        String s6 = s5.intern();
//        String s7 = "H";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        String s10 = "Hello";
//
//        System.out.println(s1 == s2);  // true
//        System.out.println(s1 == s3);  // true
//        System.out.println(s1 == s4);  // false
//        System.out.println(s1 == s9);  // false
//        System.out.println(s4 == s5);  // false
//        System.out.println(s1 == s6);  // true
//        System.out.println(s1 == s10);

//        String s = new String("1");
//        System.out.println(s.intern() == s);
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);

//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

        String str1 = new StringBuffer("计算机").append("shuju").toString();
        String str2 = new StringBuffer("计算机").append("shuju").toString();
        //jdk1.6的测试效果
        System.out.println(str1.intern()==str1);//false
        System.out.println(str2==str2.intern());//false

        //jdk1.7的测试效果
        System.out.println("---------------");
        System.out.println(str1.intern()==str1);//true
        System.out.println(str2==str2.intern());//false
        System.out.println(str1 == str2.intern());
        String str3 = "计算机shuju";
        System.out.println(str1 == str3);
        System.out.println("---------------");

        //jdk1.8的测试效果
        System.out.println(str1.intern()==str1);//true
        System.out.println(str2==str2.intern());//false

        String ms = new String("2") + new String("0");
        ms.intern();
        String ms1 = "20";
        String ms2 = "20";
        System.out.println(ms == ms1);
        System.out.println(ms == ms2);

        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String s5= s3.intern();
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
    }
}
