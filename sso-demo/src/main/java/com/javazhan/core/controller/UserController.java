package com.javazhan.core.controller;

import com.google.gson.Gson;
import com.javazhan.core.model.dto.TUser;
import com.javazhan.core.model.pojo.ResponseData;
import com.javazhan.core.service.UserSv;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/user/check/{param}/{type}.html")
    @ResponseBody
    public String checkData(@PathVariable String param, @PathVariable String type) {
        int typeInt = 0;
        if (StringUtils.isNotEmpty(type)) {
            typeInt = Integer.parseInt(type);
        }

        ResponseData responseData = userSv.checkData(param, typeInt);
        String result = new Gson().toJson(responseData);
        return result;
    }

    @RequestMapping(value="/user/register.html", method= RequestMethod.POST)
    @ResponseBody
    public String register(TUser user) {
        ResponseData responseData = null;
        if (checkUser(user, responseData)) {
            responseData= userSv.createUser(user);
        }
        String result = new Gson().toJson(responseData);
        return result;
    }

    public boolean checkUser(TUser user, ResponseData responseData) {
        if (StringUtils.isBlank(user.getUserName())) {
            responseData = new ResponseData("2222", "用户名不能为空",null);
            return false;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            responseData =  new ResponseData("2222", "密码不能为空",null);
            return false;
        }
        //校验数据是否可用
        ResponseData resultCheck = userSv.checkData(user.getUserName(), 1);
        if ("0000".equals(resultCheck.getCode())) {
            responseData = new ResponseData("2222", "此用户名已经被使用",null);
            return false;
        }
        //校验电话是否可用
        if (StringUtils.isNotBlank(user.getPhone())) {
            resultCheck = userSv.checkData(user.getPhone(), 2);
            if ("0000".equals(resultCheck.getCode())) {
                responseData = new ResponseData("2222", "此手机号已经被使用",null);
                return false;
            }
        }
        //校验邮箱是否可用
        if (StringUtils.isNotBlank(user.getEmail())) {
            resultCheck = userSv.checkData(user.getEmail(), 3);
            if ("0000".equals(resultCheck.getCode())) {
                responseData = new ResponseData("2222", "此邮箱已经被使用",null);
                return false;
            }
        }
        return true;
    }

}
