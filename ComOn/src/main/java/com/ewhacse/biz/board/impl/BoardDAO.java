package com.ewhacse.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ewhacse.biz.board.BoardVO;
import com.ewhacse.biz.common.JDBCUtil;
import com.ewhacse.biz.user.UserVO;

@Repository("BoardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String CounsilInfo ="select * from counsil_Info  WHERE counnum is not null order by counnum desc limit 1";
	
	//학생회 정보 화면
	public BoardVO counsilInfoBoard(BoardVO vo) {
		System.out.println("===> JDBC로 counsilInfoBoard 기능 실행");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CounsilInfo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setCounNum(rs.getInt("counNum"));
				board.setCounName(rs.getString("counName"));
				board.setCounInfo(rs.getString("counInfo"));
				board.setCounAddress(rs.getString("counAddress"));
				board.setCounLocation(rs.getString("counLocation"));
				board.setCounPhone(rs.getString("counPhone"));
				board.setCounEmail(rs.getString("counEmail"));
				board.setCounTalk(rs.getString("counTalk"));
				board.setCounInsta(rs.getString("counInsta"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return board;
	}
}
