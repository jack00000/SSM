package com.whgc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.pojo.Category;
import com.whgc.service.CategoryService;
import com.whgc.util.Page;

// 告诉spring mvc这是一个控制器类
@Controller
@ResponseBody
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/admin")
	public String listCategory(Page page){	
		List<Category> cs= categoryService.list();		
		return cs.toString();
//		return "ok";
	}

}
