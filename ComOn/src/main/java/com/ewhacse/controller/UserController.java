package com.ewhacse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ewhacse.biz.user.UserService;
import com.ewhacse.biz.user.UserVO;
import com.ewhacse.biz.user.impl.UserDAO;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		UserVO user= userDAO.loginUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println(user.getName()+"님 로그인 성공");
			return "mypage.jsp";
		}
		else return "login.jsp";
	}
	
	@RequestMapping(value="/registration.do", method=RequestMethod.POST)
	public String registration(UserVO vo) {
		userService.registrationUser(vo);
		return "login.jsp";
	}
}
