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

import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;

/**
 * Jsoup 爬取网页数据
 * 
 * @author esesoft
 *
 */
public class MySearchTest extends BaseJunit4Test {
	public static void main(String[] args) {
		CronUtil.setMatchSecond(true);
		CronUtil.start();

		CronUtil.schedule("*/2 * * * * ?", new Runnable() {

			@Override
			public void run() {
				System.out.println(DateUtil.now() + " 执行新任务");
				//
				MySearchTest test = new MySearchTest();
				test.test();

			}
		});
	}

	@Autowired
	private PaperMapper paperMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TagsMapper tagsMapper;
	// private String url = "https://blog.csdn.net";
	private String codeproject = "https://www.codeproject.com/Articles/1250071/QR-Code-Encoder-and-Decoder-NET-Class-Library-Writ";
	// 爬取深度 10层
	int depth = 0;
	//记录所有查过的url 新查在里面就不查
	private List<String>allUrl=new ArrayList<>();

	@Test
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void test() {
		// CronUtil.setMatchSecond(true);
		// CronUtil.start();
		//
		// CronUtil.schedule("*/20 * * * * ?",new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println("执行新任务");
		exeTask();
		//
		// }
		// });

	}

	/**
	 * 从网站爬取数据存到数据库
	 */

	public void exeTask() {

		digui(codeproject);
		// List<String>aList=getArticleListFromUrlCodeproject(codeproject);
		// for(String s:aList){
		// getArticleFromUrl(s);
		// }
		// for(String s:aList){
		// try {
		// List<String>aList1=getArticleListFromUrlCodeproject(s);
		// for(String s1:aList1){
		// getArticleFromUrl(s1);
		// }
		// } catch (Exception e) {
		// continue;
		// }
		//
		// }

	}

	/**
	 * 爬取网页的递归函数 (自己调用自己)
	 */
	public void digui(String s) {
		depth++;
		// 获取一个页面的文章链接
			List<String> aList = getArticleListFromUrlCodeproject(s);
			//去除alist中 已查过url 	
			for (String s1 : aList) {
				// 获取文章内容
					getArticleFromUrl(s1);
					if (depth < 1000000) {
						digui(s1);
					}
			}
	}

	/**
	 * 获取文章列表
	 * 
	 * @param listurl
	 */
	public List<String> getArticleListFromUrlCodeproject(final String listurl) {

		Document doc = null;
		try {
			doc = Jsoup.connect(listurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(3000000).post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.getElementsByTag("a");// 找到所有a标签
		List<String> paperUrls = new ArrayList<>();
		for (Element element : elements) {
			if (element != null) {
				final String relHref = element.attr("href"); // ==
				if (relHref.startsWith("//www.codeproject.com")) {
					paperUrls.add(relHref);
				}
			}
		}
		List<String> pList = new ArrayList<>();
		for (String paper : paperUrls) {
			String string=paper.replace("//www.codeproject", "https://www.codeproject");
			pList.add(string);
			if(!allUrl.contains(string)){
				allUrl.add(string);
			}
		}

		return pList;
	}

	/**
	 * 获取文章内容
	 * 
	 * @param detailurl
	 */
	public void getArticleFromUrl(String detailurl) {
		try {
			Document document = Jsoup.connect(detailurl).userAgent("Mozilla/5.0").timeout(3000000).post();
			Element elementTitle = document.getElementById("ctl00_ArticleTitle");// title
			Element elementDes = document.getElementById("ctl00_description");// description
			Element elementContent = document.getElementsByClass("article").first();// 这边根据class的内容来过滤
			Element elementtag = document.getElementById("ctl00_TagList_VisibleTags");
			Element img = document.getElementById("ctl00_avatar");
			String author = document.getElementsByAttributeValue("rel", "author").text();
			String[] fields = detailurl.split("\\.");
			String cate = fields[1];
			String title = elementTitle.text();
			String description = elementDes.text();
			String imgrandom = null;
			if (img != null) {
				imgrandom = img.attr("src");
			}
			String content = elementContent.outerHtml();
			String tags = null;
			if (elementtag != null) {
				tags = elementtag.text();
			}
			saveArticle(author, cate, title, description, imgrandom, content, tags);

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("无效url" + detailurl);
		}
	}

	/**
	 * 保存文章到数据库
	 * 
	 * @param titile
	 * @param content
	 * @param blogName
	 */
	public void saveArticle(String author, String cate, String title, String description, String imgrandom,
			String content, String tags) {
		// 从我网页爬取的信息 分别要插入 用户表 分类表 文章表 标签表 评论用微信小程序第三方插件
		// 1.现在的问题:插入用户表后 因id是自增长的 在插入分类表 需要用到刚插入用户表的id
		// 因为是通过名字来获取对应id 但名字可能相同 id就有多个 这样就会报错
		// 1.解决方法 插入前 判断用户名是否存在 存在 则不插入 (分类表 文章表不必如此)
		// 2.id就取0到10000的随机数 插入的时候判断下 这个id存不存在 在此之前 要判断这个用户名存不存在 存在则不插入
		// 插入user表
		// Random random = new Random();
		// int uid=(int)Math.floor((random.nextDouble()*10000.0));
		int uid;
		User user = new User();
		user.setName(author);
		// mapper查不出来就会报错....
		// int id=userMapper.getIdByName(author);
		try {
			uid = userMapper.getIdByName(author);
		} catch (Exception e) {
			userMapper.add(user);
			uid = userMapper.getIdByName(author);
		}

		// 插入cate表 这里的分类是 数据来源的不同

		int cid;
		Category category = new Category();
		category.setName(cate);

		try {
			cid = categoryMapper.getIdByName(cate);
		} catch (Exception e) {
			categoryMapper.add(category);
			cid = categoryMapper.getIdByName(cate);
		}

		// 插入文章表
		// int pid=(int)Math.floor((random.nextDouble()*10000.0));
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

		try {
			pid = paperMapper.getIdByName(title);
//			int a=10/0;
		} catch (Exception e) {
			paperMapper.add(paper);
			pid = paperMapper.getIdByName(title);
			// 插入标签表
			if (tags != null) {
				String[] fields = tags.split(" ");
				for (String s : fields) {
					Tags tag = new Tags();
					tag.setPid(pid);
					tag.setName(s);
					tagsMapper.add(tag);
				}
			}
		}

	}

}
