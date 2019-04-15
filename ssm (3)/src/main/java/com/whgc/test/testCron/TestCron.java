package com.whgc.test.testCron;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.whgc.mapper.PaperMapper;

import cn.hutool.cron.CronUtil;
/**
 * 定时任务
 */
public class TestCron {
	@Autowired
	static
	PaperMapper paperMapper;
 
    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start();
//        这些星号由左到右按顺序代表 ： * * * * * * *
//        格式: [秒] [分] [小时] [日] [月] [周] [年]
        CronUtil.schedule("*/1 * * * * ?",new Runnable() {
             
            @Override
            public void run() {
                System.out.println("hello");
            	try {
					task();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
            }
//            public void run() {
//				System.out.println(DateUtil.now()+ " 执行新任务");
//				
//			}
        });
    	
    }
    public static void task() throws IOException  {
    	String sql = "select count(*) from apibikeinfo";
    	String sql1 = "select count(*) from apibikeinfoall";
		String count = null;
		String count1 = null;
//		Connection conn = CreateConnFactory.getInstence().getFactory()
//				.getConnection();
//		PreparedStatement pm = conn.prepareStatement(sql);
//		PreparedStatement pm1 = conn.prepareStatement(sql1);
//		ResultSet rs = pm.executeQuery();
//		ResultSet rs1 = pm1.executeQuery();
//		while (rs.next()) {
//			count = rs.getString("count(*)");
//		}
//		while (rs1.next()) {
//			count1 = rs1.getString("count(*)");
//		}
//		pm.close();
//		conn.close();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String string=df.format(new Date())+" apibikeinfo "+count+" apibikeinfoall "+count1;// new Date()为获取当前系统时间
		String string=df.format(new Date());
		File file=new File("D:\\index.txt");
		FileWriter fWriter=new FileWriter(file);
		BufferedWriter bWriter=new BufferedWriter(fWriter);
		bWriter.newLine();
		bWriter.write(string+"\r\n");
		bWriter.flush();
		bWriter.close();
	}
    
   
}