package thread.concurrent.locks;

/***************************************************************************
 * @className: Condition
 * @date     : 2019/9/26 14:35
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public interface Condition {
    void await() throws InterruptedException;

    void signal();
}
