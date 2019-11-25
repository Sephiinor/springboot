package com.example.ace;

import com.example.ace.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title:TestRedis.java</p >
 * <p>Description:RedisTest</p >
 *
 * @author Sephinor
 * @time 2019/11/25 20:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testObj() throws Exception {
        User user = new User("123@11.com","wx","123456","11","123");
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("com.ace",user);
        operations.set("com.ace.wx",user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.ace.wx");
        if(exists){
            System.out.println("it exists");
        }else{
            System.out.println("it does not exists");
        }

    }
}
