package com.ewhacse.biz.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.BoardVO;


@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public BoardVO counsilInfoBoard(BoardVO vo) {
		return boardDAO.counsilInfoBoard(vo);
	}
}
