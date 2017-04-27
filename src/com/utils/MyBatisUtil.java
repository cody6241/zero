package com.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
	
	private static SqlSessionFactory sessionFactory = null;
    
    public static SqlSessionFactory getSqlSessionFactory(){
    	if(sessionFactory == null){
    		// 获得环境配置文件流
    		InputStream config = MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis_cfg.xml");
    		// 创建sql会话工厂
    		sessionFactory = new SqlSessionFactoryBuilder().build(config);
    	}
        return sessionFactory;
    }
    
    //获得会话
    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession(true);
    }
    
    /**
     * 获得得sql会话
     * @param isAutoCommit 是否自动提交，如果为false则需要sqlSession.commit();rollback();
     * @return sql会话
     */
    public static SqlSession getSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
    
}