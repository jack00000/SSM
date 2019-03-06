package com.whgc.util;
 
import cn.hutool.core.date.DateUtil;
 
public class HutoolCronTask implements Runnable{
 
    @Override
    public void run() {
        System.out.println(DateUtil.now() + " this is HutoolCronTask");
    }
 
}