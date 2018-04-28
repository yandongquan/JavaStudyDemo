package com.javakz.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 22:47 2018/4/28
 * @Modified By:
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        // 使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        // 根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.mycodes.net");
//        System.out.println(addr.getHostAddress());
//        System.out.println(addr.getHostName());
//
        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
