package thread.concurrent.locks;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/***************************************************************************
 * @className: LockSupport
 * @date     : 2019/9/26 14:41
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class LockSupport {
    private LockSupport() {}

    private static void setBlocker(Thread t, Object arg) {
        UNSAFE.putObject(t, parkBlockerOffset, arg);
    }

    public static void park() {
        UNSAFE.park(false, 0L);
    }

    public static void park(Object blocker) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        UNSAFE.park(false, 0L);
        setBlocker(t, null);
    }

    public static void unpark(Thread thread) {
        if (thread != null) {
            UNSAFE.unpark(thread);
        }
    }

    private static final sun.misc.Unsafe UNSAFE;
    private static final long parkBlockerOffset;
    static {
        try {
            Field field = Class.forName("sun.misc.Unsafe").getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            Class<?> tk = Thread.class;
            parkBlockerOffset = UNSAFE.objectFieldOffset(tk.getDeclaredField("parkBlocker"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
