package com.bawei.service;

import com.bawei.entity.Article;
import com.bawei.entity.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService {
    /**
     * 
     * @Title: insert 
     * @Description: 增加评论
     * @param comment
     * @return
     * @return: int
     */
	int insert(Comment comment);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据文章查询文章评论
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Comment>
	 */
	PageInfo<Comment> selects(Article article,Integer page,Integer pageSize);

}
