package com.whgc.test;
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

/**
 * Jsoup 爬取网页数据
 * 
 * @author esesoft
 *
 */
public class MySearchTest extends BaseJunit4Test {
	@Autowired
	private PaperMapper paperMapper;
	@Autowired
	private  CategoryMapper categoryMapper;
	@Autowired
	private  UserMapper userMapper;
	@Autowired
	private TagsMapper tagsMapper;
	// private  String url = "https://blog.csdn.net";
	private  String url = "https://www.codeproject.com";
	// private  String blogName = "guoxiaolongonly";
	@Test
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void test() {
		// getArticleListFromUrl(url);
		// String
		// teString="https://www.codeproject.com/Articles/1278992/Analyzing-Twitch-Channel-Viewership-with-Python-2";
		String teString = "https://www.codeproject.com/Articles/1278516/Visual-Studio-2019-and-Python";
		getArticleFromUrl(teString);
	}

	/**
	 * 获取文章列表
	 * 
	 * @param listurl
	 */
	public  List<String> getArticleListFromUrl(final String listurl) {
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
			pList.add(paper.replace("/Articles", url + "/Articles"));
		}

		return pList;
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
			String author = document.getElementsByClass("author").text();
			String[] fields = detailurl.split("\\.");
			String cate = fields[1];
			String title = elementTitle.text();
			String description = elementDes.text();
			String imgrandom = "https://source.unsplash.com/random";
			String content = elementContent.outerHtml();
			String tags = elementtag.text();
			saveArticle(author, cate, title, description, imgrandom, content, tags);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 保存文章到数据库
	 * 
	 * @param titile
	 * @param content
	 * @param blogName
	 */
	public  void saveArticle(String author, String cate, String title, String description, String imgrandom,
			String content, String tags) {
		//从我网页爬取的信息 分别要插入 用户表 分类表 文章表 标签表  评论用微信小程序第三方插件 
		//1.现在的问题:插入用户表后  因id是自增长的  在插入分类表 需要用到刚插入用户表的id 
		//因为是通过名字来获取对应id 但名字可能相同 id就有多个  这样就会报错
		//1.解决方法 插入前 判断用户名是否存在 存在 则不插入   (分类表 文章表不必如此)
		//2.id就取0到10000的随机数  插入的时候判断下 这个id存不存在  在此之前 要判断这个用户名存不存在  存在则不插入
		//插入user表
//		Random random = new Random();
//		int uid=(int)Math.floor((random.nextDouble()*10000.0)); 
		int uid;
		User user = new User();
		user.setName(author);
		//mapper查不出来就会报错....
//		int id=userMapper.getIdByName(author);
//		if(userMapper.getIdByName(author)==0){
//			userMapper.add(user);
//			uid=userMapper.getIdByName(author);
//		}else {
//			uid=userMapper.getIdByName(author);
//		}
		try {
			uid=userMapper.getIdByName(author);
		} catch (Exception e) {
			userMapper.add(user);
			uid=userMapper.getIdByName(author);
		}

		//插入cate表  这里的分类是 数据来源的不同
//		int uid=userMapper.getIdByName(author);
//		int cid=(int)Math.floor((random.nextDouble()*1000.0)); 
		int cid;
		Category category = new Category();
		category.setName(cate);
//		if(categoryMapper.getIdByName(author)==0){
//			categoryMapper.add(category);
//			cid=categoryMapper.getIdByName(cate);
//		}else {
//			cid=categoryMapper.getIdByName(cate);
//		}
		try {
			cid=categoryMapper.getIdByName(cate);
		} catch (Exception e) {
			categoryMapper.add(category);
			cid=categoryMapper.getIdByName(cate);
		}

		//插入文章表
//		int pid=(int)Math.floor((random.nextDouble()*10000.0)); 
		int pid;
		Paper paper = new Paper();
		paper.setId(null);
		paper.setUid(uid);
		paper.setCid(cid);
		paper.setTitle(title);
		paper.setUpdateTime(new Date().toString());
		paper.setWordSum("12345");
		paper.setContent(content);
		paper.setDescription(description);
//		if(paperMapper.getIdByName(title)==0){
//			paperMapper.add(paper);
//			pid=paperMapper.getIdByName(title);
//		}else {
//			pid=paperMapper.getIdByName(title);
//		}
		try {
			pid=paperMapper.getIdByName(title);
		} catch (Exception e) {
			paperMapper.add(paper);
			pid=paperMapper.getIdByName(title);
		}
		//插入标签表
		String[] fields=tags.split(" ");
		for(String s:fields){
			Tags tag=new Tags();
			tag.setPid(pid);
			tag.setName(s);
			tagsMapper.add(tag);
		}
		
	}
	

}
