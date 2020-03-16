package com.bawei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.ChannelDao;
import com.bawei.entity.Category;
import com.bawei.entity.Channel;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Resource
	private ChannelDao dao;
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return dao.selects();
	}
	@Override
	public List<Category> selectsByChannelId(Integer channleId) {
		// TODO Auto-generated method stub
		return dao.selectsByChannelId(channleId);
	}

}
