import org.junit.Test;

public class Test201904 {
    @Test
    public void sayHello() {
        System.out.println("hello kitty");
    }


    @Test
    public void char2Int() {
        char c = '1';
        int a = Integer.parseInt("123");
        System.out.println(a);
        System.out.println(Character.digit('z', 36));
        System.out.println((int) c);
        System.out.println((int) c >>> 8);
        System.out.println((int) c >>> 16);
        System.out.println(8 >>> 2);
        System.out.println((int) '0');
        System.out.println((int) '9');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println(1 << 8);
        System.out.println((char) 256);
        System.out.println((char) 127);
        System.out.println((int) -'1');
        System.out.println(Character.digit('1', 10));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-2147483648));
    }

    @Test
    public void tst() {
        System.out.println("hello".indexOf(""));
    }
}
