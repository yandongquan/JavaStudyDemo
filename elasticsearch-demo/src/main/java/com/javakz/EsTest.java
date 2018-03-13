package com.javakz;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:14 2018/3/8
 * @Modified By:
 */
public class EsTest {
    /**
     * 服务地址
     */
    private static String host = "192.168.122.128";
    /**
     * 端口
     */
    private static int port = 9300;
    public static void main(String[] args) throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsTest.host),port));
        System.out.println(client);
        client.close();
    }
}
