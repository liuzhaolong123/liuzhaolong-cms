package com.bawei.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.Category;
import com.bawei.entity.Channel;
import com.bawei.service.ChannelService;
/**
 * 
 * @ClassName: ChannelController 
 * @Description: 栏目的控制器
 * @author: charles
 * @date: 2020年3月5日 上午10:23:27
 */
@Controller
@RequestMapping("channel")
public class ChannelController {
	
	@Resource
	private ChannelService service;
	/**
	 * 
	 * @Title: channels 
	 * @Description: 查询所有的栏目
	 * @return
	 * @return: List<Channel>
	 */
	@RequestMapping("channels")
	@ResponseBody
	public List<Channel> channels(){
		return service.selects();
	}
	/**
	 * 
	 * @Title: selectsByChannesId 
	 * @Description: 查询所有的分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	@RequestMapping("selectsByChannelId")
	@ResponseBody
	public List<Category> selectsByChannelId(Integer channelId){
		return service.selectsByChannelId(channelId);
	}

}
