package com.whgc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.whgc.mapper.CategoryMapper;
import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.ReviewMapper;
import com.whgc.mapper.TagsMapper;
import com.whgc.pojo.Paper;
import com.whgc.pojo.Review;
import com.whgc.pojo.Tags;
import com.whgc.pojoData.IndexData;
import com.whgc.pojoData.IndexPaperDetailData;
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
	@Autowired
	TagsMapper tagsMapper;
	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	ReviewMapper reviewMapper;

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
	@RequestMapping("/getApiBikeData.do")
	public String getApiData(){
		List<Map<String,Object>>maps=new ArrayList<>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Id", "1");
		map.put("CompanyId", "2");
		map.put("Code", "sample string 3");
		map.put("License", "sample string 4");
		map.put("LaunchDate"," 2019-03-01T13:41:09.6719004+08:00");
		map.put("State", "6");
		map.put("UpdateTime", "2019-03-01T13:41:09.6719004+08:00");
		map.put("UploadTime", "2019-03-01T13:41:09.6719004+08:00");
		map.put("History", "true");
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("Id", "1");
		map1.put("CompanyId", "2");
		map1.put("Code", "sample string 3");
		map1.put("License", "sample string 4");
		map1.put("LaunchDate"," 2019-03-01T13:41:09.6719004+08:00");
		map1.put("State", "6");
		map1.put("UpdateTime", "2019-03-01T13:41:09.6719004+08:00");
		map1.put("UploadTime", "2019-03-01T13:41:09.6719004+08:00");
		map1.put("History", "true");
		maps.add(map);
		
		maps.add(map1);
		
		return JSONObject.toJSONString(maps);
		
	}
	@RequestMapping("/getApiCompanyData.do")
	public String getApiCompanyData(){
		List<Map<String,Object>>maps=new ArrayList<>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Id", "1");
		map.put("CompanyId", "2");
		map.put("Name", "sample string 3");
		map.put("Identifier", "sample string 4");
		map.put("BusinessScope","sample string 5");
		map.put("ContactAddress", "sample string 6");
		map.put("Regcapital", "sample string 7");
		map.put("LegalName", "sample string 8");
		map.put("LegalId", "sample string 9");
		map.put("Status", "10");
		map.put("UpdateTime", "2019-03-04T10:01:59.3195913+08:00");
		map.put("UploadTime", "2019-03-04T10:01:59.3205972+08:00");
		map.put("History", "true");
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("Id", "1");
		map1.put("CompanyId", "2");
		map1.put("Name", "sample string 3");
		map1.put("Identifier", "sample string 4");
		map1.put("BusinessScope","sample string 5");
		map1.put("ContactAddress", "sample string 6");
		map1.put("Regcapital", "sample string 7");
		map1.put("LegalName", "sample string 8");
		map1.put("LegalId", "sample string 9");
		map1.put("Status", "10");
		map1.put("UpdateTime", "2019-03-04T10:01:59.3195913+08:00");
		map1.put("UploadTime", "2019-03-04T10:01:59.3205972+08:00");
		map1.put("History", "true");
		maps.add(map);
		maps.add(map1);
		
		return JSONObject.toJSONString(maps);
		
	}
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
			
							
			}
			
			count++;
		}
		
		return null;
	}
	
	@RequestMapping("/getIndexData")
	public String getIndexData(){
		//定义数据类indexData  然后用fastjson直接转换
		//所有文章的简介数据indexDatas
		try {
			List<IndexData>indexDatas=new ArrayList<>();
			List<Paper>papers=paperMapper.list();
			for(Paper paper:papers){
				IndexData indexData=new IndexData();
				indexData.setTitle(paper.getTitle());
				indexData.setImgUrl("'https://image.weilanwl.com/img/4x3-1.jpg");
				indexData.setDescription(paper.getDescription());
				List<Tags>tags=tagsMapper.getByPid(paper.getId());
				indexData.setTags(tags);
				indexData.setPaperId(paper.getId());
				indexDatas.add(indexData);
				//写个异常测一下
//				int value = 10 / 0;
				
			}
			//根据api文档规范数据格式  请求成功 请求 各返回什么
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status","200" );
			meta.put("msg","successs" );
			map.put("meta", meta);
			Map<String,Object> respond = new HashMap<String,Object>();
			respond.put("datas",indexDatas);
			map.put("respond", respond);
			return JSONObject.toJSONString(map);
		} catch (Exception e) {
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status",e.toString());
			meta.put("msg","failed" );
			map.put("meta", meta);
			return JSONObject.toJSONString(map);
		}	
	}
	
	@RequestMapping("/getIndexCategories")
	public String getIndexCategories(){
		try {
			//根据api文档规范数据格式  请求成功 请求 各返回什么
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status","200" );
			meta.put("msg","successs" );
			map.put("meta", meta);
			Map<String,Object> respond = new HashMap<String,Object>();
			respond.put("datas",categoryMapper.list());
			map.put("respond", respond);
			//写个异常测一下
//			int value = 10 / 0;
			return JSONObject.toJSONString(map);
		} catch (Exception e) {
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status",e.toString());
			meta.put("msg","failed" );
			map.put("meta", meta);
			return JSONObject.toJSONString(map);
		}
		
	}
	
	@RequestMapping("/getIndexPaperDetailData")
	public String getIndexPaperDetailDatas(HttpServletRequest req){
		//定义数据类IndexPaperDetailData  然后用fastjson直接转换
		//所有文章的具体内容数据IndexPaperDetailDatas
		try {
			//检测参数 防攻击
			int pid=Integer.parseInt(req.getParameter("pid"));
//			int pid=1;
			Paper paper=paperMapper.get(pid);
			IndexPaperDetailData indexDatas=new IndexPaperDetailData();
			indexDatas.setId(paper.getId());
			indexDatas.setCid(paper.getCid());
			indexDatas.setUid(paper.getUid());
			indexDatas.setImg("https://image.weilanwl.com/img/4x3-2.jpg");
			indexDatas.setTitle(paper.getTitle());
			indexDatas.setDescription(paper.getDescription());
			indexDatas.setUpdateTime(paper.getUpdateTime());
			indexDatas.setWordSum(paper.getWordSum());
			List<Review>comments=reviewMapper.getByPid(paper.getId());
			indexDatas.setComments(comments);
			String string=Md2html.markdown2Html(new File("D:\\index.md"));
			indexDatas.setContent(string);
			
			//根据api文档规范数据格式  请求成功 请求 各返回什么
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status","200" );
			meta.put("msg","successs" );
			map.put("meta", meta);
			Map<String,Object> respond = new HashMap<String,Object>();
			respond.put("datas",indexDatas);
			map.put("respond", respond);
			return JSONObject.toJSONString(map);
		} catch (Exception e) {
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,String> meta = new HashMap<String,String>();
			meta.put("status",e.toString());
			meta.put("msg","failed" );
			map.put("meta", meta);
			return JSONObject.toJSONString(map);
		}
				
	}
	

}
