package com.sengedou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sengedou.bean.UserBean;
import com.sengedou.dao.IUserDao;
import com.sengedou.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserBean login(UserBean bean) {
		return dao.findByNameAndPass(bean);
	}
	


}
