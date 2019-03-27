package com.whgc.test.testspider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.whgc.mapper.CategoryMapper;
import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.TagsMapper;
import com.whgc.mapper.UserMapper;
import com.whgc.pojo.Category;
import com.whgc.pojo.Paper;
import com.whgc.pojo.Tags;
import com.whgc.pojo.User;
import com.whgc.util.springTest.BaseJunit4Test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;

/**
 * Jsoup 爬取网页数据
 * 
 * @author esesoft
 *
 */
public class Spider4codeproject extends BaseJunit4Test {
	public static void main(String[] args) {
		CronUtil.setMatchSecond(true);
        CronUtil.start();
 
        CronUtil.schedule("*/2 * * * * ?",new Runnable() {
             
            @Override
            public void run() {
                System.out.println(DateUtil.now()+ " 执行新任务");
                //
                Spider4codeproject test=new Spider4codeproject();
                test.test();
                 
            }
        });
	}
	@Autowired
	private PaperMapper paperMapper;
	@Autowired
	private  CategoryMapper categoryMapper;
	@Autowired
	private  UserMapper userMapper;
	@Autowired
	private TagsMapper tagsMapper;
	// private  String url = "https://blog.csdn.net";
	private  String codeproject = "https://www.codeproject.com";
	private int count=0;
	// private  String blogName = "guoxiaolongonly";
	@Test
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void test() {
//		CronUtil.setMatchSecond(true);
//        CronUtil.start();
// 
//        CronUtil.schedule("*/20 * * * * ?",new Runnable() {
//             
//            @Override
//            public void run() {
//            	System.out.println("执行新任务");
                exeTask();
//                 
//            }
//        });
		
	}
	/**
	 * 从网站爬取数据存到数据库
	 */
	public void exeTask(){
		 List<String>aList=getArticleListFromUrlCodeproject(codeproject);
		 for(String s:aList){
			 getArticleFromUrl(s);
		 }
		// String
		// teString="https://www.codeproject.com/Articles/1278992/Analyzing-Twitch-Channel-Viewership-with-Python-2";
//		String teString = "https://www.codeproject.com/Articles/1278516/Visual-Studio-2019-and-Python";
//		getArticleFromUrl(teString);
	}

	/**
	 * 获取文章列表
	 * 
	 * @param listurl
	 */
	public  List<String> getArticleListFromUrlCodeproject(final String listurl) {
		count++;
		boolean isStop = false;
		Document doc = null;
		try {
			doc = Jsoup.connect(listurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(3000).post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.getElementsByTag("a");// 找到所有a标签
		List<String> paperUrls = new ArrayList<>();
		for (Element element : elements) {
			if (element != null) {
				final String relHref = element.attr("href"); // ==
				if (relHref.startsWith("/Articles")) {
					paperUrls.add(relHref);
				}
			}
		}
		List<String> pList = new ArrayList<>();
		for (String paper : paperUrls) {
			pList.add(paper.replace("/Articles", codeproject + "/Articles"));
		}
		 for(String s:pList){
			 if(count==2){
				 break;
			 }
			 getArticleListFromUrlCodeproject(s);
			 getArticleFromUrl(s);
		 }

		return null;
	}

	/**
	 * 获取文章内容
	 * 
	 * @param detailurl
	 */
	public  void getArticleFromUrl(String detailurl) {
		try {
			Document document = Jsoup.connect(detailurl).userAgent("Mozilla/5.0").timeout(3000).post();
			Element elementTitle = document.getElementById("ctl00_ArticleTitle");// title
			Element elementDes = document.getElementById("ctl00_description");// description
			Element elementContent = document.getElementsByClass("article").first();// 这边根据class的内容来过滤
			Element elementtag = document.getElementById("ctl00_TagList_VisibleTags");
			Element img=document.getElementById("ctl00_avatar");
			String author = document.getElementsByClass("author").text();
			String[] fields = detailurl.split("\\.");
			String cate = fields[1];
			String title = elementTitle.text();
			String description = elementDes.text();
			String imgrandom = img.attr("src");
			String content = elementContent.outerHtml();
			String tags = elementtag.text();
			saveArticle(author, cate, title, description, imgrandom, content, tags);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException 
	 * 保存文章到数据库
	 * 
	 * @param titile
	 * @param content
	 * @param blogName
	 * @throws  
	 */
	public  void saveArticle(String author, String cate, String title, String description, String imgrandom,
			String content, String tags) throws IOException   {
	//存入文件测试
		String str=author+cate+title+description+tags;
		File file=new File("D:\\paper.txt");
		FileWriter fWriter=new FileWriter(file);
		BufferedWriter bWriter=new BufferedWriter(fWriter);
		bWriter.write(str);
		System.out.println("input"+str);
	}
	

}
