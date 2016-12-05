package com.tuwaner.test;

import com.tuwaner.consumer.RedisConsumer;
import com.tuwaner.domain.Message;
import com.tuwaner.producer.RedisProducer;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class RedisMain {
    public static void main(String[] args){
        RedisConsumer consumer = new RedisConsumer();
        try {
            while (true){
                consumer.consum("channel");

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            consumer.close();
        }
    }
}
