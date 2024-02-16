package project1.board.controller;

import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostVO;
import project1.board.service.PostService;
import project1.board.service.PostServiceImp;

//게시글 작성을 하는 컨트롤러
//ADMIN과 USER 모두 사용 가능한 컨트롤러
//관리자가 게시판을 생성해야 게시글을 작성할 수 있기 때문에, 게시판이 생성 이전이라면 실행할 수 없는 컨트롤러
//입력받은 값을 PostService에게 보내주는 역할의 컨트롤러

//일반회원은 게시글 작성,수정(본인),삭제(본인)이 가능하고
//관리자는 게시글 작성,수정,삭제 + 공지사항 등록이 가능함

public class PostController {
	PostService postService = new PostServiceImp();

	public void writePost(MemberVO member) {
		
		PostVO tmp = new PostVO("제목","내용",member.getMb_id(),1,1);
		postService.writePost(tmp);
		
	}

}
