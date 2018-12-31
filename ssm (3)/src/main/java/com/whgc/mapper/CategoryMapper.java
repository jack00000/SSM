package com.whgc.mapper;
 
import java.util.List;

import com.whgc.pojo.Category;
import com.whgc.util.Page;
 
public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category get(int id);  
     
      
    public int update(Category category);   
       
      
    public List<Category> list();
      
}