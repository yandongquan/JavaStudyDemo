package com.javazhan.html;

import com.javazhan.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class FreemarkerTest {
    public static void main(String[] args) {
        try {
            // 生成静态页面
            genItemHtml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void genItemHtml() throws IOException, TemplateException {
        // 创建一个Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 设置config对象模板文件存放的路径。
        configuration.setDirectoryForTemplateLoading(new File("D:\\Work\\Workspaces\\IdeaProjects\\Git\\JavaStudyDemo\\freemarker-demo\\src\\main\\resources\\ftl\\"));
        // 设置编码
        configuration.setDefaultEncoding("utf-8");
        // 定义模板名字
        Template template = configuration.getTemplate("first.ftl");
        // 创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。

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

        // 创建一个Writer对象，指定生成的文件保存的路径及文件名。
        Writer out = new FileWriter(new File("D:\\Work\\Workspaces\\IdeaProjects\\Git\\JavaStudyDemo\\freemarker-demo\\src\\main\\resources\\html\\hello.html"));
        // 调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
        template.process(root, out);
        // 关闭writer对象。
        out.flush();
        out.close();
    }
}
