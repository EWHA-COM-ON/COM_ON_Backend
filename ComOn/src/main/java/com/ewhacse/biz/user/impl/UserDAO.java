package com.ewhacse.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ewhacse.biz.common.JDBCUtil;
import com.ewhacse.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String USER_GET ="select * from user where id=? and pwd=?";
	private final String USER_INSERT = "insert into user(id,pwd,name,phone,num,email,address,level) values(?,?,?,?,?,?,?,3)";
	
	//CRUD
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 getUser 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPwd());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPwd(rs.getString("PWD"));
				user.setName(rs.getString("NAME"));
				user.setNum(rs.getString("NUM"));
				user.setPhone(rs.getString("PHONE"));

			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return user;
	}
	
	//회원가입
	public UserVO registrationUser(UserVO vo) {
		UserVO user = null;
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
		return user;
	}
}
