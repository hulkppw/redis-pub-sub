package com.tuwaner.producer;

import com.tuwaner.domain.Message;
import com.tuwaner.utils.MessageUtil;
import com.tuwaner.utils.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class RedisProducer {

    private Jedis jedis;

    private JedisPool jedisPool;

    public RedisProducer(){
        jedisPool = RedisUtil.getPool();
        jedis = jedisPool.getResource();
    }

    public void provide(String channel, Message message){

        String messageStr = MessageUtil.objectToJson(message);
        jedis.publish(channel, messageStr);
    }

    public void close(){
        jedis.close();
    }
}
