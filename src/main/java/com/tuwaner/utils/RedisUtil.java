package com.tuwaner.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class RedisUtil {

    /**
     * JedisPool
     */
    private static JedisPool jedisPool = null;

    /**
     * Redis Host
     */
    private final static String redisHost = ResourceBundle.getBundle("redis").getString("redis_host");

    /**
     * Redis Port
     */
    private final static int redisPort = Integer.parseInt(ResourceBundle.getBundle("redis").getString("redis_port"));

    /**
     * 初始化JedisPool
     *
     * @return
     */
    public static JedisPool getPool() {
        if (jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            // 最大连接数
            config.setMaxTotal(100);
            // 最大空闲连接数
            config.setMaxIdle(10);
            // 获取连接的等待时间
            config.setMaxWaitMillis(1000);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);
            // 逐出连接的最小空闲时间
            config.setMinEvictableIdleTimeMillis(600);

            jedisPool = new JedisPool(config, redisHost, redisPort);
        }

        return jedisPool;
    }

}
