package com.whgc.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by JackDan9 on 2017/5/24.
 */
public class searchAndSignProcess {
    public static void searchAndSignProcess(String searchText, BufferedReader secReader, BufferedWriter resWriter) throws IOException{
        String lineStr = "-\n";
        if (searchText == null) {
            return;
        }
        if("".equals(searchText)) {
            resWriter.write(lineStr);
        }
        String lineText = null;
        int lineNum = 1;
        while ((lineText = secReader.readLine()) != null) {
            String secLine = lineText.trim();
            if (searchText.equals(secLine)) {
                lineStr = "###=Equal:" + lineNum + "=###" + "\n";
                break;
            }
            lineNum ++;
        }
        resWriter.write(lineStr);
        secReader.reset();
    }
}
