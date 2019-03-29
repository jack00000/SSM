package com.whgc.util.springTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.TagsMapper;
import com.whgc.pojo.Paper;
import com.whgc.pojo.Tags;
import com.whgc.test.testSolr.Paper4solr;
import com.whgc.test.testSolr.SolrUtil;  
  
public class SpringTestSolr extends BaseJunit4Test{  
    @Autowired //自动注入  
    private  PaperMapper paperMapper;  
    @Autowired
    private  TagsMapper tagsMapper;
      
    @Test  
    @Transactional   //标明此方法需使用事务    
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚   
    public  void main() throws SolrServerException, IOException{  
        System.out.println("测试Spring整合Junit4进行单元测试");  
//        Paper user = paperMapper.get(1);
//        System.out.println(user);
//        System.out.println("------------"+user.getContent());
        System.out.println("查出List<paper>并添加到solr---------");
        List<Paper>papers=new ArrayList<>();
        papers=paperMapper.list();
        List<Paper4solr>paper4solrs=new ArrayList<>();
        for(Paper p:papers){
        	Paper4solr paper4solr=new Paper4solr();
        	paper4solr.setId(p.getId());
        	paper4solr.setUid(p.getUid());
        	paper4solr.setTitle(p.getTitle());
        	paper4solr.setContent(p.getContent());
        	paper4solr.setDescription(p.getDescription());
        	paper4solr.setUpdatetime(p.getUpdateTime());
        	List<Tags>tags=tagsMapper.getByPid(p.getId());
        	if(tags!=null){
        		StringBuffer tags2=new StringBuffer();
            	for(Tags  t:tags){
            		tags2.append(t.getName()+" ");
            	}
            	paper4solr.setTags(tags2.toString());
        	}
        	
        	paper4solrs.add(paper4solr);
        }
        SolrUtil.batchSaveOrUpdate(paper4solrs);
    }
}  