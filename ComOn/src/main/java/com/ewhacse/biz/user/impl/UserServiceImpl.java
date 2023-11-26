package com.ewhacse.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewhacse.biz.user.UserLoginVO;
import com.ewhacse.biz.user.UserService;
import com.ewhacse.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserLoginVO loginUser(UserLoginVO vo) {
		return userDAO.loginUser(vo);
	}
	
	@Override
	public void registrationUser(UserVO vo) {
		userDAO.registrationUser(vo);
	}
}
