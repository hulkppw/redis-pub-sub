package com.tuwaner.test;

import com.tuwaner.consumer.RedisConsumer;
import com.tuwaner.domain.Message;
import com.tuwaner.producer.RedisProducer;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class ProducerMain {
    public static void main(String[] args){

        RedisProducer producer = new RedisProducer();
        try {
            for (int i = 0; i < 100; i++){
                Message message = new Message();
                message.setTitle("hello!");
                message.setInfo("This is the "+i+" message");
                producer.provide("channel", message);
                Thread.sleep(2000);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }
    }
}
