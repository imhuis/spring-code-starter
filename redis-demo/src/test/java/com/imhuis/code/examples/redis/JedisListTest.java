package com.imhuis.code.examples.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ListPosition;

import java.util.Arrays;
import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/3/31
 * @description:
 */
@SpringBootTest
public class JedisListTest {

    private static final Logger log = LoggerFactory.getLogger(JedisListTest.class);

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void listTest() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long length = jedis.lpush("list_key", "abc", "123", "@!!");
            log.info("length {}", length);

            String index = jedis.lindex("list_key", 2);
            log.info(" {}", index);

            Long result2 = jedis.lpushx("emply_list", "abc", "1");
            log.info("result2 {}", result2);

        }finally {
            jedis.close();
        }
    }

    @Test
    public void leftPushTest() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long length = jedis.lpush("left_key", "abc", "123", "@!!");
            log.info("length {}", length);

            String result2 = jedis.lpop("left_key");
            log.info(" {}", result2);

        }finally {
            jedis.close();
        }
    }


    @Test
    public void test2() {
        Jedis jedis = jedisPool.getResource();
        try {
//            Long length = jedis.lpush("left_key", "abc", "123", "@!!");
//            log.info("length {}", length);
//
//            String s = jedis.rpoplpush("left_key", "left_key");
//            log.info(" {}", s);

//            Long linsert = jedis.linsert("left_key", ListPosition.AFTER, "1234", "efg");
//            log.info(" {}", linsert);
            List<String> left_key = jedis.lrange("left_key", 1, -1);
            System.out.printf(Arrays.toString(left_key.toArray()));

        }finally {
            jedis.close();
        }
    }

}
