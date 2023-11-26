package com.ewhacse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewhacse.biz.user.UserService;
import com.ewhacse.biz.user.UserVO;
import com.ewhacse.biz.user.impl.UserDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@Api(description = "User Controller")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation("로그인 페이지")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, @ApiIgnore HttpSession session) {
		UserVO user= userDAO.loginUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println(user.getName()+"님 로그인 성공");
			return "mypage";
		}
		else return "login";
	}
	
	@ApiOperation("회원가입페이지")
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registration(UserVO vo) {
		userService.registrationUser(vo);
		return "login";
	}
}
