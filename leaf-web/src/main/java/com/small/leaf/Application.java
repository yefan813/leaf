package com.small.leaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisHash;

/**
 * @Author: yefan
 * @Date: 2019/4/23 11:40 AM
 */
@SpringBootApplication
@MapperScan("com.small.leaf.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
