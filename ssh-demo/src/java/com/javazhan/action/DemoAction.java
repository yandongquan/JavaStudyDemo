package com.javazhan.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by yando on 2017/11/29.
 */
@Controller
@Scope("prototype")
public class DemoAction extends ActionSupport {
    /**
     * Demo
     * @return
     */
    public String demo() {
        System.out.println("=====================");
        return SUCCESS;
    }

}
