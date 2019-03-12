package com.whgc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whgc.mapper.PaperMapper;
import com.whgc.pojo.Paper;
/**
 * new界面的处理逻辑
 * @author esesoft
 *
 */
@Controller
@ResponseBody
@RequestMapping("")
public class AddController {
	@Autowired
	PaperMapper paperMapper;
    /**
     * 获取微信小程序后台的数据并插入数据库
     * @param paper
     * @return
     */
	@RequestMapping("/insertPaper")
	public String listCategory(Paper paper) {
		paperMapper.add(paper);
		return null;
}
}
