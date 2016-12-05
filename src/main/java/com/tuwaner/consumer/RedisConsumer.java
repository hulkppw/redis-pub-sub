package com.tuwaner.consumer;

import com.tuwaner.utils.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class RedisConsumer {
    private Jedis jedis;

    private JedisPool jedisPool;

    public RedisConsumer(){
        jedisPool = RedisUtil.getPool();
        jedis = jedisPool.getResource();
    }

    public void consum(String channel){
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Channel: " + channel);
                System.out.println("Message: " + message.toString());
            }
            @Override
            public void onSubscribe(String channel, int subscribedChannels){
                System.out.println("onSubscribe: " + channel);
            }
            @Override
            public void onUnsubscribe(String channel, int subscribedChannels){
                System.out.println("onUnSubscribe: " + channel);
            }

        };
        jedis.subscribe(jedisPubSub, channel);
    }

    public void close(){
        jedis.close();
    }
}
