package creative;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        KeyboardsFactory keyboardsFactory = new GameKeyboardsFactory();
        keyboardsFactory.createKeyboard().describe();
        keyboardsFactory.createMouse().describe();
        keyboardsFactory = new WorkKeyboardsFactory();
        keyboardsFactory.createKeyboard().describe();
        keyboardsFactory.createMouse().describe();
    }
}

interface Keyboard {
    void describe();
}

class Mechanics implements Keyboard {
    @Override
    public void describe() {
        System.out.println("Mechanical keyboard");
    }
}

class Membrane implements Keyboard {
    @Override
    public void describe() {
        System.out.println("Membrane keyboard");
    }
}

interface Mouse {
    void describe();
}

class Wireless implements Mouse {
    @Override
    public void describe() {
        System.out.println("Wireless mouse");
    }
}

class Wired implements Mouse {
    @Override
    public void describe() {
        System.out.println("Wired mouse");
    }
}

interface KeyboardsFactory {
    Keyboard createKeyboard();

    Mouse createMouse();
}

class GameKeyboardsFactory implements KeyboardsFactory {
    @Override
    public Keyboard createKeyboard() {
        return new Mechanics();
    }

    @Override
    public Mouse createMouse() {
        return new Wired();
    }
}

class WorkKeyboardsFactory implements KeyboardsFactory {
    @Override
    public Keyboard createKeyboard() {
        return new Membrane();
    }

    @Override
    public Mouse createMouse() {
        return new Wireless();
    }
}
