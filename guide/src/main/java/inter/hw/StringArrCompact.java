package inter.hw;

import org.junit.Test;

import java.util.Scanner;

/***************************************************************************
 * @className: StringArrCompact
 * @date     : 2019/12/30 17:46
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class StringArrCompact {
    public static void main(String[] args) {
        compact();
    }

    public static void compact() {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (null == str || str.length() == 0) continue;
            str = str.trim();

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < str.length();) {
                int count = 1;
                while (++i < str.length() && str.charAt(i) == str.charAt(i - 1)) count++;
                if (count > 1) res.append(count);
                res.append(str.charAt(i - 1));
            }
            System.out.println(res);
        }
    }
}
