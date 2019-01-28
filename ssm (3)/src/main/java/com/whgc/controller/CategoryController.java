package com.whgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.whgc.mapper.CategoryMapper;
import com.whgc.pojo.Category;
import com.whgc.util.Page;

// 告诉spring mvc这是一个控制器类
@Controller
@ResponseBody
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryMapper categoryMapper;

	@RequestMapping("/admin")
	public String listCategory(Page page) {
		List<Category> cs = categoryMapper.list();
		return JSONObject.toJSONString(cs);
	}

}
