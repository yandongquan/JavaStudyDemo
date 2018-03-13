package com.javakz;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @Author: yandq
 * @Description: 测试集群索引
 * @Date: Create in 15:09 2018/3/13
 * @Modified By:
 */
public class TestClusterIndex {
    /**
     * 服务地址
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
    private static TransportClient client = null;

    @Before
    public void getCient()throws Exception{
        client = new PreBuiltTransportClient(settings.build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
    }

    @After
    public void close(){
        if(client!=null){
            client.close();
        }
    }
    /**
     * filter过滤；票价必须少于40
     * @throws Exception
     */
    @Test
    public void testFilter() throws Exception {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("film2").setTypes("dongzuo");
        QueryBuilder queryBuilder1 = QueryBuilders.matchPhraseQuery("title","战");
        QueryBuilder queryBuilder2 = QueryBuilders.rangeQuery("price").lte(40);
        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.boolQuery()
                .must(queryBuilder1)
                .filter(queryBuilder2)).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit searchHit:searchHits) {
            System.out.println(searchHit.getSourceAsString());
        }
    }
    /**
     * should使用 提高得分
     * @throws Exception
     */
    @Test
    public void testShould() throws Exception {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("film2").setTypes("dongzuo");
        QueryBuilder queryBuilder1 = QueryBuilders.matchPhraseQuery("title","战");
        QueryBuilder queryBuilder2 = QueryBuilders.matchPhraseQuery("context","星球");
        QueryBuilder queryBuilder3 = QueryBuilders.rangeQuery("publishDate").gt("2018-01-01");
        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.boolQuery()
                        .must(queryBuilder1)
                        .should(queryBuilder2)
                        .should(queryBuilder3)).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit searchHit:searchHits) {
            System.out.println(searchHit.getScore()+"："+searchHit.getSourceAsString());
        }
    }
    /**
     * 模糊查询标题含有“战”
     * @throws Exception
     */
    @Test
    public void testFuzzyQuery() throws Exception {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("film2").setTypes("dongzuo");
        QueryBuilder queryBuilders1 = QueryBuilders.matchPhraseQuery("title","战");
        QueryBuilder queryBuilders2 = QueryBuilders.matchPhraseQuery("content","星球");
        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.boolQuery()
            .must(queryBuilders1)
            .must(queryBuilders2))
                .execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit searchHit:searchHits) {
            System.out.println(searchHit.getSourceAsString());
        }
    }

    /**
     * 创建索引 添加文档
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        JsonArray jsonArray=new JsonArray();

        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("title", "前任3：再见前任");
        jsonObject.addProperty("publishDate", "2017-12-29");
        jsonObject.addProperty("content", "一对好基友孟云（韩庚 饰）和余飞（郑恺 饰）跟女友都因为一点小事宣告分手，并且“拒绝挽回，死不认错”。两人在夜店、派对与交友软件上放飞人生第二春，大肆庆祝“黄金单身期”，从而引发了一系列好笑的故事。孟云与女友同甘共苦却难逃“五年之痒”，余飞与女友则棋逢敌手相爱相杀无绝期。然而现实的“打脸”却来得猝不及防：一对推拉纠结零往来，一对纠缠互怼全交代。两对恋人都将面对最终的选择：是再次相见？还是再也不见？");
        jsonObject.addProperty("director", "田羽生");
        jsonObject.addProperty("price", "35");
        jsonArray.add(jsonObject);


        JsonObject jsonObject2=new JsonObject();
        jsonObject2.addProperty("title", "机器之血");
        jsonObject2.addProperty("publishDate", "2017-12-29");
        jsonObject2.addProperty("content", "2007年，Dr.James在半岛军火商的支持下研究生化人。研究过程中，生化人安德烈发生基因突变大开杀戒，将半岛军火商杀害，并控制其组织，接管生化人的研究。Dr.James侥幸逃生，只好寻求警方的保护。特工林东（成龙 饰）不得以离开生命垂危的小女儿西西，接受证人保护任务...十三年后，一本科幻小说《机器之血》的出版引出了黑衣生化人组织，神秘骇客李森（罗志祥 饰）（被杀害的半岛军火商的儿子），以及隐姓埋名的林东，三股力量都开始接近一个“普通”女孩Nancy（欧阳娜娜 饰）的生活，想要得到她身上的秘密。而黑衣人幕后受伤隐藏多年的安德烈也再次出手，在多次缠斗之后终于抓走Nancy。林东和李森，不得不以身犯险一同前去解救，关键时刻却发现李森竟然是被杀害的半岛军火商的儿子，生化人的实验记录也落入了李森之手......");
        jsonObject2.addProperty("director", "张立嘉");
        jsonObject2.addProperty("price", "45");
        jsonArray.add(jsonObject2);

        JsonObject jsonObject3=new JsonObject();
        jsonObject3.addProperty("title", "星球大战8：最后的绝地武士");
        jsonObject3.addProperty("publishDate", "2018-01-05");
        jsonObject3.addProperty("content", "《星球大战：最后的绝地武士》承接前作《星球大战：原力觉醒》的剧情，讲述第一军团全面侵袭之下，蕾伊（黛西·雷德利 Daisy Ridley 饰）、芬恩（约翰·博耶加 John Boyega 饰）、波·达默龙（奥斯卡·伊萨克 Oscar Isaac 饰）三位年轻主角各自的抉 择和冒险故事。前作中觉醒强大原力的蕾伊独自寻访隐居的绝地大师卢克·天行者（马克·哈米尔 Mark Hamill 饰），在后者的指导下接受原力训练。芬恩接受了一项几乎不可能完成的任务，为此他不得不勇闯敌营，面对自己的过去。波·达默龙则要适应从战士向领袖的角色转换，这一过程中他也将接受一些血的教训。");
        jsonObject3.addProperty("director", "莱恩·约翰逊");
        jsonObject3.addProperty("price", "55");
        jsonArray.add(jsonObject3);

        JsonObject jsonObject4=new JsonObject();
        jsonObject4.addProperty("title", "羞羞的铁拳");
        jsonObject4.addProperty("publishDate", "2017-12-29");
        jsonObject4.addProperty("content", "靠打假拳混日子的艾迪生（艾伦 饰），本来和正义感十足的体育记者马小（马丽 饰）是一对冤家，没想到因为一场意外的电击，男女身体互换。性别错乱后，两人互坑互害，引发了拳坛的大地震，也揭开了假拳界的秘密，惹来一堆麻烦，最终两人在“卷莲门”副掌门张茱萸（沈腾 饰）的指点下，向恶势力挥起了羞羞的铁拳。");
        jsonObject4.addProperty("director", "宋阳 / 张吃鱼");
        jsonObject4.addProperty("price", "35");
        jsonArray.add(jsonObject4);

        JsonObject jsonObject5=new JsonObject();
        jsonObject5.addProperty("title", "战狼2");
        jsonObject5.addProperty("publishDate", "2017-07-27");
        jsonObject5.addProperty("content", "故事发生在非洲附近的大海上，主人公冷锋（吴京 饰）遭遇人生滑铁卢，被“开除军籍”，本想漂泊一生的他，正当他打算这么做的时候，一场突如其来的意外打破了他的计划，突然被卷入了一场非洲国家叛乱，本可以安全撤离，却因无法忘记曾经为军人的使命，孤身犯险冲回沦陷区，带领身陷屠杀中的同胞和难民，展开生死逃亡。随着斗争的持续，体内的狼性逐渐复苏，最终孤身闯入战乱区域，为同胞而战斗。");
        jsonObject5.addProperty("director", "吴京");
        jsonObject5.addProperty("price", "38");
        jsonArray.add(jsonObject5);

        for(int i=0;i<jsonArray.size();i++){
            JsonObject jo=jsonArray.get(i).getAsJsonObject();
            IndexResponse response=client.prepareIndex("film2", "dongzuo")
                    .setSource(jo.toString(), XContentType.JSON).get();
            System.out.println("索引名称："+response.getIndex());
            System.out.println("类型："+response.getType());
            System.out.println("文档ID："+response.getId());
            System.out.println("当前实例状态："+response.status());
        }
    }
}
