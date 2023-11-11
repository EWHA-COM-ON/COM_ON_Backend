package com.ewhacse.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ewhacse.biz.user.UserVO;
import com.ewhacse.biz.user.impl.UserDAO;


@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId(vo.getId());
		vo.setPwd(vo.getPwd());
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user= userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println(user.getName()+"님 로그인 성공");
			return "mypage.do";
		}
		else return "login.jsp";
	}
}
