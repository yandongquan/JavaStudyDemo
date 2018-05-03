package com.javakz.inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 8:28 2018/4/29
 * @Modified By:
 */
public class URLDemo {
    public static void main(String[] args) throws Exception {
        // 常用方法
        /*URL url = new URL("https://www.baidu.com:80?wd=java");
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("资源："+url.getFile());
        System.out.println("相对路径："+url.getPath());
        System.out.println("锚点："+url.getRef());
        System.out.println("参数："+url.getQuery());*/

        // 获取资源
        /*URL url = new URL("https://www.zbj.com");
        // 获取资源需要网络流
        InputStream is = url.openStream();
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }
        is.close();*/

        URL url = new URL("https://www.zbj.com");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        String msg = "";
        while ((msg=bufferedReader.readLine())!=null) {
            System.out.println(msg);
        }

        bufferedReader.close();

    }

}
