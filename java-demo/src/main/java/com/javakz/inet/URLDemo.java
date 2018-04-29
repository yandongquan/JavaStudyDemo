package com.javakz.inet;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 8:28 2018/4/29
 * @Modified By:
 */
public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.baidu.com:80?wd=java");
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("资源："+url.getFile());
        System.out.println("相对路径："+url.getPath());
        System.out.println("锚点："+url.getRef());
        System.out.println("参数："+url.getQuery());
    }

}
