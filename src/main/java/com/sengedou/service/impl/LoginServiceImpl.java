package com.sengedou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sengedou.bean.UserBean;
import com.sengedou.dao.IUserDao;
import com.sengedou.service.ILoginService;
@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserBean login(String name, String pwd, String authCode) {
		UserBean bean = dao.findByName(name);
		System.out.println(bean.toString());
		return null;
	}
	


}
