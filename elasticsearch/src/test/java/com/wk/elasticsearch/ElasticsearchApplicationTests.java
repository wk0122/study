package com.wk.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.wk.elasticsearch.entity.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //创建索引
    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("study");
        createIndexRequest.timeout();
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
    }

    //索引是否存在
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("study");
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //获取索引
    @Test
    public void testGetIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("study");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse);
    }

    //删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("study");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }


    //添加文档
    @Test
    public void testAddDoc() throws IOException {
        User user = new User("wk",3);
        IndexRequest indexRequest = new IndexRequest("study");
        indexRequest.id("1").timeout("1s").source(JSON.toJSONString(user),XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index.toString());
    }

    //文档是否存在
    @Test
    public void testIsExist() throws IOException {
        GetRequest getRequest = new GetRequest("study","1");
        //不需要返回_source
        getRequest.fetchSourceContext(new FetchSourceContext(false)).storedFields("_none_");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //获取文档
    @Test
    public void testGetDoc() throws IOException {
        GetRequest getRequest = new GetRequest("study","1");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.toString());
    }

    //更新文档
    @Test
    public void testUpdateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("study","1");
        User user = new User("ddd",5);
        updateRequest.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.toString());
    }

    //删除文档
    @Test
    public void testDeleteDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("study","1");
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.toString());
    }

    //批量操作文档
    @Test
    public void testBulkDoc() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        List<User> users = new ArrayList<>();
        users.add(new User("wk1",1));
        users.add(new User("wk2",1));
        users.add(new User("wk3",2));
        users.add(new User("wk4",3));
        for (int i = 0; i <users.size() ; i++) {
            bulkRequest.add(
                    new IndexRequest("study")
                            .id(""+(i+1))
                            .source(JSON.toJSONString(users.get(i)),XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.toString());
    }

    //搜索文档
    @Test
    public void testSearchDoc() throws IOException {
        SearchRequest searchRequest = new SearchRequest("study");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(matchAllQueryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search.getHits()));
        System.out.println("=========");
        for (SearchHit searchHit : search.getHits()){
            System.out.println(searchHit.getSourceAsString());
        }
    }
}
