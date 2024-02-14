package project1.board.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostCategoryVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;
import project1.board.service.PostService;
import project1.board.service.PostServiceImp;
import project1.board.service.PrintService;
import project1.board.service.PrintServiceImp;

//게시글 작성을 하는 컨트롤러
//ADMIN과 USER 모두 사용 가능한 컨트롤러
//관리자가 게시판을 생성해야 게시글을 작성할 수 있기 때문에, 게시판이 생성 이전이라면 실행할 수 없는 컨트롤러
//입력받은 값을 PostService에게 보내주는 역할의 컨트롤러

//일반회원은 게시글 작성,수정(본인),삭제(본인)이 가능하고
//관리자는 게시글 작성,수정,삭제 + 공지사항 등록이 가능함

public class PostController {
	private BoardVO boardVo;
	private PostCategoryVO postCategoryVo;
	private PostVO postVo;
	private MemberVO memberVo;
	private ReplyVO replyVo;
	private Scanner scan;
	private PostService postService = new PostServiceImp();
	private PrintService printService = new PrintServiceImp();
	
	
	public void myPageMenu(MemberVO tmpMember) {
		memberVo =tmpMember;
		int menu = 0;
		System.out.println("1.내가 작성한 게시글");
		System.out.println("2.내가 작성한 댓글");
		System.out.println("3.뒤로 가기");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runMyPageMenu(menu, memberVo);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다 : " + menu);
		}
		
	}


	private void runMyPageMenu(int menu, MemberVO memberVo) {
		switch(menu){
		case 1: selectMyPost(memberVo); break;
		case 2: selectMyReply(memberVo); break;
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}


	public void boardMenu(MemberVO tmpMember) {
		// TODO Auto-generated method stub
		
	}


	public void searchMenu(MemberVO tmpMember) {
		// TODO Auto-generated method stub
		
	}
	
	
}
