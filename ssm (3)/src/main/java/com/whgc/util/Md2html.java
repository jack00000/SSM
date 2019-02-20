package com.whgc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.whgc.mapper.PaperMapper;
import com.youbenzi.mdtool.export.HTMLDecorator;
import com.youbenzi.mdtool.markdown.Analyzer;
import com.youbenzi.mdtool.markdown.bean.Block;
import com.youbenzi.mdtool.tool.MDTool;

/**
 * 将博客的350多篇文章转换成html 
 * @author esesoft
 *
 */
public class Md2html {
	/**
	 * markdown2Html
	 * @param file
	 * @return
	 */
	public static String markdown2Html(File file){
		try (BufferedReader reader = new BufferedReader(new FileReader(file));){
			String lineStr = null;
			
			StringBuffer sb = new StringBuffer();
			while ((lineStr = reader.readLine())!=null) {
				sb.append(lineStr).append("\n");
				//System.out.println(lineStr);
			}
			return markdown2Html(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String markdown2Html(String mdStr){
		if(mdStr==null){
			return null;
		}
		
		List<Block> list = Analyzer.analyze(mdStr);
		HTMLDecorator decorator = new HTMLDecorator(); 
		
		decorator.decorate(list);
		return decorator.outputHtml();
	}
	
	
	  /**
     * 读取某个文件夹下的所有文件
     */
    public static List<String> readfile(String filepath) throws FileNotFoundException, IOException {
		List<String> absolutepaths = new ArrayList<>();
		try {

			File file = new File(filepath);
			if (!file.isDirectory()) {
				System.out.println("文件");
				System.out.println("path=" + file.getPath());
				System.out.println("absolutepath=" + file.getAbsolutePath());
				System.out.println("name=" + file.getName());

			} else if (file.isDirectory()) {
				System.out.println("文件夹");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						absolutepaths.add(readfile.getAbsolutePath());
						
					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i]);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return absolutepaths;
    }


}
