package project1.board.controller;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
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

	private Scanner scan = new Scanner(System.in);
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


	
	//나의 게시글
	private void myPost(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();	//postVO 리스트 정의,내가 작성한 게시글
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getMyPost(tmpMember, page);	//몇행부터 10개 출력할지 가져온 것 select문
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("작성한 게시글이 없습니다.");
				return;
			}
			for(int i = 0 ; i < postList.size() ; i++) {	//postList에는 10개가 있을거 같음
				System.out.println((i+1)+". "+ postList.get(i));	//1번 postList 0번지 객체 ~ 10번 postList 9번지 객체
			}
			System.out.println("현재 페이지 : " + page);  // 77~ 86번줄 의미를 모르겠음
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
				PostVO tmpPost = postList.get(num-1); //인덱스 번호0~9표현
				manageMyPost(tmpPost,num);	//내가 입력한 번호-1인덱스 번호를 넣은 PostVo 객체를 넘겨줌
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

	//게시글 수정 삭제메뉴
	private void manageMyPost(PostVO tmpPost,int num) {
		postDetail(tmpPost);		//상세 조회
		System.out.println("[뒤로가기(1) 수정(2) 삭제(3)] : ");
		System.out.print("입력 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1: 
			System.out.println("뒤로갑니다.");
			break;
		case 2: 
			updatePost(tmpPost);	//게시글 수정
			break;
		case 3: 
			deletePost(tmpPost,num);	//게시글 삭제
			break;
		default:
			throw new InputMismatchException();
		}
	}
		private void updatePost(PostVO tmpPost) {
			int menu;
		
			do{
				printService.manageMyPostUpdateMenu();
				menu = scan.nextInt();
				runmanageMyPostUpdateMenu(menu,tmpPost);
				
			}while(menu !=3);
			
		}

		private void runmanageMyPostUpdateMenu(int menu,PostVO tmpPost) {
			switch(menu) {
			case 1:
				updatePostPoTitle(tmpPost);	//게시글 제목 수정
				break;
			case 2:
				updatePostPoContent(tmpPost); //게시글 내용 수정
				break;
			case 3:
				System.out.println("이전으로 돌아갑니다.");
				break;
			default:
				throw new InputMismatchException();
			}
		}
		
		//게시글 제목 수정
		private void updatePostPoTitle(PostVO tmpPost) {
			//제목을 수정하기 위해 뭐부터 보여줘야 되는가?
			//->게시글 리스트를 보여주고
			
			postDetail(tmpPost);
			tmpPost.getPo_title(); //현재 제목.
			System.out.println("수정할 제목을 입력하세요.");
			String po_title=scan.next();
			tmpPost.setPo_title(po_title);
			
			if(!postService.setPost(tmpPost)){ 	
				System.out.println("잘못 입력됐습니다.");
				return;
			}
			
			
		}
		
		//게시글 내용 수정
		private void updatePostPoContent(PostVO tmpPost) {
			postDetail(tmpPost);
			tmpPost.getPo_content();
			System.out.println("수정할 내용을 입력하세요.");
			String po_content=scan.nextLine();
			tmpPost.setPo_content(po_content);
			
			if(!postService.setPost(tmpPost)){	
				System.out.println("잘못 입력됐습니다.");
				return;
			}
			
		}
		 //게시글 삭제
		private void deletePost(PostVO tmpPost,int num) {
			postDetail(tmpPost);
			System.out.println("이 게시글을 정말 삭제하시겠습니까? (삭제:1,삭제취소:0 을 누르세요)");
			int menuselect=scan.nextInt();
			if(postService.deletePost(num) && menuselect==1) {
				System.out.println("게시글 삭제에 성공했습니다.");
			}else {
				System.out.println("게시글 삭제에 실패했습니다.");
			}
			
			//예외처리1 기본키-게시글 번호가 일치하지 않는지 확인->일단 후순위
		}

	
	
	//나의 댓글
	private void myReply(MemberVO tmpMember) {
		ArrayList<ReplyVO> myReplyList = new ArrayList<ReplyVO>();	//게시글 클래스 리스트 정의 myReplyList
		int page = 1;
		int num = -3;
		while(true) {
			myReplyList = postService.getMyReply(tmpMember, page);	//myreplyList에 내가 해당 아이디를 가지는 사람을 기준으로 댓글을 모두 가져옴
			
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
			
			if(num > 0 && num < 11) {	//
				ReplyVO tmpReply = myReplyList.get(num-1);
				manageMyReply(tmpReply);		
				return;					//이거는 작동이 어떻게 되는지 궁굼합니다.
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
		case 2: updateMyReply(tmpReply); break;
		case 3: isDeleteReply(tmpReply); break;
		default:
			throw new InputMismatchException();
		}
	}

	private void updateMyReply(ReplyVO tmpReply) {
		scan.nextLine();
		System.out.println("수정할 내용:");
		String content = scan.nextLine();
		content = "[수정됨] " + content;	//content를 수정한 후에 content 수정된 내용을 다시 넣어줌
		if(postService.updateReply(tmpReply,content)) {
			System.out.println("수정 성공");
			return;
		}
		System.out.println("수정 실패");
	}

	//사용자
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

	//사용자
	private void runBoardMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: allPost(tmpMember); break;
		case 2: allBoard(tmpMember); break;
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//관리자
	public void boardAdminMenu(MemberVO tmpMember) {
		int menu = 0;
		System.out.println("1.전체 게시글");
		System.out.println("2.게시판 보기");
		System.out.println("3.뒤로 가기");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runBoardAdminMenu(menu, tmpMember);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
		
	}

	
	//관리자
	private void runBoardAdminMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: allPostAdmin(tmpMember); break;
		case 2: allBoardAdmin(tmpMember); break;
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//사용자
	private void allPost(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getAllPost(page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("작성된 게시글이 없습니다.");
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
	
	//관리자
	private void allPostAdmin(MemberVO tmpMember) {
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getAllPost(page);
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("작성된 게시글이 없습니다.");
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
				viewPostAdmin(tmpPost , tmpMember);
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
	
	
	//사용자
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
		selectedBoardMenu(tmpBoard,tmpMember);		//게시판 하나를 특정해서 가져온 것
	}
	
	//관리자
	private void allBoardAdmin(MemberVO tmpMember) {
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
		selectedBoardAdminMenu(tmpBoard,tmpMember);
	}
	
	//게시글 작성
	public boolean writePost(MemberVO member) {
		
		System.out.println("게시글 작성을 시작합니다.");
		printService.printPostCategory();
		System.out.print("게시글 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		
		scan.nextLine();
		System.out.print("게시글 제목을 입력하세요.");
		String po_title=scan.nextLine();
		System.out.print("게시글 내용을 입력하세요.");
		String po_content=scan.nextLine();

		PostVO postVo = new PostVO(po_title,po_content,member.getMb_id(),po_pc_num);
		
		if(postService.writePost(postVo)) {	
			System.out.println("게시글 추가 성공!");
			
			return true;
		}
			System.out.println("게시글 추가 실패!");
			return false;
	}
	
	// 사용자
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
				System.out.println("현재 페이지 : " + page);
			}
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
				case -3: 
					//일반 사용자가 게시판을 특정한 뒤 게시글 작성
				writePostInBoard(tmpBoard,tmpMember); 
				
				return;	//게시글 말머리와 게시글을 조인한 것을 가져옴
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}
	

	public void writePostAdminMenu(MemberVO memberVo) {
		
	int menu;
	do {
	printService.adminChoosePostMenu();
	menu=scan.nextInt();
	adminChoosePostMenu(menu,memberVo);
	}while(menu!=4);
	}


		//관리자 게시글,공지사항 작성, 게시글 관리 메뉴
	private void adminChoosePostMenu(int menu,MemberVO tmpMember) {
	
		switch(menu) {
		case 1:
			//공지사항 작성
			 writeAnnouncementtInBoard(tmpMember);
			break;
		case 2:
			//게시글 작성
			 writePostInBoard(tmpMember);
			break;
		case 3:
			// 게시글 관리
			break;
		case 4:
			System.out.println("돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	
	//공지사항을 작성
	private boolean writeAnnouncementtInBoard(MemberVO tmpMember) {
		
		System.out.println("공지사항 작성을 시작합니다.");
		int po_notice=1; 	//공지사항 작성 번호 1번 게시글은 0번으로 기본값임
		printService.printPostCategory();
		System.out.print("공지사항 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		scan.nextLine();
		System.out.print("공지사항 제목을 입력하세요.");
		String po_title=scan.nextLine();
		System.out.print("공지사항 내용을 입력하세요.");
		String po_content=scan.nextLine();

		PostVO postVo = new PostVO(po_title,po_content,tmpMember.getMb_id(),po_pc_num,po_notice);
		
		if(postService.writeAnnoucement(postVo)) {	
			System.out.println("공지사항 추가 성공!");
			return true;
		}
			System.out.println("공지사항 추가 실패!");
			return false;
		
	}


	//게시글을 작성
	private void writePostInBoard(MemberVO tmpMember) {
		writePost(tmpMember);
	}
	
	// 관리자
	private void selectedBoardAdminMenu(BoardVO tmpBoard, MemberVO tmpMember) {
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
				System.out.println("현재 페이지 : " + page);
			}
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
				viewPostAdmin(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				case -3: 
					//관리자가 게시판을 특정한 뒤 게시글 작성
				writePostInBoard(tmpBoard,tmpMember); return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}
	
	//사용자
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
	
	//관리자
	public void searchAdminMenu(MemberVO tmpMember) {
		int menu = 0;
		System.out.println("1. 제목 검색");
		System.out.println("2. 작성자 검색");
		System.out.println("3. 일자 검색");
		System.out.print("입력 : ");
		try {
			menu = scan.nextInt();
			runSearchAdminMenu(menu, tmpMember);
		}
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	//사용자
	private void runSearchMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: searchTitle(tmpMember); break;
		case 2: searchWriter(tmpMember); break;
		case 3: searchDate(tmpMember); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	private void runSearchAdminMenu(int menu, MemberVO tmpMember) {
		switch(menu) {
		case 1: searchTitleAdmin(tmpMember); break;
		case 2: searchWriterAdmin(tmpMember); break;
		case 3: searchDateAdmin(tmpMember); break;
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

	private void searchTitleAdmin(MemberVO tmpMember) {
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
				viewPostAdmin(tmpPost , tmpMember);
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

	private void searchWriterAdmin(MemberVO tmpMember) {
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
				viewPostAdmin(tmpPost , tmpMember);
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

	private void searchDateAdmin(MemberVO tmpMember) {
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
				viewPostAdmin(tmpPost , tmpMember);
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
		System.out.println("["+post.getPo_pc_title()+"]"+post.getPo_title());
		System.out.println(post.getPo_mb_id() + "  " + post.getPo_date() + " 조회수 : " 
							+ post.getPo_viewCount());
		System.out.println(post.getPo_content());		// [말머리] 제목
														// 아이디 날짜 조회수 : 조회한수
														// 내용
	}
	
	//사용자
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
	
	//관리자
	private void viewPostAdmin(PostVO tmpPost, MemberVO tmpMember) {
		int menu = 0;
		postDetail(tmpPost);
		System.out.print("입력[뒤로가기(1) 댓글(2) 게시글 삭제(3)] : ");
		menu = scan.nextInt();
		switch(menu) {
		case 1: break;
		case 2: replyAdminMenu(tmpPost, tmpMember); break;
		case 3: break;
		default:
			throw new InputMismatchException();
		}
	}
	
	
	//사용자
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
	
	//관리자
	private void replyAdminMenu(PostVO tmpPost, MemberVO tmpMember) {
		int menu = -4;
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
				btn = " 다음페이지(0)";
			}
			else if(replyList.size() < 10) {
				btn = " 이전페이지(-1)";
			}
			else {
				btn = " 이전페이지(-1)  다음페이지(0)";
			}
			
			for(int i = 0 ; i < replyList.size(); i++) {
				System.out.println((i+1)+". "+ replyList.get(i));
			}
			System.out.println("현재 페이지 : " + page);
			System.out.println("[뒤로가기(-3) 댓글작성(-2)"+ btn +"]");
			System.out.print("입력(삭제할 댓글 혹은 메뉴) : ");
			menu = scan.nextInt();
			if( menu < 11 && menu > 0) {
				ReplyVO tmpReply = replyList.get(menu-1);
				isDeleteReply(tmpReply);
				return;
			}
			switch(menu) {
			case -3: return;
			case -2: writeReply(tmpPost, tmpMember); return;
			case -1: page--; break;
			case 0: page++; break;
			default:
				throw new InputMismatchException();
			}
			if(page < 1) {
				page = 1;
			}
		}
	}
	

	private void isDeleteReply(ReplyVO tmpReply) {
		System.out.println(tmpReply);
		System.out.println("해당 댓글을 삭제하겠습니까?");
		System.out.print("입력[삭제취소(0) 삭제(1)]:");
		int menu = scan.nextInt();
		switch(menu) {
		case 0: break;
		case 1: postService.deleteReply(tmpReply); break;
		default:
			throw new InputMismatchException();
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
