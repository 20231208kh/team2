package project1.board.controller;

import java.util.ArrayList;
import java.util.Scanner;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;
import project1.board.service.BoardService;
import project1.board.service.BoardServiceImp;
import project1.board.service.PrintService;
import project1.board.service.PrintServiceImp;

//게시판을 관리하는 컨트롤러
//로그인한 아이디의 권한이 ADMIN 일시 이용가능
//이 컨트롤러에서 게시판, 게시판분류, 게시글 분류를 입력받음
//입력받은 내용을 BoardService에 보내주는 역할의 컨트롤러
public class BoardController {

	private Scanner scan = new Scanner(System.in);
	private BoardService boardService = new BoardServiceImp();
	private PrintService printService = new PrintServiceImp();
	
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
			manageBoardCategory();
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
			managePostCategory();
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
		ArrayList<BoardCategoryVO> categoryList = boardService.getBoardType();
		if(categoryList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
		for(BoardCategoryVO tmp : categoryList) {
			System.out.println(tmp);
		}
		
		System.out.print("카테고리 번호 입력 : ");
		int boardCategoryNum = scan.nextInt();
		System.out.print("게시판 이름 입력 : ");
		String boardName = scan.next();
		System.out.print("내용 입력 : ");
		String boardDetail = scan.next();
		
		BoardVO boardVo = new BoardVO(boardName, boardDetail, boardCategoryNum);
		if(boardService.insertBoard(boardVo)) {			
			System.out.println("게시판 추가 성공!");
			return;
		};
		System.out.println("게시판 추가 실패!");
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
	private void manageBoardCategory() {
		int menu;
		do {
			printService.manageBoardCategory();
			menu = scan.nextInt();
			runManageBoardCategory(menu);
		}while(menu != 4);
	}
	
	//게시판 분류 실행
	private void runManageBoardCategory(int menu) {
		switch(menu) {
		case 1:
			insertBoardCategory();
			break;
		case 2:
			//updateBoardCategory();
			break;
		case 3:
			//deleteBoardCategory();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}
	
	//분류 추가
	private void insertBoardCategory() {
		System.out.println("카테고리 이름 입력 : ");
		String boardCategory = scan.next();
		BoardCategoryVO boardCategoryVO = new BoardCategoryVO(boardCategory);
		if(boardService.insertBoardType(boardCategoryVO)) {
			System.out.println("카테고리 추가 성공!");
			return;
		}
		System.out.println("카테고리 추가 실패!");
	}

	//말머리 관리자 선택
	private void managePostCategory() {
		int menu;
		do {
			printService.managePostCategory();
			menu = scan.nextInt();
			runManagePostCategory(menu);
		}while(menu != 4);
		
	}

	//말미러 관리자 실행
	private void runManagePostCategory(int menu) {
		switch(menu) {
		case 1:
			insertPostCategory();
			break;
		case 2:
			//updatePostCategory();
			break;
		case 3:
			//deletePostCategory();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}

	private void insertPostCategory() {
		ArrayList<BoardVO> boardList = boardService.getBoard();
		if(boardList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
		for(BoardVO tmp : boardList) {
			System.out.println(tmp);
		}
		
		System.out.print("게시판 번호 입력 : ");
		int boardNum = scan.nextInt();
		System.out.print("말머리 이름 입력 : ");
		String postCategoryName = scan.next();
		
		PostCategoryVO postCategoryVo = new PostCategoryVO(postCategoryName, boardNum);
		if(boardService.insertPostCategory(postCategoryVo)) {			
			System.out.println("말머리 추가 성공!");
			return;
		};
		System.out.println("말머리 추가 실패!");
	}
	
}
