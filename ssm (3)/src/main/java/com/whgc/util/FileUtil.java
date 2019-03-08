package com.whgc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		mdFiles2htmlFiles("C:\\Users\\esesoft\\Desktop\\毕业设计\\_posts");
	}

	/**
	 * 将md格式文件批量转化为html格式文件 并设置编码格式utf8
	 * @param path md文件根路径
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void mdFiles2htmlFiles(String path) throws FileNotFoundException, IOException {
		List<String>mds=Md2html.readfile(path);
		for(String s:mds){
			try (BufferedReader reader = new BufferedReader(new FileReader(new File(s)));){
				String lineStr = null;
				
				StringBuffer sb = new StringBuffer();
				while ((lineStr = reader.readLine())!=null) {
					sb.append(lineStr).append("\n");
				}
				String html=Md2html.markdown2Html(sb.toString());
				
				String htmlpath="C:\\Users\\esesoft\\Desktop\\毕业设计\\html";
				File file=new File(htmlpath+s.replace(path, "").replace("md", "html"));
				if(!file.exists()){
					File dir = new File(file.getParent());
					dir.mkdirs();
				}
				FileWriter out = new FileWriter(file);//文件写入流
				BufferedWriter bw=new BufferedWriter(out);
				String utf8="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
                bw.write(utf8);
				bw.write(html);
				bw.close();
				out.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
