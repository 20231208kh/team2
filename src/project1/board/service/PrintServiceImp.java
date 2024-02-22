package project1.board.service;


import java.util.ArrayList;

import project1.board.dao.PostDAO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;

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
		System.out.println("1. 카테고리(그룹) 설정");
		System.out.println("2. 게시판 설정");
		System.out.println("3. 말머리 설정");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void manageBoardCategory() {
		System.out.println("--카테고리 설정--");
		System.out.println("1. 카테고리 추가");
		System.out.println("2. 카테고리 수정");
		System.out.println("3. 카테고리 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void manageBoard() {
		System.out.println("--게시판 설정--");
		System.out.println("1. 게시판 추가");
		System.out.println("2. 게시판 수정");
		System.out.println("3. 게시판 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void managePostCategory() {
		System.out.println("--말머리 설정--");
		System.out.println("1. 게시글 말머리 등록");
		System.out.println("2. 게시글 말머리 수정");
		System.out.println("3. 게시글 말머리 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
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
		System.out.println("2. 게시글 작성");
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
		System.out.println("5. 돌아가기");
		System.out.print("메뉴 선택 : ");
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
	
	
	@Override
	public void myPostDetail(PostVO tmpPost) {
		if(tmpPost == null) {
			System.out.println("상세조회 실패");
			return;
		}
		System.out.println("==============================");
		System.out.println("["+tmpPost.getPo_pc_title()+"]"+tmpPost.getPo_title());
		System.out.println(tmpPost.getPo_mb_id() + "  " + tmpPost.getPo_date() + " 조회수 : " 
							+ tmpPost.getPo_viewCount());
		System.out.println(tmpPost.getPo_content());
		System.out.println("==============================");
	}
	

	@Override
	public void postDetail(PostVO tmpPost) {
		// 조회수 증가 후 동일한 게시글 재호출
		PostVO post = postService.increaseVeiwCount(tmpPost);
		if(post == null) {
			System.out.println("상세조회 실패");
			return;
		}
		System.out.println("==============================");
		System.out.println("["+post.getPo_pc_title()+"]"+post.getPo_title());
		System.out.println(post.getPo_mb_id() + "  " + post.getPo_date() + " 조회수 : " 
							+ post.getPo_viewCount());
		System.out.println(post.getPo_content());
		System.out.println("==============================");
	}


	@Override
	public void printPostList(ArrayList<PostVO> postList) {
		System.out.println("==============================");
		for(int i = 0 ; i < postList.size() ; i++) {
			System.out.println((i+1)+". "+ postList.get(i));
		}
		System.out.println("==============================");
	}


	@Override
	public void printBoardList(ArrayList<BoardVO> boardList) {
		System.out.println("==============================");
		for(int i = 0 ; i < boardList.size() ; i++) {
			System.out.println((i+1)+". "+ boardList.get(i));
		}
		System.out.println("==============================");
	}


	@Override
	public void printReply(ArrayList<ReplyVO> replyList) {
		System.out.println("==============================");
		for(int i = 0 ; i < replyList.size(); i++) {
			System.out.println((i+1)+". "+ replyList.get(i));
		}
		System.out.println("==============================");
	}


	@Override
	public void adminChoosePostMenu() {	
		
		System.out.println("--관리자 작성 메뉴--");
		System.out.println("1.공지사항 작성");
		System.out.println("2.게시글 작성");
		System.out.println("3.돌아가기");
		System.out.println("메뉴 선택 : ");
		
	}


	@Override
	public ArrayList<PostCategoryVO> getpostList() {
		
		return postService.getPostList() ;
	}


	@Override
	public ArrayList<BoardVO> getBoard() {
		// TODO Auto-generated method stub
		return null;
	}



	

	


	
	
}

	@Override
	public ArrayList<PostCategoryVO> getPC(int num) {
	
		return postService.getPC(num);
	}



	


}