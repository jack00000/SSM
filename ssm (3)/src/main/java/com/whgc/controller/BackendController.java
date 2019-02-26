package com.whgc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.util.List;
import com.whgc.mapper.CategoryMapper;
import com.whgc.mapper.UserMapper;
import com.whgc.pojo.Category;
import com.whgc.pojo.User;
import com.whgc.util.MapperUtil;
import com.whgc.util.Page;

import cn.hutool.db.Session;
/**
 * 后台页面的跳转
 * @author esesoft
 *
 */
@Controller
@RequestMapping("")
public class BackendController {

	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/listCategory")
	public String listCategory(Page page) {
		return "listCategory";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest req) {
		System.out.println(req.toString());
		return "login";
	}
	@RequestMapping("/login2Backend")
	public String login2Backend(User user, Model model,HttpSession session) {
		String user1 = MapperUtil.getByNameAndPW(user.getName(), user.getPassword());
		User user2=new User();
		user2.setName(user.getName());
		if (null == user1) {
			model.addAttribute("msg", "账号密码错误");
			return "login";
		} else {
			model.addAttribute("user2", user2);
			session.setAttribute("user2", user2);
			return "backendIndex";
			//重定向报错 未解决
//			return "redirect:backendIndex";
		}

	}
	//----------------------------------
	//后台管理的跳转页面
	@RequestMapping("/categoryMana")
	public String categoryMana(Model model,HttpSession session) {
		java.util.List<Category>cs=categoryMapper.list();
		model.addAttribute("cs", cs);
		session.getAttribute("user2");
		return "category";

	}

}
