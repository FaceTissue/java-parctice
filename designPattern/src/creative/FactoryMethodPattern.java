package creative;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.create();
        fruit.describe();
        fruitFactory = new BananaFactory();
        fruit = fruitFactory.create();
        fruit.describe();
    }
}

interface Fruit {
    void describe();
}

class Apple implements Fruit {
    @Override
    public void describe() {
        System.out.println("Apple");
    }
}

class Banana implements Fruit {
    @Override
    public void describe() {
        System.out.println("Banana");
    }
}

interface FruitFactory {
    Fruit create();
}

class AppleFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Apple();
    }
}

class BananaFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Banana();
    }
}
