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

	private Scanner scan;
	private BoardService boardService;
	private PrintService printService;
	
	public BoardController(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
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
			//insertBoard();
			break;
		case 3:
			//updateBoard();
			break;
		case 4:
			//deleteBoard();
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
			//insertBoardType();
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
