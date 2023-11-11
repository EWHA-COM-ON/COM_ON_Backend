package com.ewhacse.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ewhacse.biz.user.UserService;
import com.ewhacse.biz.user.UserVO;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registration.do")
	public String loginView(UserVO vo) {
		System.out.println("회원가입 화면으로 이동");
		userService.registrationUser(vo);
		return "login.jsp";
	}

}
