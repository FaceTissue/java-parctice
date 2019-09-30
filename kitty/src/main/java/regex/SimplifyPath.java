package regex;

import org.junit.Test;

/***************************************************************************
 * @className: SimplifyPath
 * @date     : 2019/9/29 17:08
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] signals = path.split("/");
        StringBuilder res = new StringBuilder();
        for (String signal : signals) {
            String sat = signal.trim();
            if ("..".equals(sat)) {
                if (res.length() > 0) {
                    res.delete(res.lastIndexOf("/"), res.length());
                }
            } else if (!"".equals(sat) && !".".equals(sat)) {
                res.append("/").append(sat);
            }
        }
        if (res.length() == 0) {
            res.append("/");
        }
        return res.toString();
    }

    @Test
    public void simplifyPathTest() {
        String str = "/home/";
        System.out.println(simplifyPath(str));
        str = "/../";
        System.out.println(simplifyPath(str));
        str = "/home//foo/";
        System.out.println(simplifyPath(str));
        str = "/a/./b/../../c/";
        System.out.println(simplifyPath(str));
        str = "/a/../../b/../c//.//";
        System.out.println(simplifyPath(str));
        str = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(str));
    }
}
