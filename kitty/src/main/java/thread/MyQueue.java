package thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***************************************************************************
 * @className: MyQueue
 * @date     : 2019/9/28 11:10
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class MyQueue<E> {
    private Object[] obj;

    private int addIndex;
    private int removeIndex;
    private int queueSize;

    private Lock lock = new ReentrantLock();
    // 取代 wait notify
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

//    public MyQueue(int count) {
//        obj = new Object[count];
//    }
    public MyQueue() {}

    public void add(E e) {
        lock.lock();
        while (queueSize == obj.length) {
            try {
                addCondition.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        obj[addIndex] = e;

        if (++addIndex == obj.length) {
            addIndex = 0;
        }

        queueSize++;
        removeCondition.signal();
        lock.unlock();
    }

    public void remove() {
        lock.lock();

        while (queueSize == 0) {
            try {
                removeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obj[removeIndex] = null;

        if (++removeIndex == obj.length) {
            removeIndex = 0;
        }

        queueSize--;

        addCondition.signal();

        lock.unlock();
    }

    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("before await");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                }
                condition.await();
                System.out.println("after await");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                lock.lock();
                System.out.println("t2 get lock");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            condition.signal();
            lock.unlock();
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1 get lock");
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 try get lock");
            lock.lock();
            System.out.println("t2 get lock");
            lock.unlock();
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 try get lock");
            lock.lock();
            System.out.println("t3 get lock");
            lock.unlock();
        });
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        MyQueue<String> myQueue = new MyQueue<>(2);
//        new Thread(myQueue::remove).start();
//        System.out.println("first remove start");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("thread group start");
//        Thread[] t = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            final int idx = i;
//            if ((i & 1) == 0) {
//                t[i] = new Thread(() -> myQueue.add("add" + idx));
//            } else {
//                t[i] = new Thread(myQueue::remove);
//            }
//            t[i].start();
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(() -> myQueue.add("last add")).start();
//        for (int i = 0; i < 10; i++) {
//            try {
//                t[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
