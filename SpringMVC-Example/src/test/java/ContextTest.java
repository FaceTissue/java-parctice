import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***************************************************************************
 * @className: ContextTest
 * @date     : 2019/8/30 18:45
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class ContextTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/spring/security/spring-shiro.xml");
        System.out.println("ac = " + ac);
    }
}
