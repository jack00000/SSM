package com.whgc.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.whgc.mapper.UserMapper;
import com.whgc.pojo.User;

@Component
public class Utils{
    @Autowired
    public UserMapper usermapper;
 
    private static Utils utils;
 
    @PostConstruct
    public void init() {
        utils = this;
    }
    public static void main(String[] args) {
    	User user=new User();
		user.setName("ddfwefergfrg");
		utils.usermapper.add(user);
	}
}
