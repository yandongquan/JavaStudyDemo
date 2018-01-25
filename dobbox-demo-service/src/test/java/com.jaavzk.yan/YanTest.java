package com.jaavzk.yan;

import com.google.gson.Gson;
import com.javazk.Utils.HttpClientTool;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yandq
 * @Description: 测试类
 * @Date: Create in 9:57 2018/1/17
 * @Modified By:
 */
public class YanTest {

    public static void getDemo() {
        Map map = new HashMap();
        map.put("entrySceneName", "data比赛");
        String service = "http://127.0.0.1:20193/dobbodemo";
        String url = "/demoApi/demo";
        String result = HttpClientTool.sendPostRequest(service + url, new Gson().toJson(map));
        System.out.println("MAIN return :" + result);
    }

    public static void main(String[] args) {
        getDemo();
    }
}
