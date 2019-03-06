package com.whgc.test;
 
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;
/**
 * 定时任务
 */
public class TestCron {
 
    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start();
 
        CronUtil.schedule("*/20 * * * * ?",new Runnable() {
             
            @Override
            public void run() {
                System.out.println(DateUtil.now()+ " 执行新任务");
                 
            }
        });
    }
}