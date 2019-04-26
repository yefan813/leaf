package com.small.leaf.dao;

import com.small.leaf.dao.config.RedisConfig;
import com.small.leaf.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yefan
 * @Date: 2019/4/25 4:21 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfig.class)
public class RedisApplicationTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testRedisTemplate() {
        User user = new User();
        user.setId(1l);
        user.setName("hello");
        user.setNickName("你好");
        String redisKey = "user_1";
        redisTemplate.opsForValue().set(redisKey, user);

        User res = (User) redisTemplate.opsForValue().get(redisKey);
        System.out.println(res.toString());
    }

}
