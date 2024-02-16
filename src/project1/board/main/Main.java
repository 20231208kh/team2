package project1.board.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.board.controller.BoardController;
import project1.board.controller.MemberController;
import project1.board.controller.PostController;
import project1.board.model.vo.MemberVO;
import project1.board.service.MemberService;
import project1.board.service.MemberServiceImp;
import project1.board.service.PrintService;
import project1.board.service.PrintServiceImp;


/*
 * 자신의 기본키를 다른 릴레이션이 외래키로 참조 하고 있을 때, 
 * DBMS 테이블 Foreign Keys 항목에 Foreign Key Options의 항목의 값을 변경하면
 * 참조하고 있는 자식 릴레이션을 삭제 하지 않고 부모 릴레이션을 삭제할 수 있다
 * 다만, 자식 릴레이션에서 외래키 설정의 null 값을 허용해줘야 원활한 작업이 가능하다.
 */

/*
 * 게시판 카테고리가 생성되어야 게시판 생성이 가능하다
 * 게시글 카테고리가 생성되어야 게시글 생성이 가능하다
 * 게시글이 생성되어야 댓글 생성이 가능하다
 * 
 * 게시판은 게시판 카테고리에 종속되어있다
 * 게시글 카테고리는 게시판 카테고리에 종속되어있다
 * 
 * 게시글은 게시판과 게시글 카테고리에 종속되어있다
 * 댓글은 게시글에 종속되어있다
 */

/*
 * 게시판을 삭제하면 게시판과 게시판에 존재하는 모든 게시글과 댓글 또한 삭제된다
 * 게시글을 삭제하면 게시글과 게시글에 존재하는 모든 댓글 또한 삭제된다.
 */

/*
 * 사용자는 게시판이 모여있는 게시판 메뉴에서 게시판을 선택하여 해당 게시판에 게시글을 작성하거나,
 * 게시글 작성 메뉴를 통해 원하는 게시판을 선택하고 게시글을 작성할 수 있다.
 * 댓글은 게시글 상세조회를 통해서만 작성할수 있다.
 */


public class Main {
	private static BoardController boardController = new BoardController();
	private static MemberController memberController = new MemberController();
	private static PostController postController;
	private static PrintService printService = new PrintServiceImp();
	private static MemberService memberService = new MemberServiceImp();
	private static MemberVO memberVo;
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int menu = 0;
		do {
			printService.startMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("잘못된 입력");
			}
			
		}while(menu!=3);

	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			memberVo = memberController.login();
			if(memberVo==null) {
				System.out.println("로그인 실패");
				return;
			}
			System.out.println("로그인 성공");
			if(memberVo.getMb_right().equals("ADMIN")) {
				runAdminMenu();
			}else {
				runUserMenu();

			}
			break;
		case 2:
			if(memberController.signIn()) {
				System.out.println("회원가입 성공");
				return;

			}
			System.out.println("회원가입 실패");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private static void runUserMenu() {
		int menu =0;
		do {
			memberVo = memberController.getMemberInfo();
			if(memberVo == null) {
				break;
			}
			printService.loggedinUserMenu();
			try {
				menu = scan.nextInt();
				loggedInUserMenu(menu);
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("잘못된 입력");
			}
		}while(menu !=6);
		
	}

	private static void loggedInUserMenu(int menu) {
		switch(menu) {
		case 1:
			//게시글 작성
			postController.writePost(memberVo);
			break;
		case 2:

			// 마이페이지메뉴
			postController.myPageMenu(memberVo);
			break;
		case 3:
			// 게시판조회메뉴
			postController.boardMenu(memberVo);
			break;
		case 4:
			// 검색조회메뉴
			postController.searchMenu(memberVo);
			break;
		case 5:
			memberController.updateUser();
			break;
		case 6:
			System.out.println("로그아웃 합니다.");
			memberVo = null;

			break;
		default:
			throw new InputMismatchException();
		}
	}

	private static void runUserMenu() {
		int menu =0;
		do {
			memberVo = memberController.getMemberInfo();
			if(memberVo == null) {
				break;
			}
			printService.loggedinUserMenu();
			try {
				menu = scan.nextInt();
				loggedInUserMenu(menu);
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("잘못된 입력");
			}
		}while(menu !=6);
		
	}



	private static void runAdminMenu() {
		int menu =0;
		do {
			printService.loggedinAdminMenu();
			menu = scan.nextInt();
			loggedInAddminMenu(menu);
		}while(menu != 6);
	}

	private static void loggedInAddminMenu(int menu) {
		switch (menu) {
		case 1:
			// 게시판 관리
			boardController.run();
			break;

		case 2:
			// 게시글 작성
			
			break;
		case 3: 
			// 마이페이지
			postController.myPageMenu(memberVo);
			break;
		case 4:
			// 게시판 메뉴
			// 전체, 게시판 
			postController.boardAdminMenu(memberVo);
			break;
		case 5: 
			// 검색 메뉴
			postController.searchAdminMenu(memberVo);
			break;
		case 6: break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	
	
}
		