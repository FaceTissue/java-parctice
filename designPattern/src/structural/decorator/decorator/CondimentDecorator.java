package structural.decorator.decorator;

import structural.decorator.component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
