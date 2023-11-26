package com.ewhacse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewhacse.biz.user.UserLoginVO;
import com.ewhacse.biz.user.UserService;
import com.ewhacse.biz.user.UserVO;
import com.ewhacse.biz.user.impl.UserDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@Api(description = "User Controller")
public class UserController {
	@Autowired
	private UserService userService;
	
	
    public ResponseEntity<String> login(@ModelAttribute UserLoginVO vo) {
        boolean success;
        
        if(userService.loginUser(vo) != null) {
        	success = true;
        }else {
        	success = false;
        }

        if (success) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }
	
    @ApiOperation("로그인(post)")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserLoginVO vo, UserDAO userDAO, @ApiIgnore HttpSession session) {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserLoginVO user= userDAO.loginUser(vo);
		if(user != null) {
			session.setAttribute("userid", user.getId());
			return "로그인성공";
		}
		else return "로그인 실패";
	}
	
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String loginForm() {
        return "login";
    }
	
	@ApiOperation("회원가입페이지")
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registration(UserVO vo) {
		userService.registrationUser(vo);
		return "login";
	}
}
