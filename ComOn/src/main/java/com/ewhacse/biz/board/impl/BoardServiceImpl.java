package com.ewhacse.biz.board.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.CounEventVO;
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
	
	@Override
	public Map<String, List<CounEventVO>> getEventsGroupedByMonth(){
		List<CounEventVO> allEvents = boardDAO.findAll();
		
		Map<String, List<CounEventVO>> eventsGroupedByMonth  = new LinkedHashMap<>();
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
		
		for (CounEventVO event : allEvents) {
            String monthKey = monthFormat.format(event.getDate());

            eventsGroupedByMonth
                    .computeIfAbsent(monthKey, k -> new ArrayList<>())
                    .add(event);
        }

        return eventsGroupedByMonth;
	}
}
