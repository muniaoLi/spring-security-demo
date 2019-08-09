package com.muniao.springsecuritydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest
{
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test1()
    {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("key1", "value1");

        Object obj = ops.get("key1");
        System.out.println(obj);
    }

    @Test
    public void test2()
    {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("key2", "value2");

        Object obj = ops.get("key2");
        System.out.println(obj);
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test3()
    {
        ValueOperations ops = stringRedisTemplate.opsForValue();
        ops.set("key3", "value3");

        Object obj = ops.get("key3");

        System.out.println(obj);
    }
}
