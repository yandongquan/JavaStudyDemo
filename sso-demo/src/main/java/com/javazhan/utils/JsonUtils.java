package com.javazhan.utils;

import com.google.gson.Gson;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 17:52 2018/3/29
 * @Modified By:
 */
public class JsonUtils {

    public static <T> T jsonToObject(String json, Class<T> tClass) {
        return new Gson().fromJson(json, tClass);
    }

    public static String objectToJson(Object object) {
        return new Gson().toJson(object);
    }

    public static void main(String[] args) {
        System.out.println(JsonUtils.objectToJson("123"));
        System.out.println(JsonUtils.jsonToObject("123", String.class));
    }
}
