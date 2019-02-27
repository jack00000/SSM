package com.whgc.mapper;

import java.util.List;

import com.whgc.pojo.Category;
import com.whgc.pojo.User;

public interface UserMapper {

	 public int add(User user);  
     
	    public void delete(int id);  
	     
	    public User get(int id);  
	    
	    public User getBynp(String name,String password);   
	      
	    public int update(User User);   
	           
	    public List<User> list();
	    
	    public List<User> listByPage(int start, int end);
	    
	    public int getTotal();
	   
}
