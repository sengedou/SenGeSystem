package com.sengedou.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sengedou.bean.ClassBean;
import com.sengedou.bean.StudentBean;
import com.sengedou.bean.UserBean;
import com.sengedou.util.MybatisUtil;

public class MyTest {

//	@Before
//	public void before() {
//		System.out.println("代码执行之前的准备");
//	}

	@Test
	public void findUserById() {
		// 读取配置文件加载mybatis运行环境
		String path = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(path);
			// 产生工厂对象
			SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(in);
			// 产生连接对象
			SqlSession session = fa.openSession();
			UserBean bean = session.selectOne("mapper1.findById", 2);
			System.out.println(bean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void add() {
		// 读取配置文件加载mybatis运行环境
		String path = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(path);
			// 产生工厂对象
			SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(in);
			// 产生连接对象
			SqlSession session = fa.openSession();
			UserBean bean = new UserBean();
			bean.setName("zhang");
			bean.setPwd("123456");
			session.insert("mapper1.add", bean);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void find1() {
		SqlSession session = MybatisUtil.getSqlSession();
		UserBean bean = session.selectOne("mapper1.findById", 1);
		System.out.println(bean);
		session.close();
	}
	
	@Test
	public void find2() {
		SqlSession session = MybatisUtil.getSqlSession();
		UserBean bean = session.selectOne("mapper1.findById2", 1);
		System.out.println(bean);
		session.close();
	}

	@Test
	public void findAll() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserBean> list = session.selectList("mapper1.findAll");
		for (UserBean userBean : list) {
			System.out.println(userBean);
		}
		session.close();
	}

	@Test
	public void add1() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		try {
			UserBean bean = new UserBean();
			bean.setName("li");
			bean.setPwd("0000");
			session.insert("mapper1.add", bean);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void del1() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		try {
			session.delete("mapper1.del", 6);
		} catch (Exception e) {
			session.rollback();
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void update1() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserBean bean = new UserBean();
		bean.setId(4);
		bean.setPwd("0000");
		session.update("mapper1.update", bean);
		session.close();
	}
	
	@Test
	public void findAll2() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserBean> list = session.selectList("mapper1.findAll");
		for (UserBean userBean : list) {
			System.out.println(userBean);
		}
		session.close();
	}
	
	@Test
	public void findAll3() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserBean> list = session.selectList("mapper1.findAll");
		for (UserBean userBean : list) {
			System.out.println(userBean);
		}
		session.close();
	}
	
	@Test
	public void findStudentById() {
		SqlSession session=MybatisUtil.getSqlSession();
		StudentBean stu=session.selectOne("com.sengedou.bean.StudentBean.findById",1);
		System.out.println(stu);
		session.close();
		
	}
	
	@Test
	public void findClassById() {
		SqlSession session=MybatisUtil.getSqlSession();
		ClassBean cl=session.selectOne("com.sengedou.bean.ClassBean.findById",1);
		System.out.println(cl);
		session.close();
	}
	
//	@After
//	public void after() {
//		System.out.println("方法执行完之后的收尾");
//	}
}
