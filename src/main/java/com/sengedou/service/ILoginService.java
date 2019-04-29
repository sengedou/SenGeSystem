package com.sengedou.service;

import com.sengedou.bean.UserBean;

public interface ILoginService {
	
	UserBean login(String name,String pwd,String authCode);
}
