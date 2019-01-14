package com.whgc.service;

import java.util.List;

import com.whgc.pojo.Category;
import com.whgc.util.Page;

public interface CategoryService {
	int total();
    List<Category> list(Page page);
 
    void add(Category category);
 
    void delete(int id);
 
    Category get(int id);
}
