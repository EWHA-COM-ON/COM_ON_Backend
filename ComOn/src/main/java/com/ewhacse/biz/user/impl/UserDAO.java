package com.ewhacse.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ewhacse.biz.common.JDBCUtil;
import com.ewhacse.biz.user.UserLoginVO;
import com.ewhacse.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String USER_LOGIN ="select * from user where id=? and pwd=?";
	private final String USER_INSERT = "insert into user(id,pwd,name,phone,num,email,address,level) values(?,?,?,?,?,?,?,3)";
	
	//CRUD
	public boolean loginUser(String id, String pwd) {
		boolean result;
		try {
			System.out.println("===> JDBC로 loginUser 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if (rs.next()){
				result = rs.next();
				System.out.println(result + "+" + rs.getString(1) + rs.getString(2));
				return result;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return false;
	}
	
	//회원가입
	public void registrationUser(UserVO vo) {
		try {
			System.out.println("===> JDBC로 ResgistrationUser 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPwd());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getPhone());
			stmt.setString(5, vo.getNum());
			stmt.setString(6, vo.getEmail());
			stmt.setString(7, vo.getAddress());
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt,conn);
		}
	}
}
