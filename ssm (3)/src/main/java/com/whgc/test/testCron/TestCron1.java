package com.whgc.test.testCron;
 
import cn.hutool.cron.CronUtil;
 
public class TestCron1 {
 
    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}