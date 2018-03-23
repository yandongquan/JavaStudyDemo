package com.javazhan.controller;

import com.javazhan.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:46 2018/3/23
 * @Modified By:
 */
@Controller
public class FtlController {

    @RequestMapping("/ftl")
    public ModelAndView genHtml()throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Student> list = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setStudentNo("10001");
        student1.setName("张三");
        student1.setAge(23);
        list.add(student1);
        Student student2 = new Student();
        student2.setStudentNo("10002");
        student2.setName("张三2");
        student2.setAge(24);
        list.add(student2);
        Student student3 = new Student();
        student3.setStudentNo("10003");
        student3.setName("张三3");
        student3.setAge(21);
        list.add(student3);

        mv.addObject("studentList", list);
//        mv.setViewName("comment_template.ftl");
        // 配置加上这个<property name="suffix" value=".ftl" />
        mv.setViewName("comment_template");
        return mv;
    }
}
