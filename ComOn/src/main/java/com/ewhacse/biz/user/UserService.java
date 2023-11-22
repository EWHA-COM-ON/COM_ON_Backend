package com.ewhacse.biz.user;

public interface UserService {
	//로그인
	UserVO loginUser(UserVO vo);
	
	//회원가입
	void registrationUser(UserVO vo);
}
