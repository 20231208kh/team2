package project1.board.controller;

import java.sql.Date;
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
	

	public void writePost() {
		printService.printBoard();
	
	}
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
	
	private void updatePost() {	//게시글 수정
	
		//게시글 수정을 하기 위해서-> id리스트에서 id가 동일한지 확인해야함
		//어떻게 확인-> 
		
		int menu = scan.nextInt();
		switch(menu){
		case 1:
			updatePostCategory();
			break;
		case 2:
			updatePostTitle;
			break;
		case 3:
			updatePostContent;
			break;
			
		}
		
	
		
	}
	

	private void deletePost() { //게시글 삭제
		
	}

	public void getUserID() {
		
		
	}


	
}
