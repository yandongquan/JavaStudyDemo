package com.javazhan.controller;

import com.javazhan.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.*;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 17:48 2018/3/22
 * @Modified By:
 */
@RestController
public class HtmlGenController {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/genhtml/{id}")
    public String genHtml(@PathVariable("id") String id)throws Exception {
        // 1、从 spring 容器中获得 FreeMarkerConfigurer 对象。
        // 2、从 FreeMarkerConfigurer 对象中获得 Configuration 对象。
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setDefaultEncoding("utf-8");
        // 3、使用 Configuration 对象获得 Template 对象
        Template template = configuration.getTemplate("hello.ftl");
        // 4、创建数据集
        Map<String, Object> root = new HashMap<String, Object>();
        // 1）访问 map 中的 key
        root.put("hello", "hello freemarker");

        // 2）访问 pojo 中的属性
        Student student = new Student();
        student.setStudentNo("10001");
        student.setName("张三");
        student.setAge(23);
        root.put("student", student);

        // 3）取集合中的数据
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

        root.put("studentList", list);

        // 6）日期类型格式化
        root.put("date", new Date());

        // 7）Null 值的处理
        root.put("list", null);

        // 5、创建输出文件的 Writer 对象。
        Writer out = new BufferedWriter( new OutputStreamWriter( new FileOutputStream("D:/Work/Workspaces/IdeaProjects/Git/JavaStudyDemo/freemaker-spring-demo/src/main/resources/html/GOODS"+id+".html"), "UTF-8"));
        // 下面的会乱码
//        Writer out = new FileWriter(new File("D:/Work/Workspaces/IdeaProjects/Git/JavaStudyDemo/freemaker-spring-demo/src/main/resources/html/GOODS"+id+".html"));
        // 6、调用模板对象的 process 方法，生成文件。
        template.process(root, out);
        // 7、关闭流。
        out.close();
        return "OK";

    }
}
