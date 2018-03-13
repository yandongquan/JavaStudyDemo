package com.javakz;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: yandq
 * @Description: 测试集群连接
 * @Date: Create in 15:02 2018/3/13
 * @Modified By:
 */
public class TestClusterCon {
    /**
     * 服务器地址
     */
    private static String host = "192.168.0.113";
    /**
     * 端口
     */
    private static int port = 9300;
    /**
     * 集群名称
     */
    private static String CLUSTER_NAME = "my-application";
    private static Settings.Builder settings = Settings.builder().put("cluster.name",CLUSTER_NAME);

    public static void main(String[] args) throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(settings.build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
        System.out.println(client);
        client.close();
    }
}
