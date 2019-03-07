package creative.factoryMethod.example1;

public interface Computer {
    Host createHost();

    Screen createScreen();

    Keyboard createKeyboard();

    Mouse createMouse();
}
