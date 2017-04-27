package com.zero.web;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.utils.MyBatisUtil;
import com.zero.domain.User;
import com.zero.mdao.UserDAO;

public class LoginControllerTest {

	@Test
	public void testLoginPage() {
		SqlSession session = MyBatisUtil.getSession();
		UserDAO userDAO = session.getMapper(UserDAO.class);
		User user = userDAO.findUserByUserName("cody6240");
		System.out.println(user.getPassword());;
	}

}
