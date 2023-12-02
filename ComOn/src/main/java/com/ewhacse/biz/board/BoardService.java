package com.ewhacse.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	CounInfoVO boardVO = new CounInfoVO();
	
	//학생회 정보
	CounInfoVO counsilInfoBoard();
	
	//학생회 소개
	CounPromVO counsilBoard();
	
	//행사 일정
	Map<String, List<CounEventVO>> getEventsGroupedByMonth();
}
