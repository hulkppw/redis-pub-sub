package com.tuwaner.utils;

import com.google.gson.Gson;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class MessageUtil {

    private static Gson gson = new Gson();

    public static String objectToJson(Object obj){
        return gson.toJson(obj);
    }

    public static <T> T jsonToObject(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);

    }
}
