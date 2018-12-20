package structural.bridge.concreteImplementor;

import structural.bridge.implementor.Shape;

public class Triangle implements Shape {
    private int x, y, z;

    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public void draw() {
        System.out.println("draw triangle" + "\nx:" + x + " y:" + y + " z:" + z);
    }
}
