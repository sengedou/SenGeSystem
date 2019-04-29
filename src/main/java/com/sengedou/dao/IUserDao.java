package com.sengedou.dao;

import java.util.List;

import com.sengedou.bean.UserBean;

public interface IUserDao {
	
	 List<UserBean> findAll();

	 UserBean findByName(String name);
}
