package com.whgc.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Jsoup 爬取网页数据
 * @author esesoft
 *
 */
public class MySearchTest {
	private static String url = "https://blog.csdn.net";
	private static String blogName = "guoxiaolongonly";

	public static void main(String[] args) {
		getArticleListFromUrl(url);
	}

	/**
	 * 获取文章列表
	 *
	 * @param listurl
	 */
	public static void getArticleListFromUrl(final String listurl) {
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
				if(relHref.startsWith("https://")){
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
		
		for (String paper : paperUrls) {
			System.out.println(paper.toString());
			
		}
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
			Element elementTitle = document.getElementsByClass("link_title").first();// 标题。
																						// 这边根据class的内容来过滤
			System.out.println(elementTitle.text());
			String filename = elementTitle.text().replaceAll("/", "或");
			Element elementContent = document.getElementsByClass("article_content").first();// 内容。
			saveArticle(filename, elementContent.text(), blogName);
			// String Content =elementContent.te xt().replaceAll(" ", "\t");
			// System.out.println(elementContent.text()+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 保存文章到本地
	 * 
	 * @param titile
	 * @param content
	 * @param blogName
	 */
	public static void saveArticle(String titile, String content, String blogName) {
		String lujing = "d:\\MyLoadArticle\\" + blogName + "\\" + titile + ".txt";// 保存到本地的路径和文件名
		File file = new File(lujing);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
