import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.io.Serializable;

/***************************************************************************
 * @className: RedisTest
 * @date     : 2019/9/17 10:25
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class RedisTest {
    @Test
    public void redisTest() {
        Jedis jedis = new Jedis("localhost", 6379, 100000);
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.close();
        }
        System.out.println("redis每秒操作:" + i + "次");
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        Student student = new Student();
        student.setName("lisi");
        student.setAge(21);
        redisTemplate.opsForValue().set("student_1", student);
        Student student1 = (Student) redisTemplate.opsForValue().get("student_1");
        student1.service();
    }
}

class Student implements Serializable {
    private String name;
    private int age;

    public void service() {
        System.out.println("学生名字为:" + name);
        System.out.println("学生年龄为:" + age);
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}