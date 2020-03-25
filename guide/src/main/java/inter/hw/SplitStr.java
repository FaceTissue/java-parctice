package inter.hw;

import java.util.Scanner;

/***************************************************************************
 * @className: SplitStr
 * @date     : 2019/12/30 15:11
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class SplitStr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            for (int i = 0; i < count; i++) {
                String str = input.nextLine();
                if (str == null || str.length() == 0) continue;
                StringBuilder sb = new StringBuilder(str.trim());
                if (sb.length() % 8 != 0) {
                    int more = 8 - sb.length() % 8;
                    sb.append(String.format("%1$0" + more + "d", 0));
                }
                for (int j = 0; j < sb.length(); j += 8) {
                    System.out.println(sb.subSequence(j, j + 8));
                }
            }
        }
    }
}
