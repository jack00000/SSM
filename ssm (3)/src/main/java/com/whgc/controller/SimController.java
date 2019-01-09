package com.whgc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.pojo.Category;
import com.whgc.util.MyLevenshtein;
import com.whgc.util.Page;

@Controller
@RequestMapping("")
public class SimController {
	@RequestMapping("getFile")
	public ModelAndView getFile() {
		ModelAndView mav = new ModelAndView();
		// 放入jsp路径
		mav.setViewName("upload");
		return mav;
	}

	@RequestMapping("wordComp")
	public ModelAndView wordComp(HttpServletRequest req) throws IOException, FileUploadException {
		// 将文件存到本地后，取出文件数据最后放在list数组中
		List<String> wordsList = new ArrayList<>();
		// 一.获取本地上传的文件存到临时目录
		// (1)创建临时文件目录存上传的文件
		String tmpPath = System.getProperty("java.io.tmpdir") + "upload2";
		File tmpFile = new File(tmpPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		// 1,声明DiskFileItemFactory工厂类，用于在指定磁盘上设置一个临时目录
		DiskFileItemFactory disk = new DiskFileItemFactory(1024 * 10, new File(tmpPath));
		// 2,声明ServletFileUpload，接收上边的临时文件。也可以默认值
		ServletFileUpload up = new ServletFileUpload(disk);
		// 解决路径或者文件名为乱码的问题
		up.setHeaderEncoding("UTF-8");
		// 3,解析request
		// req.setCharacterEncoding("UTF-8");
		List<FileItem> list = up.parseRequest(req);
		FileItem fileItem = list.get(0);
		// 解决获取的表单字段为乱码的问题
		// fileItem.getString("UTF-8");
		// (2)获得上传文件的inputStream对象
		InputStream in = fileItem.getInputStream();
		// FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		try {
			String str = "";
			String str1 = "";
			// fis = new FileInputStream("c:\\小志.txt");// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(in);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象

			while ((str = br.readLine()) != null) {
				str1 += str + "\n";
				wordsList.add(str);
			}
			// 当读取的一行不为空时,把读到的str的值赋给str1
			// System.out.println(str1);// 打印出str1
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
				// fis.close();
				// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//三.编辑距离相似 度算法
		//String s1=req.getParameter("word");
		//String s=req.getP
		List<String>words=new ArrayList<>();
		for(String s2:wordsList){
			if(MyLevenshtein.levenshtein("exception", s2)>0.6){
				words.add(s2);
			}
		}
		System.out.println("计算完成");
		ModelAndView mav = new ModelAndView();
		// 放入jsp路径
		mav.addObject("words", words);
		mav.setViewName("result");
		return mav;

	}
}
