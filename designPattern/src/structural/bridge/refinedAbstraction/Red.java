package structural.bridge.refinedAbstraction;

import structural.bridge.abstraction.Color;
import structural.bridge.implementor.Shape;

public class Red extends Color {
    public Red(Shape shape) {
        super(shape);
    }

    public void draw() {
        shape.draw();
        System.out.println("color:" + "red");
    }
}
