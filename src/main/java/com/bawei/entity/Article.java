package com.bawei.entity;

import java.util.Date;

/**
 * 
 * @ClassName: Article 
 * @Description: 文章内容表
 * @author: 兆龙有点酷
 * @date: 2020年3月3日 上午11:25:32
 */
public class Article {
	
	private Integer id;
	private String title;//标题
	private String summary;//摘要
	private String content;//内容 
	private String picture;//图片
	private Integer channelId;//所属栏目ID
	private Integer categoryId;//所属分类ID
	private Integer userId;//所属用户ID
	private Integer hits;//点击量
	private Integer hot;//是否热门文章 1:热门 0：一般文章
	private Integer status;//文章审核状态 0:待审 1：审核通过 -1：审核未通过
	private Integer deleted;//删除状态 0：正常 1：逻辑删除
	private Date created;//发布时间
	private Date updated;//修改时间
	private Channel channel;
	private Category category;
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article(Integer id, String title, String summary, String content, String picture, Integer channelId,
			Integer categoryId, Integer userId, Integer hits, Integer hot, Integer status, Integer deleted,
			Date created, Date updated, Channel channel, Category category, User user) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.channel = channel;
		this.category = category;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + ", picture="
				+ picture + ", channelId=" + channelId + ", categoryId=" + categoryId + ", userId=" + userId + ", hits="
				+ hits + ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created=" + created
				+ ", updated=" + updated + ", channel=" + channel + ", category=" + category + ", user=" + user + "]";
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
