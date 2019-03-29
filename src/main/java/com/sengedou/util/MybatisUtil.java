package com.sengedou.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	/**
	 *  产生工厂对象   
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory fa = null;
		try {
			// 读取配置文件加载mybatis运行环境
			String path = "mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(path);
			// 产生工厂对象
			fa = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fa;
	}
	
	/**
	 *  产生sqlsession对象  
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	} 
	
	/**
	 *  产生sqlsession对象  
	 * @param boo boo:ture 自动提交事务
	 * @return
	 */
	public static SqlSession getSqlSession(boolean boo) {
		return getSqlSessionFactory().openSession(boo);
	}
}
