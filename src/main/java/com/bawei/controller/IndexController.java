package com.bawei.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.Article;
import com.bawei.entity.Category;
import com.bawei.entity.Channel;
import com.bawei.entity.Comment;
import com.bawei.entity.Slide;
import com.bawei.entity.User;
import com.bawei.service.ArticleService;
import com.bawei.service.ChannelService;
import com.bawei.service.CommentService;
import com.bawei.service.SlideService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 系统入库
 * @author: 兆龙有点酷
 * @date: 2020年3月9日 上午11:20:33
 */
@Controller

public class IndexController {
	
	@Resource
	private ChannelService service;
	@Resource
	private ArticleService articleservice;
	@Resource
	private SlideService slideservice;
	@Resource
	private CommentService commentservice;
	@RequestMapping(value = {"","/","index"})
	private String index(Model m,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		
		List<Channel> channels = service.selects();
		m.addAttribute("channels", channels);
		//栏目ID
		if (article.getChannelId()!=null) {
			List<Category> categorys = service.selectsByChannelId(article.getChannelId());
            m.addAttribute("categorys", categorys);
		}
		//如果栏目为空，说明没有点击
		if (article.getChannelId()==null) {
			article.setHot(1);
			//查询轮播图
			List<Slide> slides = slideservice.selects();
		    m.addAttribute("slides", slides);
		}
		
		//查询所有文章
		PageInfo<Article> info = articleservice.selects(article, page, pageSize);
		m.addAttribute("info", info);
		
		
		//右侧显示文章
		PageInfo<Article> lastArticle = articleservice.selects(new Article(), 1, 10);
		m.addAttribute("lastArticle", lastArticle);
		return "index/index";
		
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(Integer id,Model m) {
		
		Article article = articleservice.select(id);
		m.addAttribute("article", article);
		return "index/articleDetail";
		
	}
	/**
	 * 
	 * @Title: addComment 
	 * @Description: 增加评论
	 * @param comment
	 * @param articleId
	 * @param session
	 * @return
	 * @return: boolean
	 */
		@ResponseBody
		@RequestMapping("addComment")
		public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
			User user = (User) session.getAttribute("user");
			if(null ==user)
			return false;//没有登录的用户不能评论
			comment.setUserId(user.getId());
			comment.setArticleId(articleId);
			comment.setCreated(new Date());
			
			return commentservice.insert(comment)>0;
		}

}
