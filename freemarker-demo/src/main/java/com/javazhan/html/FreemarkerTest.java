package com.javazhan.html;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

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
        root.put("hello", "hello freemarker");
        // 创建一个Writer对象，指定生成的文件保存的路径及文件名。
        Writer out = new FileWriter(new File("D:\\Work\\Workspaces\\IdeaProjects\\Git\\JavaStudyDemo\\freemarker-demo\\src\\main\\resources\\html\\hello.html"));
        // 调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
        template.process(root, out);
        // 关闭writer对象。
        out.flush();
        out.close();
    }
}
