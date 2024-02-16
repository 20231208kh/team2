package project1.board.controller;

import java.util.ArrayList;
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
	private Scanner scan;
	private PostService postService = new PostServiceImp();
	private PrintService printService = new PrintServiceImp();
	
	
	public void myPageMenu(MemberVO tmpMember) {
		int menu = 0;
		System.out.println("1.내가 작성한 게시글");
		System.out.println("2.내가 작성한 댓글");
		System.out.println("3.뒤로 가기");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runMyPageMenu(menu, tmpMember);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
		
	}


	private void runMyPageMenu(int menu, MemberVO tmpMember) {
		switch(menu){
		case 1: myPost(tmpMember); break;
		case 2: myReply(tmpMember); break;
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}


	

	private void myPost(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getMyPost(tmpMember, page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("작성한 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {
				System.out.println((i+1)+". "+ postList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				manageMyPost(tmpPost);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}

	private void manageMyPost(PostVO tmpPost) {
		postDetail(tmpPost);
		System.out.println("[뒤로가기(1) 수정(2) 삭제(3)] : ");
		System.out.print("입력 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1: break;
		case 2: break;
		case 3: break;
		default:
			throw new InputMismatchException();
		}
	}


	

	private void myReply(MemberVO tmpMember) {
		ArrayList<ReplyVO> myReplyList = new ArrayList<ReplyVO>();
		int page = 1;
		int num = -3;
		while(true) {
			myReplyList = postService.getMyReply(tmpMember, page);
			if((myReplyList == null || myReplyList.size() == 0) && page == 1) {
				System.out.println("작성한 댓글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < myReplyList.size() ; i++) {
				System.out.println((i+1)+". "+ myReplyList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(myReplyList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(myReplyList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				ReplyVO tmpReply = myReplyList.get(num-1);
				manageMyReply(tmpReply);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}


	private void manageMyReply(ReplyVO tmpReply) {
		System.out.print("입력[뒤로가기(1) 수정(2) 삭제(3)] : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1: break;
		case 2: break;
		case 3: break;
		default:
			throw new InputMismatchException();
		}
	}


	public void boardMenu(MemberVO tmpMember) {
		int menu = 0;
		System.out.println("1.전체 게시글");
		System.out.println("2.게시판 보기");
		System.out.println("3.뒤로 가기");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runBoardMenu(menu, tmpMember);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
		
	}




	private void runBoardMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: allPost(tmpMember); break;
		case 2: allBoard(tmpMember); break;
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}


	private void allPost(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getAllPost(page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("작성한 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {
				System.out.println((i+1)+". "+ postList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}

	
	


	private void allBoard(MemberVO tmpMember) {
		int num = 0;
		ArrayList<BoardVO> boardList = printService.getBoard();
		for(int i = 0 ; i < boardList.size() ; i++) {
			System.out.println((i+1)+". "+ boardList.get(i));
		}
		System.out.print("게시판 입력 : ");
		num = scan.nextInt();
		if(num <= 0 || num > boardList.size()) {
			System.out.println("게시판을 잘못 선택했습니다. ");
			return;
		}
		BoardVO tmpBoard = boardList.get(num-1);
		selectedBoardMenu(tmpBoard,tmpMember);
	}

	private void selectedBoardMenu(BoardVO tmpBoard, MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -4;
		while(true) {
			postList = postService.getPostByBoard(tmpBoard,page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("해당 게시판에 등록된 게시글이 없습니다.");
			}
			else {
				for(int i = 0 ; i < postList.size() ; i++) {
					System.out.println((i+1)+". "+ postList.get(i));
				}
			}
			System.out.println("현재 페이지 : " + page);
			System.out.println("해당 게시판에 게시글 작성(-3)");
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				case -3: writePostInBoard(tmpBoard,tmpMember); return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}


	public void searchMenu(MemberVO tmpMember) {
		int menu = 0;
		System.out.println("1. 제목 검색");
		System.out.println("2. 작성자 검색");
		System.out.println("3. 일자 검색");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runSearchMenu(menu, tmpMember);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	
	
	private void runSearchMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: searchTitle(tmpMember); break;
		case 2: searchWriter(tmpMember); break;
		case 3: searchDate(tmpMember); break;
		default:
			throw new InputMismatchException();
		}
	}


	private void searchTitle(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		System.out.println("--제목 검색--");
		System.out.print("검색어(단어) : ");
		String keyword = scan.next();
		while(true) {
			postList = postService.getPostByTitle(keyword,page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("제목에 검색어가 포함된 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {
				System.out.println((i+1)+". "+ postList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}


	private void searchWriter(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		System.out.println("--작성자 검색--");
		System.out.print("검색어 : ");
		String keyword = scan.next();
		while(true) {
			postList = postService.getPostByWriter(keyword,page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("검색어가 포함된 작성자가 게시한 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {
				System.out.println((i+1)+". "+ postList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}


	private void searchDate(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		System.out.println("--일자 검색--");
		System.out.print("작성 연도 : ");
		String year = scan.next();
		System.out.print("월 : ");
		String month = scan.next();
		System.out.print("일 : ");
		String day = scan.next();
		while(true) {
			postList = postService.getPostByDate(year, month, day, page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("검색어가 포함된 작성자가 게시한 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {
				System.out.println((i+1)+". "+ postList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			if(postList.size() < 10 && page == 1) {
				System.out.println("상위메뉴(-2)");
			}else if(postList.size() < 10) {
				System.out.println("상위메뉴(-2) 이전페이지(-1)");
			}else if(page == 1) {
				System.out.println("상위메뉴(-2) 다음페이지(0)");
			}else {
				System.out.println("상위메뉴(-2) 이전페이지(-1) 다음페이지(0)");
			}
			System.out.print("입력 : ");
			num = scan.nextInt();				
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1);
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}


	// 게시글 상세조회
	private void postDetail(PostVO tmpPost) {
		// 조회수 증가 후 동일한 게시글 재호출
		PostVO post = postService.increaseVeiwCount(tmpPost);
		if(post == null) {
			System.out.println("상세조회 실패");
			return;
		}
		System.out.println(post.getPo_title());
		System.out.println(post.getPo_mb_id() + "  " + post.getPo_date() + " 조회수 : " 
							+ post.getPo_viewCount());
		System.out.println(post.getPo_content());
	}
	
	private void viewPost(PostVO tmpPost, MemberVO tmpMember) {
		int menu = 0;
		postDetail(tmpPost);
		System.out.print("입력[뒤로가기(1) 댓글(2)] : ");
		menu = scan.nextInt();
		switch(menu) {
		case 1: break;
		case 2: replyMenu(tmpPost, tmpMember); break;
		default:
			throw new InputMismatchException();
		}
	}

	private void replyMenu(PostVO tmpPost, MemberVO tmpMember) {
		int menu = 0;
		int page = 1;
		String btn = "";
		while(true) {
			ArrayList<ReplyVO> replyList = postService.getPostReply(tmpPost, page);
			if((replyList.size() == 0 || replyList == null) && page == 1) {
				System.out.println("아직 등록된 댓글이 없습니다.");
			}
			else if(replyList.size() < 10 && page == 1) {
				btn = "";
			}
			else if(page == 1) {
				btn = " 다음페이지(3)";
			}
			else if(replyList.size() < 10) {
				btn = " 이전페이지(2)";
			}
			else {
				btn = " 이전페이지(2)  다음페이지(3)";
			}
			
			for(ReplyVO tmp : replyList) {
				System.out.println(tmp);
			}
			System.out.println("현재 페이지 : " + page);
			System.out.println("[뒤로가기(0) 댓글작성(1)"+ btn +"]");
			System.out.print("입력 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 0: return;
			case 1: writeReply(tmpPost, tmpMember); return;
			case 2: page--; break;
			case 3: page++; break;
			default:
				throw new InputMismatchException();
			}
			if(page < 1) {
				page = 1;
			}
		}
	}

	private void writeReply(PostVO tmpPost, MemberVO tmpMember) {
		System.out.println("댓글 작성");
		System.out.print("내용 : ");
		String content = scan.nextLine();
		if(content == null || content.length() ==0) {
			System.out.println("내용이 있어야 댓글에 등록됩니다.");
		}
		if(postService.writeReply(content, tmpMember, tmpPost)) {
			System.out.println("댓글이 등록되었습니다.");
			return;
		}
		System.out.println("댓글 등록에 실패했습니다.");
	}

}
