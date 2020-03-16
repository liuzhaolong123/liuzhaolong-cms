package com.bawei.service;


import com.bawei.entity.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	
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
	 * @Title: select 
	 * @Description: 单个文章
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 分页
	 * @param article
	 * @param page
	 * @param pgeSize
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> selects(Article article, Integer page, Integer pageSize);
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
