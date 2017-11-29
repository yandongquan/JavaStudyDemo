package com.javazhan.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yando on 2017/11/29.
 */
@Controller
public class DemoController {
    @RequestMapping("/demo")
    public ModelAndView view(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
