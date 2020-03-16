package com.bawei.service;

import java.util.List;

import com.bawei.entity.Category;
import com.bawei.entity.Channel;

/**
 * 
 * @ClassName: ChannelService 
 * @Description: 栏目
 * @author: 兆龙有点酷
 * @date: 2020年3月5日 上午10:08:28
 */
public interface ChannelService {
	
	List<Channel> selects();
	List<Category> selectsByChannelId(Integer channleId);

}
