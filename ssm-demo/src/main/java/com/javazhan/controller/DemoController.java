package com.javazhan.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yando on 2017/11/30.
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
    public String demo() {
        Map map = new HashMap();
        map.put("这是我的网址：", "www.javazhan.com");
        return new Gson().toJson(map);
    }
}
