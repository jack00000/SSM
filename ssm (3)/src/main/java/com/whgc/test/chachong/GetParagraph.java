package com.whgc.test.chachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by JackDan9 on 2017/5/23.
 */
public class GetParagraph {
    public static void main(String[] args) throws IOException {
        ArrayList<String> res = new ArrayList<String>(); //段落的切分
        StringBuilder sb = new StringBuilder(); // 拼接读取的内容
        String temp1 = null; // 临时变量, 存储sb没有去除标点符号的内容(只是去除空格)
        String temp = null; // 临时变量, 存储sb去除空格的内容并且取出标点符号的内容
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\JackDan9\\Desktop\\检测\\PaperPass-专业版-检测报告\\使用帮助.txt")));
        int ch = 0;
        while ((ch = reader.read()) != -1) {
            temp1 = sb.toString().trim().replaceAll("\\s*", "");
            temp = temp1.replaceAll("[\\pP\\p{Punct}]", "");
            if((char) ch == '\r') {
                // 判断是否存在空格
                if(!"".equals(temp)) {
                    // 说明到了段落的结尾, 将其加入到链表, 并清空sb
                    res.add(temp);
                }
                sb.delete(0, sb.length()); // 清空sb
            } else {
                // 说明没有能够到达段落结尾, 将结果暂存.
                sb.append((char) ch);
            }
        }
        if(reader.read() == -1) {
            System.out.println("paragraphEnd");
        }
        // 最后一段如果非空, 那就把最后一段加上, 否则不处理
        if(!"".equals(temp)) {
            res.add(temp);
        }
        Iterator<String> iterator = res.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("paragraphStart");
            System.out.println(next);
        }
        System.out.println("paragraphNumber" + res.size());
    }
} 
