package com.bawei.dao;
/**
 * 
 * @ClassName: ChannelDao 
 * @Description: 栏目
 * @author: 兆龙有点酷
 * @date: 2020年3月5日 上午10:06:29
 */

import java.util.List;

import com.bawei.entity.Category;
import com.bawei.entity.Channel;

public interface ChannelDao {
	
  List<Channel> selects();
  
  List<Category> selectsByChannelId(Integer channleId);

}
