package inter.hw;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***************************************************************************
 * @className: PrintMission
 * @date     : 2019/12/30 13:55
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class PrintMission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int pos = input.nextInt();

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> qn = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                int temp = input.nextInt();
                q.add(temp);
                qn.add(j);
            }

            int time = 0;
            while (true) {
                int temp = q.poll();
                int num = qn.poll();
                if (goOnPrint(temp, q)) {
                    time++;
                    if (num == pos) {
                        break;
                    }
                } else {
                    q.add(temp);
                    qn.add(num);
                }
            }
            System.out.println(time);
        }
    }

    public static boolean goOnPrint(int t, Queue<Integer> q) {
        for (int v : q) {
            if (v > t) {
                return false;
            }
        }
        return true;
    }
}
