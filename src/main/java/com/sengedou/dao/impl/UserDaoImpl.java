package com.sengedou.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sengedou.bean.UserBean;
import com.sengedou.dao.IUserDao;

@Repository
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	private SqlSessionFactory fa;
	
	@Override
	public List<UserBean> findAll() {
	

		return null;
	}

	@Override
	public UserBean findByName(String name) {
		SqlSession session = fa.openSession();
		UserBean bean = null;
		try {
			IUserDao dao = session.getMapper(IUserDao.class);
			bean = dao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}

	
}
