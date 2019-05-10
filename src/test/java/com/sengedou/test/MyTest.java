package com.sengedou.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sengedou.bean.UserBean;
import com.sengedou.dao.IUserDao;
import com.sengedou.dao.impl.UserDaoImpl;

public class MyTest {

//	@Before
//	public void before() {
//		System.out.println("代码执行之前的准备");
//	}

	@Test
	public void find() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = context.getBean(UserDaoImpl.class);
		//UserBean bean = dao.findByName("xiaowang");
			//System.out.println(bean);
	}
	
	
	
//	@After
//	public void after() {
//		System.out.println("方法执行完之后的收尾");
//	}
}
