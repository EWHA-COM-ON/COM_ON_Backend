package com.ewhacse.comon.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ewhacse.biz.board.BoardService;
import com.ewhacse.biz.board.BoardVO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		//1. 스프링 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. spring 컨테이너로부터 BoardServiceImpl 객체를 look up 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		BoardVO vo = new BoardVO();
		
		//4. 글 목록 검색 기능 테스트
		BoardVO board = boardService.counsilInfoBoard(vo);
		System.out.println("---> " + board.toString());
		
		//5. Spring 컨테이너 종료
		container.close();
	}
}