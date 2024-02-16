package project1.board.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostVO;
import project1.board.service.MemberService;
import project1.board.service.MemberServiceImp;
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

	private PostService postService = new PostServiceImp();
	private PostVO postVo;
	private Scanner scan = new Scanner(System.in);
	private PrintService printService = new PrintServiceImp();
	private MemberService memberService =new MemberServiceImp();
	

	public boolean writePost(MemberVO member) {
		System.out.println("게시글을 작성합니다.");
		printService.printBoard();
		System.out.println("게시판 번호를 입력하세요.");
		int po_bo_num=scan.nextInt();
		
		printService.printPostCategory();
		System.out.println("게시글 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		
		System.out.print("게시글 제목을 입력하세요.");
		String po_title=scan.next();
		System.out.print("게시글 내용을 입력하세요.");;
		String po_content=scan.next();

		PostVO postVo = new PostVO(po_title,po_content,member.getMb_id(),po_bo_num,po_pc_num);
	
		if(postService.write(postVo)) {
			return true;
		}
			return false;	
	}
		public void myCommunityManagePost(MemberVO member) {
		
		//if(select * from member where  mb_id=내가 입력한 것 member.getMB_id();)->{ 성공시-> 넣어줌} 실패시->는 없음.
		//List<MemberVO> memberList=memberService.getMemberList(member.getMb_id());	//포기
		//System.out.println(memberList);
		printService.myCommunityUsed();
		int menu=scan.nextInt();
		myCommunityManagePost(menu);
	}
	
	private void myCommunityManagePost(int menu) { //아이디를 받아온 것과 같은 것을 확인해야 됨.
		
		switch(menu) {
		case 1:
			updatePost();	//게시글 수정
			break;
		case 2:
			deletePost();	//게시글 삭제
			break;
		case 3:
			System.out.println("돌아갑니다.");
			break;

		}
		
	}
	

	

	private void updatePost() {
		int menu;
	
		do{
			printService.myCoummunityUsedUpdateMenu();
			menu = scan.nextInt();
			runMyCoummunityUsedUpdateMenu(menu);
			
		}while(menu !=3);
		
	}

	private void runMyCoummunityUsedUpdateMenu(int menu) {
		switch(menu) {
		case 1:
			updatePost_Po_Title();
		case 2:
			updatePost_Po_Content();
		case 3:
			System.out.println("이전으로 돌아갑니다.");
			break;
		
		}
	}
	private void updatePost_Po_Title() {
		//제목을 수정하기 위해 뭐부터 보여줘야 되는가?
		//->게시글 리스트를 보여주고
		List<PostVO> postList = postService.getPostList();
		System.out.println(postList);
		//->게시글 리스트에서 번호를 찾는다.
	}
	private void updatePost_Po_Content() {
		
	}
	private void deletePost() { //게시글 삭제
		
	}

	public void getUserID() {
		
		
	}



	
}
