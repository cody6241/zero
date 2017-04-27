package com.zero.mdao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zero.domain.LoginLog;
import com.zero.domain.User;

public interface UserDAO {

	public int getMatchCount(@Param("userName")String userName, @Param("password")String password);
	
	public User findUserByUserName(String userName);
	
	public void updateLoginInfo(User user);
	
	public void insertLoginLog(LoginLog loginLog);
}
