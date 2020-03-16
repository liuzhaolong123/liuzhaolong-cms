package com.bawei.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.Article;
import com.bawei.entity.User;
import com.bawei.service.ArticleService;
import com.bawei.service.UserService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: AdminController 
 * @Description: 管理员中心
 * @author: 兆龙有点酷
 * @date: 2020年3月8日 上午9:17:14
 */
@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Resource
	ArticleService service;
	@Resource
	UserService userservice;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "admin/index";
	}
	/**
	 * 
	 * @Title: articles 
	 * @Description: 进入文章审核列表
	 * @param m
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
    private String articles(Model m,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		
		PageInfo<Article> info = service.selects(article, page, pageSize);
		
		m.addAttribute("info", info);
		m.addAttribute("article", article);
		
		return "admin/articles";
		
	}
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改文章
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Article article) {
		
		return service.update(article)>0;
		
	}
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 更新用户
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("updateUser")
	public boolean updateUser(User user) {
		
		return userservice.update(user) >0;
	}
	
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 单个文章内容
	 * @param id
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id) {
		
		return service.select(id);
		
	}
	/**
	 * 
	 * @Title: users 
	 * @Description: 用户列表
	 * @param model
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "18") Integer pageSize) {
		
		PageInfo<User> info = userservice.selects(user, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		return "admin/users";
		
	}
	
}
