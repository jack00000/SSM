package com.whgc.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Created by JackDan9 on 2017/5/23.
 */
public class AutoCheckTest {
//    private static final String filePath = "文件路径";
    private static final String filePath = "C:\\Users\\JackDan9\\Desktop\\test\\test1.txt";
    private static final String secFilePath = "C:\\Users\\JackDan9\\Desktop\\test\\test2.txt";
    private static final String resFilePath = "C:\\Users\\JackDan9\\Desktop\\test\\result.txt";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // 阅读第一个文集那
        File file = new File(filePath);
        File secFile = new File(secFilePath);
        BufferedReader reader = null;
        BufferedReader secReader = null;
//        BufferedReader resReader = null;
        BufferedWriter resWriter = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            secReader = new BufferedReader((new FileReader(secFile)));
            secReader.mark(90000000);
            resWriter = new BufferedWriter(new FileWriter(resFilePath));
            String lineText = null;
            while((lineText = reader.readLine()) != null) {
                String searchText = lineText.trim();
                searchAndSignProcess.searchAndSignProcess(searchText, secReader, resWriter);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("======Process Over!======");
            System.out.println("Time Speeding: " + ((endTime - startTime) / 1000D) + "s");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (secReader != null && resWriter != null) {
                        try {
                            secReader.close();
                            resWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
