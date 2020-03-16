package com.bawei.dao;

import java.util.List;

import com.bawei.entity.Article;

public interface ArticleDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章列表
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article article);

	/**
	 * 
	 * @Title: articleDatail 
	 * @Description: 单个文章
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改热门
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
}
