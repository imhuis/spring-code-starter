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
public class JedisSetTest {


    private static final Logger log = LoggerFactory.getLogger(JedisSetTest.class);

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test3() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long key1 = jedis.sadd("a_key", "abc", "123", "@!!");
            log.info("length {}", key1);


            Long key2 = jedis.sadd("b_key", "abc", "1234", "#@!!");
            log.info("length {}", key2);

            Long sdiffstore = jedis.sdiffstore("c_key", "b_key", "a_key");
            log.info(" {}", sdiffstore);

//            Long linsert = jedis.linsert("left_key", ListPosition.AFTER, "1234", "efg");
//            List<String> left_key = jedis.lrange("left_key", 1, -1);
//            System.out.printf(Arrays.toString(left_key.toArray()));

        }finally {
            jedis.close();
        }
    }

}
