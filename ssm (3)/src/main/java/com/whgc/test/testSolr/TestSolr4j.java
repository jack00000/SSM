package com.whgc.test.testSolr;
import java.io.IOException;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
 
public class TestSolr4j {
    public static void main(String[] args) throws SolrServerException, IOException {
//        List<Product> products = ProductUtil.file2list("D:\\140k_products.txt");
//        SolrUtil.batchSaveOrUpdate(products);
    	//高亮查询查询
        SolrUtil.queryHighlight("name:手机");
    }
}