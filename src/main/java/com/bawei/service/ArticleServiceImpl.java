package com.bawei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.ArticleDao;
import com.bawei.entity.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao dao;
	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return dao.insert(article);
	}

	
	@Override
	public PageInfo<Article> selects(Article article, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Article> list = dao.selects(article);
		return new PageInfo<Article>(list);
	}


	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}


	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return dao.update(article);
	}


}
