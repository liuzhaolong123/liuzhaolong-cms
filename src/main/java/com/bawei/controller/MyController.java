package com.bawei.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.entity.Article;
import com.bawei.service.ArticleService;
import com.github.pagehelper.PageInfo;


@RequestMapping("my")
@Controller

public class MyController {
	
	@Resource
	private ArticleService service;
	
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "my/index";
		
	}
	@RequestMapping("articles")
	public String articles(Model model,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "4")Integer pageSize) {
		Article article = new Article();
		article.setUserId(1);
		
		PageInfo<Article> info = service.selects(article, page, pageSize);
		
		model.addAttribute("info", info);
		return "my/articles";
		
	}
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id) {
		
		return service.select(id);
		
	}
	
	@GetMapping("publish")
	public String publish() {
		
		return "my/publish";
		
	}
	
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(MultipartFile file,Article article) {
		if (null!=file &&!file.isEmpty()) {
			String path = "d:/pic/";
			//为了防止文件重名
			String filename = file.getOriginalFilename();
			String Filename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
			
			File f = new File(path, Filename);
			try {
				file.transferTo(f);
				article.setPicture(Filename);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		//文章初始化数据
		article.setUserId(1);
		article.setCreated(new Date());
		article.setHits(0);
		article.setDeleted(0);
		article.setHits(0);
		article.setStatus(0);
		return service.insert(article) >0;
	}

}
