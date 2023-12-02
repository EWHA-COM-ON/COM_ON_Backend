package com.ewhacse.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ewhacse.biz.board.CounEventVO;
import com.ewhacse.biz.board.CounInfoVO;
import com.ewhacse.biz.board.CounPromVO;
import com.ewhacse.biz.board.OrgChartNode;
import com.ewhacse.biz.common.JDBCUtil;
import com.ewhacse.biz.user.UserVO;

@Repository("BoardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String CounsilInfo ="SELECT counnum, couninfo, counaddress, counlocation, counphone, counemail, countalk, couninsta FROM counsil_Info where counnum = (select max(counnum) from counsil_info)";
	private final String CounsilPromise ="SELECT counpromise FROM counsil_Info where counnum = (select max(counnum) from counsil_info)";
	private final String CounsilEvent = "SELECT * FROM counsil_event where counnum = (select max(counnum) from counsil_info)";
	
	//학생회 정보 화면
	public CounInfoVO counsilInfoBoard() {
		System.out.println("===> JDBC로 counsilInfoBoard 기능 실행");
		CounInfoVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CounsilInfo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new CounInfoVO();
				board.counsilInfoVO(rs.getString("counInfo"),
									rs.getString("counAddress"),
									rs.getString("counLocation"),
									rs.getString("counPhone"),
									rs.getString("counEmail"),
									rs.getString("counTalk"),
									rs.getString("counInsta"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return board;
	}
	//학생회 공약 화면
	public CounPromVO counsilBoard() {
		System.out.println("===> JDBC로 counsilBoard 기능 실행");
		CounPromVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CounsilPromise);
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new CounPromVO();
				board.counsilPromVO(rs.getString("counpromise"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return board;
	}
	
	//조직도 화면
	public OrgChartNode getOrgChart() {
		OrgChartNode root = new OrgChartNode("학생회", 0); //학생회 이름 DB로 수정해야함.
		
		try {
			conn = JDBCUtil.getConnection();
			PreparedStatement teamstmt = conn.prepareStatement("select distinct team from counsil_mem where counnum = (select max(counnum) from counsil_info)");
			ResultSet teamRs = teamstmt.executeQuery();
			while(teamRs.next()) {
				String teamName = teamRs.getString("team");
				OrgChartNode teamNode = new OrgChartNode(teamName, 0);
				//각 팀에 속한 멤버 가져오기
				try (PreparedStatement memberstmt = conn.prepareStatement("select * from counsil_mem where team = ?")){
					memberstmt.setString(1, teamName);
					try(ResultSet memberRs = memberstmt.executeQuery()){
						while(memberRs.next()) {
							String memberName = memberRs.getString("name");
							int level = memberRs.getInt("teamlevel");
							
							OrgChartNode memberNode = new OrgChartNode(memberName, level);
							
							//특정 직급에 해당하는 부모 노드를 찾아서 자식으로 추가
							OrgChartNode parentNode = findNode(teamNode, level-1);
							if(parentNode != null) {
								parentNode.addChild(memberNode);
							} else {
								teamNode.addChild(memberNode);
							}
							System.out.println("team" + teamName+ "level: "+level+"name: "+memberName );
						}
					}
				}
				root.addChild(teamNode);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return root;
	}
	
	private OrgChartNode findNode(OrgChartNode root, int level) {
		for (OrgChartNode child : root.getChildren()){
			if(child.getLevel()==level) {
				return child;
			}
			OrgChartNode found = findNode(child, level);
			if(found != null) {
				return found;
			}
		}
		return null;
	}
	
	//월별 행사
	public List<CounEventVO> findAll() {
		List<CounEventVO> events = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CounsilEvent);
			rs = stmt.executeQuery();
			while (rs.next()) {
				CounEventVO event = mapRowToEvent(rs);
				events.add(event);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return events;	
	}
	private CounEventVO mapRowToEvent(ResultSet rs) throws SQLException {
		CounEventVO event = new CounEventVO();
		event.CounEventVO(rs.getInt("seq"), rs.getInt("counnum"), rs.getString("name"), rs.getString("info"), rs.getDate("date"));
		return event;
	}
	
}
