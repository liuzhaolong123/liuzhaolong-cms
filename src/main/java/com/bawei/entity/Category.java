package com.bawei.entity;
/**
 * 
 * @ClassName: Category 
 * @Description: 栏目分类
 * @author: 兆龙有点酷
 * @date: 2020年3月3日 上午11:23:23
 */
public class Category {
	
	private Integer id;
	private String name;
	private String channeIid;//所属栏目ID
	private Integer sorted;//排序
	
	private Channel channel;

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

	public String getChanneIid() {
		return channeIid;
	}

	public void setChanneIid(String channeIid) {
		this.channeIid = channeIid;
	}

	public Integer getSorted() {
		return sorted;
	}

	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Category(Integer id, String name, String channeIid, Integer sorted, Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.channeIid = channeIid;
		this.sorted = sorted;
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channeIid=" + channeIid + ", sorted=" + sorted
				+ ", channel=" + channel + "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
