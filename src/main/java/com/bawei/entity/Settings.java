package com.bawei.entity;
/**
 * 
 * @ClassName: Settings 
 * @Description: 系统配置表
 * @author: 兆龙有点酷
 * @date: 2020年3月3日 上午11:40:06
 */
public class Settings {
	
	private Integer id;
	private String siteDomain;
	private String siteName;
	private String siteSize;
	private Integer articleListSZize;//文章条目
	private String slideSize;//广告条目
	private String adminUsername;
	private String adminPassword;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiteDomain() {
		return siteDomain;
	}
	public void setSiteDomain(String siteDomain) {
		this.siteDomain = siteDomain;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteSize() {
		return siteSize;
	}
	public void setSiteSize(String siteSize) {
		this.siteSize = siteSize;
	}
	public Integer getArticleListSZize() {
		return articleListSZize;
	}
	public void setArticleListSZize(Integer articleListSZize) {
		this.articleListSZize = articleListSZize;
	}
	public String getSlideSize() {
		return slideSize;
	}
	public void setSlideSize(String slideSize) {
		this.slideSize = slideSize;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Settings(Integer id, String siteDomain, String siteName, String siteSize, Integer articleListSZize,
			String slideSize, String adminUsername, String adminPassword) {
		super();
		this.id = id;
		this.siteDomain = siteDomain;
		this.siteName = siteName;
		this.siteSize = siteSize;
		this.articleListSZize = articleListSZize;
		this.slideSize = slideSize;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Settings [id=" + id + ", siteDomain=" + siteDomain + ", siteName=" + siteName + ", siteSize=" + siteSize
				+ ", articleListSZize=" + articleListSZize + ", slideSize=" + slideSize + ", adminUsername="
				+ adminUsername + ", adminPassword=" + adminPassword + "]";
	}
	public Settings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
