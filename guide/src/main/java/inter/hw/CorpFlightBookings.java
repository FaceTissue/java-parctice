package inter.hw;

/***************************************************************************
 * @className: CorpFlightBookings
 * @date     : 2019/12/30 14:51
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] order = new int[n];
        for (int[] v : bookings) {
            order[v[0] - 1] += v[2];
            if (v[1] < n) order[v[1]] -= v[2];
        }
        for (int i = 1; i < n; i++) {
            order[i] += order[i - 1];
        }
        return order;
    }
}
