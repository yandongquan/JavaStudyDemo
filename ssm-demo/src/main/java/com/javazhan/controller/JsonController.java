package com.javazhan.controller;

import com.alibaba.dubbo.common.json.JSONArray;
import com.google.gson.Gson;
import com.javazhan.utils.ResponseTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:20 2018/4/3
 * @Modified By:
 */
@Controller
public class JsonController {

    @RequestMapping(value = "/json")
    @ResponseBody
    public String json() {
        Map map = new HashMap();
        map.put("code", "200");
        map.put("msg", "这是一句话，测试返回json是否乱码。");
        return new Gson().toJson(map);
    }

    @RequestMapping(value = "/producesToJson", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String producesToJson() {
        Map map = new HashMap();
        map.put("code", "200");
        map.put("msg", "这是一句话，测试返回json是否乱码。");
        return new Gson().toJson(map);
    }

    @RequestMapping(value = "/xmlToJson")
    @ResponseBody
    public String xmlToJson() {
        Map map = new HashMap();
        map.put("code", "200");
        map.put("msg", "这是一句话，测试返回json是否乱码。");
        return new Gson().toJson(map);
    }

    @RequestMapping(value = "/toolToJson")
    public void toolToJson(HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        map.put("code", "200");
        map.put("msg", "这是一句话，测试返回json是否乱码。");
        ResponseTool.write(response,new Gson().toJson(map));
    }

    @RequestMapping(value = "/classToJson")
    @ResponseBody
    public String classToJson() {
        Map map = new HashMap();
        map.put("code", "200");
        map.put("msg", "这是一句话，测试返回json是否乱码。");
        return new Gson().toJson(map);
    }
}
