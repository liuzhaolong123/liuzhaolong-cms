package com.bawei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.SlideDao;
import com.bawei.entity.Slide;

@Service
public class SlideServiceImpl implements SlideService {

	@Resource
	SlideDao slidedao;
	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slidedao.selects();
	}

}
