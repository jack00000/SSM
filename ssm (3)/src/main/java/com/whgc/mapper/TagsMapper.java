package com.whgc.mapper;
import java.util.List;

import com.whgc.pojo.Category;
import com.whgc.pojo.Tags;

public interface TagsMapper {
 
      
    public int add(Tags tags);  
         
    public void delete(int id);  
     
    public Tags get(int id);   
      
    public int update(Tags tags);   
           
    public List<Tags> list();
    
    public List<Tags> getByPid(int pid);
      
    public int getIdByName(String name) ;
}