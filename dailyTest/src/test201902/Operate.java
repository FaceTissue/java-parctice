package test201902;

public class Operate {
    public static void main(String[] args) {
        byte b = 120;
        b += 8; // b = (byte) (b + 8);
        System.out.println(b);
        // 数值在计算机中是以补码的形式存在的，所谓强制转换就是字面意思
        System.out.println((byte) -129);
        System.out.println((byte) 129);
        System.out.println((byte) 255);
        System.out.println((byte) 256);
        System.out.println((byte) -256);
        System.out.println((byte) 512);
    }
}
