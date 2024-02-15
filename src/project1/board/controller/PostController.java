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
	
	
	private void runPost(int menu) {
		
		
		
	}

	public boolean writePost() {
		System.out.println("게시글을 작성합니다.");
		
		System.out.print("게시글 제목을 입력하세요.");
		String po_title=scan.next();
		System.out.print("게시글 내용을 입력하세요.");;
		String content=scan.next();
		String po_mb_id="0";
		int po_bo_num=0;
		int po_pc_num=0;
		
	PostVO postVo = new PostVO(po_title,content,po_mb_id,po_bo_num,po_pc_num);
	
	if(postService.write(postVo)) {
		return true;
	}
	return false;
		
	}
	
}
