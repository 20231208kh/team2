package project1.board.controller;

import java.util.Scanner;

import project1.board.service.BoardService;
import project1.board.service.BoardServiceImp;
import project1.board.service.PrintService;

//게시판을 관리하는 컨트롤러
//로그인한 아이디의 권한이 ADMIN 일시 이용가능
//이 컨트롤러에서 게시판, 게시판분류, 게시글 분류를 입력받음
//입력받은 내용을 BoardService에 보내주는 역할의 컨트롤러
public class BoardController {

	private Scanner scan = new Scanner(System.in);
	private BoardService boardService;
	private PrintService printService;
	
	
	public void run() {
		int menu;
		do {
			printService.manageBoardMenu();
			menu = scan.nextInt();
			runManageBoard(menu);
		}while(menu != 6);
		
	}
	
	//게시판 관리자 실행
	public void runManageBoard(int menu) {
		switch (menu) {
		case 1:
			manageBoardType();
			break;
		case 2:
			insertBoard();
			break;
		case 3:
			updateBoard();
			break;
		case 4:
			//deleteBoard(); //최소 하나는 남겨둬야한다
			break;
		case 5:
			managePostType();
			break;
		case 6:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}
	
	//게시판 추가
	private void insertBoard() {
		/*
		분류 이름 입력
		이미 존재하는 이름이라면
		FALSE
		없다면 생성
		TRUE
		
		System.out.println("게시판 이름 입력 : ");
		String boardName = scan.next();
		if(BoardService.insertBoard()) {			
			System.out.println("게시판 추가 성공!");
		};
		System.out.println("게시판 추가 실패!");
		*/
	}
	
	//게시판 수정
	private void updateBoard() {
		/*
		분류 번호, 이름 출력
		분류 번호 입력
		잘못 입력시
		FALSE
		해당 번호 입력시
		수정할 이름 입력
		이미 존재하는 이름이면
		FALSE
		없으면
		TRUE
		*/
		//분류번호, 이름 출력
		/*
		BoardService.printBoard();
		System.out.println("분류번호 입력 : ");
		int boardNum = scan.nextInt();
		if(BoardService.updateBoard()) {			
			System.out.println("게시판 수정 성공!");
		};
		System.out.println("게시판 수정 실패!");
		*/
	}

	//게시판 분류 관리자 선택
	private void manageBoardType() {
		int menu;
		do {
			printService.manageBoardMenu();
			menu = scan.nextInt();
			runManageBoardType(menu);
		}while(menu != 4);
	}
	
	//게시판 분류 실행
	private void runManageBoardType(int menu) {
		switch(menu) {
		case 1:
			insertBoardType();
			break;
		case 2:
			//updateBoardType();
			break;
		case 3:
			//deleteBoardType();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}
	
	//분류 추가
	private void insertBoardType() {
		String boardType = scan.next();
		if(boardService.insertBoardType(boardType)) {
			System.out.println("추가 성공");
			return;
		}
		System.out.println("추가 실패");
		
	}

	//말머리 관리자 선택
	private void managePostType() {
		int menu;
		do {
			printService.managePostCategory();
			menu = scan.nextInt();
			runManagePostType(menu);
		}while(menu != 4);
		
	}

	//말미러 관리자 실행
	private void runManagePostType(int menu) {
		switch(menu) {
		case 1:
			//insertPostType();
			break;
		case 2:
			//updatePostType();
			break;
		case 3:
			//deletePostType();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}
	
}
