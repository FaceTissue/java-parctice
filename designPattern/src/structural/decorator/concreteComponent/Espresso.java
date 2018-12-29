package structural.decorator.concreteComponent;

import structural.decorator.component.Beverage;

public class Espresso extends Beverage {
    public Espresso(int size) {
        description = "Espresso";
        this.size = size;
    }

    @Override
    public double cost() {
        double cost = 1.99;
        if (size == Beverage.TALL) {
            cost -= .5;
        } else if (size == Beverage.VENTI) {
            cost += .5;
        }
        return cost;
    }
}
