package creative.factoryMethod.example1;

public class Client {
    public static void main(String[] args) {
        Computer computer = new GameComputer();
        computer.createHost();
        computer.createScreen();
        computer.createKeyboard();
        computer.createMouse();
    }
}
