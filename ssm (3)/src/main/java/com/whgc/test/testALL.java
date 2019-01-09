package com.whgc.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.web.context.request.NativeWebRequest;

import com.sun.tools.javac.util.List;
import com.whgc.test.bjjl.MyLevenshtein;
import com.whgc.test.hmjl.HammingDistance;
import com.whgc.test.testJaccard.StrJaccard;
import com.whgc.test.testYxxsd.Cosine;

public class testALL {

	public static void main(String[] args) {
		// 1.读取文件存入list数组
		ArrayList<String> words = new ArrayList<String>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		try {
			String str = "";
			String str1 = "";
			fis = new FileInputStream("d:\\words.txt");// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
			while ((str = br.readLine()) != null) {
				str1 += str + "\n";
				words.add(str1);
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
				fis.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 2.循环比较输入的单词与list数组的单词的相似度
		System.out.println("输入待匹配单词：");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		// 2.1余弦定理相似度
		System.out.println("余弦定理相似度算法结果");
		for (String s2 : words) {
			// System.out.println(Cosine.getSimilarity(s1, s2));
		}

		// 2.2Jaccard相似度算法
		System.out.println("Jaccard相似度算法结果");
		for (String s2 : words) {
			//System.out.println(StrJaccard.jaccardSim(s1, s2));
			if(StrJaccard.jaccardSim(s1, s2)>0.3){
				System.out.println(s2);
			}
		}
		/*// 2.3海明距离
		System.out.println("海明距离");
		for (String s2 : words) {
			System.out.println(HammingDistance.getHMJL(s1, s2));
		}*/
		// 2.4欧氏距离
		System.out.println("欧氏距离");
		//2.5编辑距离
		System.out.println("编辑距离");
		for (String s2 : words) {
			//System.out.println(MyLevenshtein.levenshtein(s1, s2));
			if(MyLevenshtein.levenshtein(s1, s2)>0.05){
				System.out.println(s2);
			}
		}
		

	}
}
