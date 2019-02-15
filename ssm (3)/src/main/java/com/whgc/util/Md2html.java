package com.whgc.util;

import java.io.File;

import com.youbenzi.mdtool.tool.MDTool;

/**
 * 将博客的350多篇文章转换成html 
 * @author esesoft
 *
 */
public class Md2html {
	public static void main(String[] args) {
		System.out.println(MDTool.markdown2Html(new File("D:\\index.md")));
	}

}
