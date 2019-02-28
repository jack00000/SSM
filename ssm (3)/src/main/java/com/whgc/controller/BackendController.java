package com.whgc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whgc.mapper.CategoryMapper;
import com.whgc.mapper.PaperMapper;
import com.whgc.mapper.PaymentMapper;
import com.whgc.mapper.ReviewMapper;
import com.whgc.mapper.UserMapper;
import com.whgc.pojo.Category;
import com.whgc.pojo.Paper;
import com.whgc.pojo.Payment;
import com.whgc.pojo.Review;
import com.whgc.pojo.User;
import com.whgc.util.Page;
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
	@Autowired
	PaperMapper paperMapper;
	@Autowired
	ReviewMapper reviewMapper;
	@Autowired
	PaymentMapper paymentMapper;

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
//		String user1 = MapperUtil.getByNameAndPW(user.getName(), user.getPassword());
		User user1 = userMapper.getBynp(user.getName(), user.getPassword());
		User user2=new User();
		user2.setName(user.getName());
		if (null == user1) {
			model.addAttribute("msg", "账号密码错误");
			return "login";
		} else {
			model.addAttribute("user2", user2);
			session.setAttribute("user2", user2);
			return "backendIndex";
	
		}

	}
	@RequestMapping("backendIndex")
	public String backendIndex(){
		return "backendIndex";
	}
	//----------------------------------
	//category后台管理的跳转页面
	@RequestMapping("/categoryMana")
	public String categoryMana(Model model,HttpSession session,Page page) {
		int total=categoryMapper.getTotal();
		page.caculateLast(total);
		if(page.getStart()<0){
			page.setStart(0);
		}	
		java.util.List<Category>cs=categoryMapper.listByPage(page.getStart(),page.getStart()+page.getCount());
		model.addAttribute("cs", cs);
		session.getAttribute("user2");
		session.setAttribute("page", page);
		return "mana/categoryMana/listcategory";

	}
	@RequestMapping("/addCategory")
	public String addCategory(Category category,HttpSession session) {
		categoryMapper.add(category);
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:categoryMana";

	}
	@RequestMapping("/deleteCategory")
	public String delCategory(Category category) {
		categoryMapper.delete(category.getId());;
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:categoryMana";

	}
	@RequestMapping("/editCategory")
	public String editCategory(Category category,HttpSession session) {
		Category c=categoryMapper.get(category.getId());;
		session.setAttribute("c", c);
		return "mana/categoryMana/editcategory";

	}
	@RequestMapping("updateCategory")
	public String updateCategory(Category category){
		categoryMapper.update(category);
		return "redirect:categoryMana";
		
	}	
	//paper后台管理的跳转页面
	@RequestMapping("/paperMana")
	public String PaperMana(Model model,HttpSession session,Page page) {
		int total=paperMapper.getTotal();
		page.caculateLast(total);
		if(page.getStart()<0){
			page.setStart(0);
		}	
		page.caculateLast(total);
		java.util.List<Paper>papers=paperMapper.listByPage(page.getStart(),page.getStart()+page.getCount());
		model.addAttribute("papers", papers);
		session.getAttribute("user2");
		session.setAttribute("papers", papers);
		session.setAttribute("page", page);
		return "mana/paperMana/listPaper";

	}
	@RequestMapping("/addPaper")
	public String addPaper(Paper Paper,HttpSession session) {
		paperMapper.add(Paper);
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:PaperMana";

	}
	@RequestMapping("/deletePaper")
	public String delPaper(Paper Paper) {
		paperMapper.delete(Paper.getId());;
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:PaperMana";

	}
	@RequestMapping("/editPaper")
	public String editPaper(Paper Paper,HttpSession session) {
		Paper c=paperMapper.get(Paper.getId());;
		session.setAttribute("c", c);
		return "mana/PaperMana/editPaper";

	}
	@RequestMapping("updatePaper")
	public String updatePaper(Paper Paper){
		paperMapper.update(Paper);
		return "redirect:PaperMana";
		
	}	
	//review 后台管理
	@RequestMapping("/reviewMana")
	public String ReviewMana(Model model,HttpSession session,Page page) {
		int total=reviewMapper.getTotal();
		page.caculateLast(total);
		if(page.getStart()<0){
			page.setStart(0);
		}	
		page.caculateLast(total);
		java.util.List<Review>cs=reviewMapper.listByPage(page.getStart(),page.getStart()+page.getCount());
		model.addAttribute("cs", cs);
		session.getAttribute("user2");
		session.setAttribute("page", page);
		return "mana/reviewMana/listReview";

	}
	@RequestMapping("/addReview")
	public String addReview(Review Review,HttpSession session) {
		reviewMapper.add(Review);
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:ReviewMana";

	}
	@RequestMapping("/deleteReview")
	public String delReview(Review Review) {
		reviewMapper.delete(Review.getId());;
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:ReviewMana";

	}
	@RequestMapping("/editReview")
	public String editReview(Review Review,HttpSession session) {
		Review c=reviewMapper.get(Review.getId());;
		session.setAttribute("c", c);
		return "mana/ReviewMana/editReview";

	}
	@RequestMapping("updateReview")
	public String updateReview(Review Review){
		reviewMapper.update(Review);
		return "redirect:ReviewMana";
		
	}	
	//payment后台管理
	@RequestMapping("/paymentMana")
	public String PaymentMana(Model model,HttpSession session,Page page) {
		int total=paymentMapper.getTotal();
		page.caculateLast(total);
		if(page.getStart()<0){
			page.setStart(0);
		}	
		page.caculateLast(total);
		java.util.List<Payment>cs=paymentMapper.listByPage(page.getStart(),page.getStart()+page.getCount());
		model.addAttribute("cs", cs);
		session.getAttribute("user2");
		session.setAttribute("page", page);
		return "mana/paymentMana/listPayment";

	}
	@RequestMapping("/addPayment")
	public String addPayment(Payment Payment,HttpSession session) {
		paymentMapper.add(Payment);
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:PaymentMana";

	}
	@RequestMapping("/deletePayment")
	public String delPayment(Payment Payment) {
		paymentMapper.delete(Payment.getId());;
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:PaymentMana";

	}
	@RequestMapping("/editPayment")
	public String editPayment(Payment Payment,HttpSession session) {
		Payment c=paymentMapper.get(Payment.getId());;
		session.setAttribute("c", c);
		return "mana/PaymentMana/editPayment";

	}
	@RequestMapping("updatePayment")
	public String updatePayment(Payment Payment){
		paymentMapper.update(Payment);
		return "redirect:PaymentMana";
		
	}	
	//用户哦后台管理
	@RequestMapping("/userMana")
	public String UserMana(Model model,HttpSession session,Page page) {
		int total=userMapper.getTotal();
		page.caculateLast(total);
		if(page.getStart()<0){
			page.setStart(0);
		}	
		page.caculateLast(total);
		java.util.List<User>cs=userMapper.listByPage(page.getStart(),page.getStart()+page.getCount());
		model.addAttribute("cs", cs);
		session.getAttribute("user2");
		session.setAttribute("page", page);
		return "mana/userMana/listUser";

	}
	@RequestMapping("/addUser")
	public String addUser(User user,HttpSession session) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userMapper.add(user);
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:UserMana";

	}
	@RequestMapping("/deleteUser")
	public String delUser(User User) {
		userMapper.delete(User.getId());;
		//重定向是mappingURL再到具体页面    转发是具体页面
		return "redirect:UserMana";

	}
	@RequestMapping("/editUser")
	public String editUser(User User,HttpSession session) {
		User c=userMapper.get(User.getId());;
		session.setAttribute("c", c);
		return "mana/UserMana/editUser";

	}
	@RequestMapping("updateUser")
	public String updateUser(User User){
		userMapper.update(User);
		return "redirect:UserMana";
		
	}	

}
