package test201903;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();

        Callable<String> callable = new Thread3<>();
        FutureTask futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        new Thread(new Thread2()).start();
        System.out.println("------------------");

    }
}
class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.println(getClass().getName() + " print " + i);
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.println(getClass().getName() + " print " + i);
    }
}

class Thread3<V> implements Callable<V> {
    @Override
    public V call() {
        System.out.println("Hello Callable,FutureTask Thread!");
        return null;
    }
}
