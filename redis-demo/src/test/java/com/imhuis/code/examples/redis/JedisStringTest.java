package com.imhuis.code.examples.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

/**
 * @author: imhuis
 * @date: 2022/3/31
 * @description:
 */
@SpringBootTest
public class JedisStringTest {

    private static final Logger log = LoggerFactory.getLogger(JedisStringTest.class);

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test() {
        Jedis jedis = jedisPool.getResource();
        try {
            String result1 = jedis.set("string-key", "value");
            log.info("set key result1: {}", result1);

            String result2 = jedis.set("key-with-timeout", "value", new SetParams().ex(10L));
            log.info("result2: {}", result2);

            String result3 = jedis.set("key-not-exit", "value", new SetParams().nx());
            log.info("result3: {}", result3);
        } finally {
            jedis.close();
        }
    }


    @Test
    public void stringTest() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long some_words = jedis.append("key-append", "some words");
            log.info(" {}", some_words);
        }finally {
            jedis.close();
        }
    }

    @Test
    public void incrTest() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set("page_view", "10");
            Long pageView = jedis.incr("page_view");
            log.info("new pageView {}", pageView);

            jedis.set("decimal", "1");
            Double decimal = jedis.incrByFloat("decimal", 1.2);
            log.info("decimal {}", decimal);
        }finally {
            jedis.close();
        }
    }

    @Test
    public void rangeTest() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set("key-range", "Hello World");
            String value = jedis.getrange("key-range", 0, 5);
            log.info("rangeValue {}", value);
        }finally {
            jedis.close();
        }
    }

}
