package com.whgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.whgc.mapper.PaperMapper;
import com.whgc.pojo.Category;
import com.whgc.util.Page;

@Controller
@ResponseBody
@RequestMapping("")
public class UpdatingController {
	@Autowired
	PaperMapper paperMapper;

//	@RequestMapping("/admin")
//	public String listCategory(Page page) {
//		
//		return JSONObject.toJSONString(cs);
//	}

}
