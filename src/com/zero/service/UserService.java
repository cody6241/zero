package com.zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utils.MD5Encipher;
import com.zero.dao.LoginLogDao;
import com.zero.dao.UserDao;
import com.zero.domain.LoginLog;
import com.zero.domain.User;

@Service
public class UserService {
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user) {
		user.setCredits( 5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}

	/**
	 * @Author Cody 2016年11月16日
	 * @param user
	 * @Description: 新增用户
	 */
	public void add(User user) {
		md5EncipherUserPassword(user);
		userDao.add(user);
	}

	/**
	 * @Author Cody 2016年11月16日
	 * @param user
	 * @Description: MD5加密用户密码
	 */
	private void md5EncipherUserPassword(User user) {
		if(user != null && user.getPassword() != null){
			user.setPassword(MD5Encipher.doMD5Encipher(user.getPassword()));
		}
	}

	
	

}
