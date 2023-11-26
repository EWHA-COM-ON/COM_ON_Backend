package com.ewhacse.biz.board;

public interface BoardService {

	CounInfoVO boardVO = new CounInfoVO();
	
	//학생회 정보
	CounInfoVO counsilInfoBoard();
	
	//학생회 소개
	CounPromVO counsilBoard();
}
