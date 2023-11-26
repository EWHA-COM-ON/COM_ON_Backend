package com.ewhacse.biz.user;

public interface UserService {
	//로그인
	UserLoginVO loginUser(UserLoginVO vo);
	
	//회원가입
	void registrationUser(UserVO vo);
}
