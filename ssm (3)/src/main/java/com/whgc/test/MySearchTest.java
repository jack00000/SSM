package com.whgc.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.UserMapper;
import com.whgc.pojo.Paper;
import com.whgc.pojo.User;
import com.whgc.util.Utils;
/**
 * Jsoup 爬取网页数据
 * @author esesoft
 *
 */
public class MySearchTest {
//	@Autowired
//	PaperMapper paperMapper;
	@Autowired
	UserMapper userMapper;
//	private static String url = "https://blog.csdn.net";
	private static String url = "https://www.codeproject.com";
//	private static String blogName = "guoxiaolongonly";

	public static void main(String[] args) {
//		getArticleListFromUrl(url);
//		String teString="https://www.codeproject.com/Articles/1278992/Analyzing-Twitch-Channel-Viewership-with-Python-2";
		String teString="https://www.codeproject.com/Articles/1278516/Visual-Studio-2019-and-Python";
        getArticleFromUrl(teString);
	}

	/**
	 * 获取文章列表
	 * @param listurl
	 */
	public static List<String> getArticleListFromUrl(final String listurl) {
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
			if(element!=null){
				final String relHref = element.attr("href"); // ==
				if(relHref.startsWith("/Articles")){
					paperUrls.add(relHref);	
				}
					
			}
											// "/"这个是href的属性值，一般都是链接。这里放的是文章的连接
//			// 用if语句过滤掉不是文章链接的内容。因为文章的链接有两个，但评论的链接只有一个，反正指向相同的页面就拿评论的链接来用吧
//			if (!relHref.startsWith("http://") && relHref.contains("details") && relHref.endsWith("comments")) {
//				StringBuffer sb = new StringBuffer();
//				sb.append(relHref);
//				System.out.println(sb.substring(0, sb.length() - 9));// 去掉最后的#comment输出
//				getArticleFromUrl(sb.substring(0, sb.length() - 9));// 可以通过这个url获取文章了
//			}
//			if (relHref.equals("https://mp.csdn.net//postlist")) {
//				isStop = true;
//			}
			
		}
		List<String>pList=new ArrayList<>();
		for (String paper : paperUrls) {
			pList.add(paper.replace("/Articles", url+"/Articles"));
			
		}
		return pList;
//		if (!isStop) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					if (!listurl.contains("list")) {
//						getArticleListFromUrl(listurl + "/article/list/1");// 获取下一页的列表
//					} else {
//						getArticleListFromUrl(listurl.substring(0, listurl.length() - 1)
//								+ (Integer.valueOf(listurl.substring(listurl.length() - 1, listurl.length())) + 1));// 获取下一页的列表
//					}
//				}
//			}).start();
//		}
	}

	/**
	 * 获取文章内容
	 * 
	 * @param detailurl
	 */
	public static void getArticleFromUrl(String detailurl) {
		try {
			Document document = Jsoup.connect(detailurl).userAgent("Mozilla/5.0").timeout(3000).post();
			Element elementTitle = document.getElementById("ctl00_ArticleTitle");// title
			Element elementDes=document.getElementById("ctl00_description");//description	
			Element elementContent = document.getElementsByClass("article").first();// 这边根据class的内容来过滤
			Element elementtag=document.getElementById("ctl00_TagList_VisibleTags");
			String author=document.getElementsByClass("author").text();
			String[] fields=detailurl.split("\\.");
			String cate=fields[1];
			String title = elementTitle.text();
			String description=elementDes.text();
			String imgrandom="https://source.unsplash.com/random";
			String content=elementContent.outerHtml();
			String tags=elementtag.text();
			saveArticle(author,cate,title,description,imgrandom, content,tags);

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
	public static void saveArticle(String author,String cate,String titile,String description,String imgrandom, String content,String tags) {
		User user=new User();
		user.setName(author);
		Utils utils=new Utils();
//		utils.usermapper.add(user);
		String sql="select id from user_ where name="+author;
//		String uid=MapperUtil.exeSql(sql);
		Paper paper=new Paper();
//		paper.setCid(cid);
	}
	
}
