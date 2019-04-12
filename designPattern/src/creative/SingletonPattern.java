package creative;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.sayHello();
    }
}

class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    void sayHello() {
        System.out.println("hello, singleton");
    }
}
