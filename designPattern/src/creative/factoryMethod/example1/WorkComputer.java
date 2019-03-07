package creative.factoryMethod.example1;

public class WorkComputer implements Computer{
    @Override
    public Host createHost() {
        return new Lenovo();
    }

    @Override
    public Screen createScreen() {
        return new CRTScreen();
    }

    @Override
    public Keyboard createKeyboard() {
        return new ThinFilmKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new LogitechMouse();
    }
}
