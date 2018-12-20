package structural.bridge.abstraction;

import structural.bridge.implementor.Shape;

public abstract class Color {
    protected Shape shape;

    public Color(Shape shape) {
        this.shape = shape;
    }

    public abstract void draw();
}
