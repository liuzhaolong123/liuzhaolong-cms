package com.bawei.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.common.utils.StringUtil;
import com.bawei.dao.UserDao;
import com.bawei.entity.User;
import com.bawei.util.CMSException;
import com.bawei.util.Md5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao dao;
	
	@Override
	public PageInfo<User> selects(User user, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<User> list = dao.selects(user);
		return new PageInfo<User>(list);
	}

	@Override
	public int update(User user) {
		return dao.update(user);
	}

	@Override
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.selectByUsername(username);
	}

	@Override
	public int insert(User user) {

		// int i= 10/0;
		// 通过自定义校验规则，对注册用户进行校验
		// 1 用户名不能为空。长度在合理区间。用户名不能重复
		if (!StringUtil.hasText(user.getUsername()))
			throw new CMSException("用户名不能为空");
		if (!(user.getUsername().length() >= 2 && user.getUsername().length() <= 10))
			throw new CMSException("用户名的长度在2-10之间");
		User findUser = this.selectByUsername(user.getUsername());
		if (null != findUser)
			throw new CMSException("用户名已经被注册.");

		// 2密码校验
		if (!StringUtil.hasText(user.getPassword()))
			throw new CMSException("密码不能为空");
		if (!(user.getPassword().length() >= 6 && user.getPassword().length() <= 10))
			throw new CMSException("密码的长度在6-10之间");
		// 3确认密码 两次密码输入必须一致
		if (!StringUtil.hasText(user.getRepassword()))
			throw new CMSException("确认密码不能为空");
		if (!user.getRepassword().equals(user.getPassword()))
			throw new CMSException("两次密码输入不一致");

		// 4 对用户密码进行加密煮处理
		user.setPassword(Md5Util.encode(user.getPassword()));
		// 初始用户的注册信息----
		user.setCreated(new Date());//注册时间
		user.setNickname(user.getUsername());//默认用户昵称为用户名称
		user.setLocked("0");//默认用户状态是可用的
		
		return dao.insert(user);
	}

	@Override
	public User login(User user) {
		// 1 校验 用户名不能为空"
				if (!StringUtil.hasText(user.getUsername()))
					throw new CMSException("用户名不能为空");
				// 2 检查用户名是否存在
				User u = this.selectByUsername(user.getUsername());
				if (null == u) {
					throw new CMSException("该用户名不存在");
				}
				// 3 比较密码是否一致 //数据库存储的是 加密后的密码
				// 对登录的密码再进行加密 再和数据库的密码进行比较
				if (!Md5Util.encode(user.getPassword()).equals(u.getPassword()))
					throw new CMSException("密码不正确，请重新录入");

				return u;

	}
	

}
