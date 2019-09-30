package thread;

import java.util.concurrent.locks.LockSupport;

/***************************************************************************
 * @className: LoggingWidget
 * @date     : 2019/9/25 9:56
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class LoggingWidget extends Widget{
    public synchronized void doSomething() {
        System.out.println("LoggingWidget");
        super.doSomething();
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("myMainThread");
        Thread timer = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5000);
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                int noThreads = threadGroup.activeCount();
                Thread[] lstThreads = new Thread[noThreads];
                threadGroup.enumerate(lstThreads);
                Thread myMainThread = null;
                for (int i = 0; i < noThreads; i++) {
                    System.out.println("线程号：" + i + ";" + lstThreads[i].getName());
                    if ("myMainThread".equals(lstThreads[i].getName())) {
                        myMainThread = lstThreads[i];
                    }
                }
                System.out.println("------------------");
                LockSupport.unpark(myMainThread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timer.start();
        LoggingWidget l = new LoggingWidget();
        l.doSomething();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int noThreads = threadGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        threadGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++) {
            System.out.println("线程号：" + i + ";" + lstThreads[i].getName());
        }
        System.out.println("+++++++++++++++++++");
        LockSupport.park(l);
        System.out.println("结束了");
    }
}

class Widget {
    public synchronized void doSomething() {
        System.out.println("Widget");
    }
}
