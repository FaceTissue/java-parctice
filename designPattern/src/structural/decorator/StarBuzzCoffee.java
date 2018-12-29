package structural.decorator;

import structural.decorator.component.Beverage;
import structural.decorator.concreteComponent.Espresso;
import structural.decorator.concreteComponent.HouseBlend;
import structural.decorator.concreteDecorator.Mocha;
import structural.decorator.concreteDecorator.Soy;
import structural.decorator.concreteDecorator.Whip;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
