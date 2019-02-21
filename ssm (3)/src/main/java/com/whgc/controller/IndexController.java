package com.whgc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.TagsMapper;
import com.whgc.pojo.Paper;
import com.whgc.pojo.Tags;
import com.whgc.pojoData.IndexData;
import com.whgc.util.Md2html;
import com.whgc.util.Page;

/**
 * index 界面的文章数据的获取
 * 
 * @author esesoft
 *
 */
@Controller
@ResponseBody
@RequestMapping("")
public class IndexController {
	@Autowired
	PaperMapper paperMapper;
	TagsMapper tagsMapper;

	@RequestMapping("/getPapersJson")
	public String listCategory(Page page) {
		List<Paper> papers = paperMapper.list();
		return JSONObject.toJSONString(papers);
	}
    /**
     * 数据库存储文件路径
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
	@RequestMapping("/prepareData")
	public String prepareDate() throws FileNotFoundException, IOException{
		//1.把所有的md文件内容转换为 html格式存在文件中
		List<String>contents=new ArrayList<>();
		List<String>files=Md2html.readfile("D:\\_posts");
		//2.将contents分成不同用户和分类  模拟数据
		int count=0;
		for(String s2:files){
			if(count<10){
				//1.向paper表插入数据
				Paper paper=new Paper();
				
				paper.setUid(1);//用户id
				paper.setCid(1);//分类id
				paper.setTitle("标题1");
				paper.setDescription("这是描述1");
				paper.setContent(s2);
				//获取当前时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				paper.setUpdateTime(df.format(new Date()));// new Date()为获取当前系统时间
				paperMapper.add(paper);
//				//2.向tags表插入数据
//				Tags tags=new Tags();
//				tags.setId(null);
//				tags.setPid(count);
//				tags.setName("人工智能");
//				tagsMapper.add(tags);
//				Tags tags2=new Tags();
//				tags.setId(null);
//				tags.setPid(count);
//				tags.setName("计算机视觉");
//				tagsMapper.add(tags2);
							
			}
			
			count++;
		}
		
		return null;
	}
	
	@RequestMapping("/getIndexData")
	public String getIndexData(){
		//定义数据类indexData  然后用fastjson直接转换
		List<IndexData>indexDatas=new ArrayList<>();
		List<Paper>papers=paperMapper.list();
		for(Paper paper:papers){
			IndexData indexData=new IndexData();
			indexData.setTitle(paper.getTitle());
			indexData.setImgUrl("'https://image.weilanwl.com/img/4x3-1.jpg");
			indexData.setDescription(paper.getDescription());
			List<String>tags=new ArrayList<>();
			tagsMapper.get(1);
			List<Tags>tags2=tagsMapper.getByPid(paper.getId());
			for(Tags s:tags2){
				tags.add(s.getName());
			}
			indexData.setTags(tags);
			indexDatas.add(indexData);
			
		}
			
		return JSONObject.toJSONString(indexDatas);
		
	}

}
