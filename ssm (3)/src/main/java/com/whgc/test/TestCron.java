package com.whgc.test;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.tools.classfile.StackMap_attribute.stack_map_frame;
import com.whgc.mapper.PaperMapper;
import com.whgc.pojo.Paper;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;
/**
 * 定时任务
 */
public class TestCron {
	@Autowired
	static
	PaperMapper paperMapper;
 
    public static void main(String[] args) {
//        CronUtil.setMatchSecond(true);
//        CronUtil.start();
// 
//        CronUtil.schedule("*/20 * * * * ?",new Runnable() {
//             
//            @Override
//            public void run() {
//                web2db();
//                 
//            }
//        });
    	
    }
    
   
}