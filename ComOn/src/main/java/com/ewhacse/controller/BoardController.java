package com.ewhacse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.CounEventVO;
import com.ewhacse.biz.board.CounInfoVO;
import com.ewhacse.biz.board.CounPromVO;
import com.ewhacse.biz.board.OrgChartNode;
import com.ewhacse.biz.board.impl.BoardDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(description = "게시판 controller")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation("학생회 정보")
	@ResponseBody 
	@RequestMapping(value="/counsilInfo", method = RequestMethod.GET)
	public CounInfoVO InfoBoard(Model model) {
		return boardService.counsilInfoBoard();
	}
	
	@ApiOperation("학생회 공약")
	@ResponseBody
	@RequestMapping(value="/counsilPromise", method = RequestMethod.GET)
	public CounPromVO counsilBoard() {
		return boardService.counsilBoard();
	}
	
	@ApiOperation("학생회 멤버(조직도)")
	@ResponseBody
	@RequestMapping(value="/counsilMem", method = RequestMethod.GET)
	public OrgChartNode counsilMemBoard() {
		BoardDAO boardDAO = new BoardDAO();
		OrgChartNode orgChart = boardDAO.getOrgChart();
		return orgChart;
	}
	
	@ApiOperation("월별 일정")
	@ResponseBody
    @RequestMapping(value="/events", method = RequestMethod.GET)
    public Map<String, List<CounEventVO>> getEvents(Model model) {
        Map<String, List<CounEventVO>> events = boardService.getEventsGroupedByMonth();
        return events;
    }
}
