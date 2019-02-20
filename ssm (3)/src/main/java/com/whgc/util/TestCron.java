package com.whgc.util;
import cn.hutool.core.date.DateUtil;
/**
 * 定时器 具体内容
 * @author esesoft
 *
 */
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.cron.CronUtil;

public class TestCron {
 
    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start();
 
        CronUtil.schedule("*/2 * * * * ?",new Runnable() {
             
            @Override
            public void run() {
                System.out.println(DateUtil.now()+ " 执行新任务");
                 
            }
        });
    }
}
