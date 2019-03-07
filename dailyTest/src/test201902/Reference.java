package test201902;

public class Reference {
    public static void main(String[] args) {
        // boxing 和 unboxing的本质是 ???
        Integer i1 = 128; // Integer i1 = Integer.valueOf(128);
        Integer i2 = 128;
        Integer i3 = 127;
        Integer i4 = 127;
        Integer i5 = new Integer(127);
        Integer i6 = new Integer(127);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i5 == i6);
    }
}
