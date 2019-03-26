package test201903;

public class BinaryCodeTest {
    public static void main(String[] args) {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(2, 3, 5);
        int c = point1.area(point2);
        System.out.println(c);
    }
}

class Point {
    private int x, y, z;
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int area(Point b) {
        int length = Math.abs(this.x - b.x);
        int width = Math.abs(this.y - b.y);
        int heigth = Math.abs(this.z - b.z);
        return length * width * heigth;
    }
}
