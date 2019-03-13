package com.whgc.util;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.whgc.mapper.PaperMapper;

@Component 
public class TestUtils {
    @Autowired
    private PaperMapper itemMapper;
    
    public static TestUtils testUtils;
    
    @PostConstruct
    public void init() {    
        testUtils = this;
        testUtils.itemMapper=this.itemMapper;
    } 
    
    //utils工具类中使用service和mapper接口的方法例子，用"testUtils.xxx.方法" 就可以了      
    public static void test(){
        System.out.println(testUtils.itemMapper.get(1));
    }
    public static void main(String[] args) {
    	test();
	}
}