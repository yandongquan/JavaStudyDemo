package com.javakz;

import com.google.gson.JsonObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 12:19 2018/3/8
 * @Modified By:
 */
public class CRUDTest {
    /**
     * 服务地址
     */
    private static String host = "192.168.0.113";
    /**
     * 端口
     */
    private static int port = 9300;
    private static TransportClient client = null;

    /**
     * 获取连接
     * @throws Exception
     */
    @Before
    public void getCient() throws Exception {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
    }

    /**
     * 关闭连接
     */
    @After
    public void close() {
        if (client!=null) {
            client.close();
        }
    }

    /**
     * 查询
     */
    @Test
    public void testGet() {
        GetResponse getResponse = client.prepareGet("三国演义","book","122").get();
        System.out.println(getResponse.getSourceAsString());
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title","三国");
        jsonObject.addProperty("price","120");
        jsonObject.addProperty("author","罗贯中2");

        UpdateResponse response = client.prepareUpdate("三国演义","book","122").setDoc(jsonObject.toString(), XContentType.JSON)
                .get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }

    /**
     * 删除
     */
    @Test
    public void toDelete() {
        DeleteResponse response = client.prepareDelete("三国演义","book","122").get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }
}
