package com.bawei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.CommentDao;
import com.bawei.entity.Article;
import com.bawei.entity.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDao dao;
	
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		return dao.insert(comment);
	}

	@Override
	public PageInfo<Comment> selects(Article article, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Comment> list = dao.selects(article);
		
		return new PageInfo<Comment>(list);
	}

}
