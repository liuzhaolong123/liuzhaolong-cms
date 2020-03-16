package com.bawei.entity;
/**
 * 
 * @ClassName: Channel 
 * @Description: 文章栏目表
 * @author: 兆龙有点酷
 * @date: 2020年3月3日 上午11:21:37
 */
public class Channel{
	
	private Integer id;
	private String name;
	private String description;
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", sorted=" + sorted
				+ ", icon=" + icon + "]";
	}
	public Channel(Integer id, String name, String description, String sorted, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sorted = sorted;
		this.icon = icon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSorted() {
		return sorted;
	}
	public void setSorted(String sorted) {
		this.sorted = sorted;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String sorted;//排序
	private String icon;//图标

}
