package com.ewhacse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.BoardVO;
import com.ewhacse.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/counsilInfo", method = RequestMethod.GET)
	public String InfoBoard(BoardVO vo, Model model) {
		model.addAttribute(boardService.counsilInfoBoard(vo));
		boardService.counsilInfoBoard(vo);
		return "info";
	}
}
