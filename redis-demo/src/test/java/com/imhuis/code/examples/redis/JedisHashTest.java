package com.imhuis.code.examples.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: imhuis
 * @date: 2022/3/31
 * @description:
 */
@SpringBootTest
public class JedisHashTest {

    private static final Logger log = LoggerFactory.getLogger(JedisHashTest.class);

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long result1 = jedis.hset("user", "name", "zzyyyy");
            log.info("result1: {}", result1);
            Long result2 = jedis.hsetnx("user", "name", "zzyyyy");
            log.info("result2: {}", result2);
            Long hstrlen = jedis.hstrlen("user", "name");
            log.info("hstrlen: {}", hstrlen);
        }finally {
            jedis.close();
        }
    }

}
