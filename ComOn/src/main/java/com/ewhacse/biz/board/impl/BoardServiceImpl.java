package com.ewhacse.biz.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.CounInfoVO;
import com.ewhacse.biz.board.CounPromVO;
import com.ewhacse.biz.board.OrgChartNode;


@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public CounInfoVO counsilInfoBoard() {
		return boardDAO.counsilInfoBoard();
	}
	
	@Override
	public CounPromVO counsilBoard() {
		return boardDAO.counsilBoard();
	}
}
