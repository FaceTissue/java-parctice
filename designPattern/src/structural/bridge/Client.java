package structural.bridge;

import structural.bridge.abstraction.Color;
import structural.bridge.concreteImplementor.Circle;
import structural.bridge.concreteImplementor.Triangle;
import structural.bridge.refinedAbstraction.Red;

public class Client {
    public static void main(String[] args) {
        Color redCircle = new Red(new Circle(0, 0, 10));
        Color redTriangle = new Red(new Triangle(3, 4, 5));
        redCircle.draw();
        redTriangle.draw();
    }
}
