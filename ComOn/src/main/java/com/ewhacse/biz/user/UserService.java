package com.ewhacse.biz.user;

public interface UserService {
	//CRUD Method
	public UserVO getUser(UserVO vo);
	
	//회원가입
	UserVO registrationUser(UserVO vo);
}
