package cn.rumoss.fw.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testInsert(){
        String name = "Tanijia";
        redisTemplate.opsForValue().set("name",name);
    }

    @Test
    public void testQuery(){
        String name = null;
        name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name from redis: " + name);
    }

}
