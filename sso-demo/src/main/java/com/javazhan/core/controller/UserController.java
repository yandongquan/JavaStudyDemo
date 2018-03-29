package com.javazhan.core.controller;

import com.javazhan.core.constant.Constants;
import com.javazhan.core.model.dto.TUser;
import com.javazhan.core.model.pojo.ResponseData;
import com.javazhan.core.service.UserSv;
import com.javazhan.utils.CookieUtils;
import com.javazhan.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 9:52 2018/3/27
 * @Modified By:
 */
@Controller
public class UserController {

    @Autowired
    private UserSv userSv;
    @Value("${COOKIE_TOKEN_KEY}")
    private String COOKIE_TOKEN_KEY;


    /**
     * 通过token登录
     * @param token
     * @return
     */
    @RequestMapping(value="/user/token/{token}.html", method = RequestMethod.GET)
    @ResponseBody
    public String token(@PathVariable String token, String callback) {
        ResponseData responseData = userSv.getUserByToken(token);
        if (StringUtils.isNotEmpty(callback)) {
            String strResult = callback + "(" + JsonUtils.objectToJson(responseData) + ");";
            return strResult;
        }
        String result = JsonUtils.objectToJson(responseData);
        return result;
    }

    /**
     * 注销
     * @param token
     * @return
     */
    @RequestMapping(value="/user/logon/{token}.html")
    @ResponseBody
    public String logon(@PathVariable String token) {
        ResponseData responseData = userSv.logon(token);
        String result = JsonUtils.objectToJson(responseData);
        return result;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String userName, String password, HttpServletRequest request, HttpServletResponse response) {

        ResponseData responseData = userSv.login(userName, password);
        if (Constants.DIGITAL_0000.equals(responseData.getCode())) {
            // 从返回结果中取 token，写入 cookie。Cookie 要跨域。
            String token = responseData.getData();
            CookieUtils.setCookie(request, response, COOKIE_TOKEN_KEY, token);
        }
        String result = JsonUtils.objectToJson(responseData);
        return result;
    }

    @RequestMapping("/user/check/{param}/{type}.html")
    @ResponseBody
    public String checkData(@PathVariable String param, @PathVariable String type) {
        int typeInt = 0;
        if (StringUtils.isNotEmpty(type)) {
            typeInt = Integer.parseInt(type);
        }

        ResponseData responseData = userSv.checkData(param, typeInt);
        String result = JsonUtils.objectToJson(responseData);
        return result;
    }

    @RequestMapping(value="/user/register.html", method= RequestMethod.POST)
    @ResponseBody
    public String register(TUser user) {
        ResponseData responseData = new ResponseData();
        if (checkUser(user, responseData)) {
            responseData= userSv.insertUser(user);
        }
        String result = JsonUtils.objectToJson(responseData);
            return result;
    }

    public boolean checkUser(TUser user, ResponseData responseData) {
        if (StringUtils.isBlank(user.getUserName())) {
            responseData.setCode("2222");
            responseData.setMsg("用户名不能为空");
            return false;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            responseData.setCode("2222");
            responseData.setMsg("密码不能为空");
            return false;
        }
        //校验数据是否可用
        ResponseData resultCheck = userSv.checkData(user.getUserName(), 1);
        if (Constants.DIGITAL_0000.equals(resultCheck.getCode())) {
            responseData.setCode("2222");
            responseData.setMsg("此用户名已经被使用");
            return false;
        }
        //校验电话是否可用
        if (StringUtils.isNotBlank(user.getPhone())) {
            resultCheck = userSv.checkData(user.getPhone(), 2);
            if (Constants.DIGITAL_0000.equals(resultCheck.getCode())) {
                responseData.setCode("2222");
                responseData.setMsg("此手机号已经被使用");
                return false;
            }
        }
        //校验邮箱是否可用
        if (StringUtils.isNotBlank(user.getEmail())) {
            resultCheck = userSv.checkData(user.getEmail(), 3);
            if (Constants.DIGITAL_0000.equals(resultCheck.getCode())) {
                responseData.setCode("2222");
                responseData.setMsg("此邮箱已经被使用");
                return false;
            }
        }
        return true;
    }

}
