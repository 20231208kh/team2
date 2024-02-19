package project1.board.controller;

import java.util.InputMismatchException;
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
			printService.manageBoardMenu();	//게시판 관리 메뉴
			menu = scan.nextInt();
			runManager(menu);
		}while(menu != 4);
	}
	
	//게시판 관리자 실행
	public void runManager(int menu) {
		switch (menu) {
		case 1:
			manageBoardCategory();
			break;
		case 2:
			manageBoard();
			break;
		case 3:
			managePostCategory();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}

	private void manageBoard() {
		int menu = 0;
		do {
			printService.manageBoard();
			try {
				menu = scan.nextInt();
				runManageBoard(menu);
			}
			catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}while(menu != 4);
	}

	private void runManageBoard(int menu) {
		switch(menu) {
		case 1:
			insertBoard();
			break;
		case 2:
			updateBoard();
			break;
		case 3:
			deleteBoard();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}

	//게시판 추가
	private void insertBoard() {
		boardService.printBoardCategory();
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
		}
		System.out.println("게시판 추가 실패!");
	}
	
	//게시판 수정
	private void updateBoard() {
		boardService.printBoard();
		System.out.print("게시판 번호 입력 : ");
		int boardNum = scan.nextInt();
		System.out.print("수정할 게시판 이름 입력 : ");
		String boardName = scan.next();
		BoardVO uBoardVo = new BoardVO(boardNum, boardName);
		if(boardService.updateBoard(uBoardVo)) {			
			System.out.println("게시판 수정 성공!");
			return;
		}
		System.out.println("게시판 수정 실패!");
	}
	
	//게시판 삭제
	private void deleteBoard() {
		boardService.printBoard();
		System.out.print("삭제할 게시판 번호 입력 : ");
		int boardNum = scan.nextInt();
		BoardVO dBoardVo = new BoardVO(boardNum);
		if(boardService.deleteBoard(dBoardVo)) {			
			System.out.println("게시판 삭제 성공!");
			return;
		}
		System.out.println("게시판 삭제 실패!");
	}

	//카테고리 관리자 선택
	private void manageBoardCategory() {
		int menu;
		do {
			printService.manageBoardCategory();	//게시판 게시글말머리 수정 메뉴
			menu = scan.nextInt();
			runManageBoardCategory(menu);
		}while(menu != 4);
	}
	
	//카테고리 관리 실행
	private void runManageBoardCategory(int menu) {
		switch(menu) {
		case 1:
			insertBoardCategory();		//게시글 말머리 입력
			break;
		case 2:
			updateBoardCategory();	//게시글 말머리 수정
			break;

		case 3:
			deleteBoardCategory();	//게시글 말머리 삭제
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}

	//카테고리 추가
	private void insertBoardCategory() {
		System.out.print("카테고리 이름 입력 : ");
		String boardCategory = scan.next();
		BoardCategoryVO boardCategoryVO = new BoardCategoryVO(boardCategory);	//카테고리 이름을 생성자로 하는 boardCategoryVO 객체를 생성
		if(boardService.insertBoardCategory(boardCategoryVO)) {
			System.out.println("카테고리 추가 성공!");
			return;
		}
		System.out.println("카테고리 추가 실패!");
	}
	
	//카테고리 수정
	private void updateBoardCategory() {
		boardService.printBoardCategory();
		System.out.print("카테고리 번호 입력 : ");
		int boardCategoryNum = scan.nextInt();
		System.out.print("수정할 카테고리 이름 입력 : ");
		String boardCategoryName = scan.next();
		BoardCategoryVO uBoardCategoryVo = new BoardCategoryVO(boardCategoryNum, boardCategoryName);
		if(boardService.updateBoardCategory(uBoardCategoryVo)) {
			System.out.println("카테고리 수정 성공!");
			return;
		}
		System.out.println("카테고리 수정 실패!");
	}
	
	//카테고리 삭제
	private void deleteBoardCategory() {
		boardService.printBoardCategory();
		System.out.print("삭제할 카테고리 번호 입력 : ");
		int boardCategoryNum = scan.nextInt();
		BoardCategoryVO dBoardCategoryVo = new BoardCategoryVO(boardCategoryNum);
		if(boardService.deleteBoardCategory(dBoardCategoryVo)) {
			System.out.println("카테고리 삭제 성공!");
			return;
		}
		System.out.println("카테고리 삭제 실패!");
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

	//말머리 관리 실행
	private void runManagePostCategory(int menu) {
		switch(menu) {
		case 1:
			insertPostCategory();
			break;
		case 2:
			updatePostCategory();
			break;
		case 3:
			deletePostCategory();
			break;
		case 4:
			System.out.println("돌아가기");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}

	//말머리 추가
	private void insertPostCategory() {
		boardService.printBoard();
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
	
	//말머리 수정
	private void updatePostCategory() {
		boardService.printPostCategory();
		System.out.print("말머리 번호 입력 : ");
		int postCategoryNum = scan.nextInt();
		System.out.print("수정할 말머리 이름 입력 : ");
		String postCategoryName = scan.next();
		PostCategoryVO uPostCategoryVo = new PostCategoryVO(postCategoryNum, postCategoryName);
		if(boardService.updatePostCategory(uPostCategoryVo)) {
			System.out.println("카테고리 수정 성공!");
			return;
		}
		System.out.println("카테고리 수정 실패!");
	}
	
	//말머리 삭제
	private void deletePostCategory() {
		boardService.printPostCategory();
		System.out.print("삭제할 말머리 번호 입력 : ");
		int postCategoryNum = scan.nextInt();
		PostCategoryVO dPostCategoryVo = new PostCategoryVO(postCategoryNum);
		if(boardService.deletePostCategory(dPostCategoryVo)) {
			System.out.println("말머리 삭제 성공!");
			return;
		}
		System.out.println("말머리 삭제 실패!");
	}
}