package com.bawei.dao;

import java.util.List;

import com.bawei.entity.User;

public interface UserDao {
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 用户列表
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	List<User> selects(User user);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description: 根据用户查询查询用户是否存在
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);
    /**
     * 
     * @Title: insert 
     * @Description: 注册用户
     * @param user
     * @return
     * @return: int
     */
	int insert(User user);
	 

}
