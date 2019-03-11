package com.whgc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
				//清空html文件夹下的文件
				deleteDir("C:\\Users\\esesoft\\Desktop\\毕业设计\\_posts\\html");
				FileWriter out = new FileWriter(file);//文件写入流
				BufferedWriter bw=new BufferedWriter(out);
				String utf8="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n";
                bw.write(utf8);
				bw.write(html);
				bw.close();
				out.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 将html文件存在string中
	 * @throws IOException 
	 */
	public static String  File2string(String path) throws IOException {
		 InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(path)), "UTF-8");
		    BufferedReader reader = new BufferedReader(isr);
			String lineStr = null;
			
			StringBuffer sb = new StringBuffer();
			while ((lineStr = reader.readLine())!=null) {
				sb.append(lineStr).append("\n");
			}
			return sb.toString();
	
		
	}
	/**
	 * 清空一个文件夹下的所有文件
	 */
	public static boolean deleteDir(String path){
		File file = new File(path);
		if(!file.exists()){//判断是否待删除目录是否存在
			System.err.println("The dir are not exists!");
			return false;
		}
		
		String[] content = file.list();//取得当前目录下所有文件和文件夹
		for(String name : content){
			File temp = new File(path, name);
			if(temp.isDirectory()){//判断是否是目录
				deleteDir(temp.getAbsolutePath());//递归调用，删除目录里的内容
				temp.delete();//删除空目录
			}else{
				if(!temp.delete()){//直接删除文件
					System.err.println("Failed to delete " + name);
				}
			}
		}
		return true;
	}

}
