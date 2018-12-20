package structural.bridge.concreteImplementor;

import structural.bridge.implementor.Shape;

public class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("draw circle" + "\nx:" + x + " y:" + y + " radius:" + radius);
    }
}
