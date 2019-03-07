package creative.factoryMethod.example1;

public class GameComputer implements Computer{
    @Override
    public Host createHost() {
        return new Aliens();
    }

    @Override
    public Screen createScreen() {
        return new LCDScreen();
    }

    @Override
    public Keyboard createKeyboard() {
        return new MechanicalKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new RazerMouse();
    }
}
