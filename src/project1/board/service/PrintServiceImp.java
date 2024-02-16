package project1.board.service;


import java.util.ArrayList;

import project1.board.model.vo.BoardVO;

public class PrintServiceImp implements PrintService {

	MemberService memberService=new MemberServiceImp();
	BoardService boardService=new BoardServiceImp();
	PostService  postService=new PostServiceImp();

	@Override
	public void startMenu() {
		System.out.println("메뉴");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void printBoard() {
		boardService.printBoard();
	}

	@Override
	public void printBoardCategory() {
		boardService.printBoardCategory();
	}

	@Override
	public void printPostCategory() {
		boardService.printPostCategory();
	}


	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postMenu() {
		// TODO Auto-generated method stub
		
	}

	//관리자 전용 메뉴
	@Override
	public void manageMemberMenu() {
		System.out.println("--회원 관리 메뉴--");
		System.out.println("1. 회원 권한 수정");
		System.out.println("2. 뒤로 가기");
		
	}

	//관리자 전용 메뉴
	@Override
	public void manageBoardMenu() {
		System.out.println("--게시판 관리 메뉴--");
		System.out.println("1. 게시판 카테고리(그룹) 추가");
		System.out.println("2. 게시판 추가");
		System.out.println("3. 게시판 수정");
		System.out.println("4. 게시판 삭제");
		System.out.println("5. 게시판-게시글 말머리 설정");
		System.out.println("6. 뒤로 가기");
	}

	@Override
	public void managePostCategory() {
		System.out.println("--게시판-게시글 말머리 설정--");
		System.out.println("1. 게시글 말머리 등록");
		System.out.println("2. 게시글 말머리 수정");
		System.out.println("3. 게시글 말머리 삭제");
		System.out.println("4. 뒤로 가기");
		
	}

	@Override
	public void manageBoardCategory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}


	//일반 회원 전용 메뉴
	@Override
	public void loggedinUserMenu() {
		System.out.println("--회원 메뉴--");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 나의 커뮤니티 이용내역");
		System.out.println("3. 게시판 보기");
		System.out.println("4. 검색 기능");
		System.out.println("5. 내 정보 수정");
		System.out.println("6. 로그아웃");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void loggedinAdminMenu() {
		System.out.println("--관리자 메뉴--");
		System.out.println("1. 게시판 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 나의 커뮤니티 이용내역");
		System.out.println("4. 게시판 보기");
		System.out.println("5. 검색 기능");
		System.out.println("6. 로그아웃");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void updateMyInfo() {
		System.out.println("--내 정보 수정--");
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이메일 수정");
		System.out.println("3. 나이 수정");
		System.out.println("4. 회원 탈퇴");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public ArrayList<BoardVO> getBoard() {
		return boardService.getBoard();
  }
	public void myCommunityUsed() {
		System.out.println("--나의 커뮤니티 이용내역--");
		System.out.println("1.게시글 수정");
		System.out.println("2.게시글 삭제");
		System.out.println("3.돌아가기");
		System.out.print("메뉴 선택 : ");
	}
	
	public void manageMyPostUpdateMenu() {
		System.out.println("--게시글 수정-");
		System.out.println("1.게시글 제목 수정");
		System.out.println("2.게시글 내용 수정");
		System.out.println("3.돌아가기");
		System.out.print("메뉴 선택 : ");

	}



}