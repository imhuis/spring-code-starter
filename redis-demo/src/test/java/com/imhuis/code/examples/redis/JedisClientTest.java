package com.imhuis.code.examples.redis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
public class JedisClientTest {

    private static final Logger log = LoggerFactory.getLogger(JedisClientTest.class);

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void clientInfo() {
        Jedis jedis = jedisPool.getResource();

        try {
            Long clientId = jedis.clientId();
            String clientInfo = jedis.clientInfo();

            log.info("[clientId]: {}", clientId);
            log.info("[clientInfo]: {}", clientInfo);
        }finally {
            jedis.close();
        }
    }

}
