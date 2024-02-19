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
	
	public void myPageMenu(MemberVO tmpMember) {	//일반회원 마이페이지 메뉴
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
		ArrayList<PostVO> postList = new ArrayList<PostVO>();	//postVO 리스트 정의-> 데이터베이스에서 가져올 정보를 담기 위함
		int page = 1;
		int num = -3;
		while(true) {
			postList = postService.getMyPost(tmpMember, page);	//몇행부터 10개 출력할지 가져온 것 select문
			if((postList == null || postList.size() == 0) && page == 1) { 	//데이터베스에서 가져온 게시글이 비어있고 페이지가 1페이지면
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
			num = scan.nextInt();	//가져올 
			
			if(num > 0 && num < 11) {
				PostVO tmpPost = postList.get(num-1); //인덱스 번호0~9표현
				manageMyPost(tmpPost,num);	//내가 입력한 번호-1인덱스 번호를 넣은 PostVo 객체를 넘겨줌
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;	//0번을 누르면 페이지 증가 
				case -1: page--; break;	//1번을 누르면 페이지 감소
				case -2: return;
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {	//페이지가 -로 내려갔을 시 페이지가 1이 되게끔 작동이 안 될 것을 우려해서 조건 걸어줌 
				page = 1;
			}
		}
	}

	//게시글 수정 삭제메뉴
	private void manageMyPost(PostVO tmpPost,int num) {	//
		postDetail(tmpPost);		//상세 조회
		System.out.println("[뒤로가기(1) 수정(2) 삭제(3)] : ");
		System.out.print("입력 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1: 
			System.out.println("뒤로갑니다.");
			break;
		case 2: 
			updatePostMenu(tmpPost);	//게시글 수정 메뉴
			break;
		case 3: 
			deletePost(tmpPost,num);	//게시글 삭제
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
//게시글 수정 삭제 구현 시작
		private void updatePostMenu(PostVO tmpPost) {	//게시글 수정 메뉴
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
//게시글 수정 삭제 끝
	
	
	//나의 댓글
	private void myReply(MemberVO tmpMember) {
		ArrayList<ReplyVO> myReplyList = new ArrayList<ReplyVO>();	//게시글 클래스 리스트 정의 myReplyList
		int page = 1;
		int num = -3;
		while(true) {
			myReplyList = postService.getMyReply(tmpMember, page);	//myreplyList에 넣어줌 <-댓글(main에서 로그인을 성공한 사람의 아이디와 같은 댓글을 가져옴)
			
			if((myReplyList == null || myReplyList.size() == 0) && page == 1) {	 	//댓글 예외처리 (게시글과 같음)
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
			num = scan.nextInt();	//댓글 번호 입력
			
			if(num > 0 && num < 11) {	//1번부터 10번 페이지를 10개 행으로 제한해둬서
				ReplyVO tmpReply = myReplyList.get(num-1);	//댓글 하나를 선택해서 tmpReply에 넣어줌
				manageMyReply(tmpReply);	//해당 댓글 수정 삭제
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


	private void manageMyReply(ReplyVO tmpReply) {	//위에 해당 댓글 수정 삭제 메뉴 구현
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

	private void updateMyReply(ReplyVO tmpReply) {	//댓글 수정
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
	public void boardMenu(MemberVO tmpMember) {	//main131번줄 게시판 조회 메뉴 구현
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
		case 1: allPost(tmpMember); break;	//모든 게시글
		case 2: allBoard(tmpMember); break; //모든 게시판
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//사용자,모든 게시글 구현
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
		case 1: allPostAdmin(tmpMember); break;		//전체 게시글
		case 2: allBoardAdmin(tmpMember); break;	//게시판 보기
		case 3: System.out.println("뒤로가기"); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	
	
	//관리자, 전체 게시글 
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
	
	// 사용자
	private void selectedBoardMenu(BoardVO tmpBoard, MemberVO tmpMember) {	// 게시판을 선택한 것과,회원의 정보를 들고 있음
		ArrayList<PostVO> postList = new ArrayList<PostVO>();	//게시글 리스트 선언
		int page = 1;
		int num = -4;
		
		while(true) {
			postList = postService.getPostByBoard(tmpBoard,page);	//게시글 전체와 게시글 말머리 제목을 가져옴 
			if((postList == null || postList.size() == 0) && page == 1) {
				System.out.println("해당 게시판에 등록된 게시글이 없습니다.");
			}
			else {
				for(int i = 0 ; i < postList.size() ; i++) {	//게시글 크기만큼 게시글을 출력
					System.out.println((i+1)+". "+ postList.get(i));
				}
				System.out.println("현재 페이지 : " + page);
			}
			System.out.println("해당 게시판에 게시글 작성(-3)");
			if(postList.size() < 10 && page == 1) {	//페이지 크기
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
				PostVO tmpPost = postList.get(num-1);  //게시글 하나 선택해서 tmpPost에 저장
				viewPost(tmpPost , tmpMember);
				return;
			}
			else {
				switch(num) {
				case 0: page++; break;
				case -1: page--; break;
				case -2: return;
				case -3: 
				userWritePostInSelectedBoard(tmpBoard,tmpMember); 	//일반 사용자가 게시판을 특정한 뒤 게시글 작성
				
				return;	//게시글 말머리와 게시글을 조인한 것을 가져옴
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {	//page가 0보다 작을 경우 예외처리로 페이지를 1로 바꿔줌+
				
				page = 1;
			}
		}
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
		BoardVO tmpBoard = boardList.get(num-1);	//게시판 1개를 선택했음
		selectedBoardAdminMenu(tmpBoard,tmpMember);
	}
	

	//게시글 작성
	private void userWritePostInSelectedBoard(BoardVO tmpBoard, MemberVO tmpMember) {	
		
		int po_notice=0;
		printService.printPostCategory();
		System.out.print("게시글 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		
		scan.nextLine();
		System.out.print("게시글 제목을 입력하세요.");
		String po_title=scan.nextLine();
		System.out.print("게시글 내용을 입력하세요.");
		String po_content=scan.nextLine();

		PostVO postVo = new PostVO(po_title,po_content,tmpMember.getMb_id(),po_pc_num,po_notice);
		
		if(postService.writePost(postVo)) {	
			System.out.println("게시글 추가 성공!");
			return;
		}
			System.out.println("게시글 추가 실패!");
		
	}
	
	//main 게시글 작성 또는 공지 작성
	public void writePostAdminMenu(MemberVO memberVo) {

		if(!memberVo.getMb_right().equals("ADMIN")) {
			return;
		}
		int menu;
		menu=scan.nextInt();
		printService.adminChoosePostMenu();
		switch(menu) {
		case 1:	//공지사항 작성
			writeAnnouncementInMain(memberVo);
			break;
		case 2:	//게시글 작성
			writePostInMain(memberVo);
				break;
		case 3:
			System.out.println("돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
}
	//관리자가 게시글을 작성
		public void writePostInMain(MemberVO memberVo) {
			//게시판 선택
			//공지 게시판은 1번으로 설정
			//나머지 게시판은 2~ 끝 게시판
			
			int po_notice=0;
			
			System.out.println("게시판을 선택해주세요.");
			System.out.println(printService.getBoard());
			int po_bo_num=scan.nextInt();
			
			
			while(po_bo_num == 1) {
				System.out.println("공지사항 게시판 선택함");
				System.out.println("공지사항 작성할거임?");
				System.out.println("1. O");
				System.out.println("2. X(일반게시글 작성");
				int menu = scan.nextInt();
				if (menu ==1) {
					writeAnnouncementInMain(memberVo);
					return;
				}else if(menu==2) {
					System.out.println("새로운 게시판 번호");
					po_bo_num = scan.nextInt();
				}else {
					System.out.println("잘못된 입력");
					break;
				}
			}
			printService.printPostCategory();
			System.out.print("게시글 말머리 번호를 입력하세요.");
			int po_pc_num=scan.nextInt();
			
			scan.nextLine();
			
			
			
			System.out.print("게시글 제목을 입력하세요.");
			String po_title=scan.nextLine();
			
			System.out.print("게시글 내용을 입력하세요.");
			String po_content=scan.nextLine();
			
			
			PostVO postVo = new PostVO(po_title,po_content, po_notice,memberVo.getMb_id(),po_bo_num,po_pc_num);
			
			if(postService.writePostMain(postVo)) {	
				System.out.println("게시글 추가 성공!");
				return;
			}
				System.out.println("게시글 추가 실패!");
			
			
			
			//아래 똑같음
			
		}
	
	
	
	//관리자 공지사항 작성
	private void writeAnnouncementInMain(MemberVO memberVo) {	//관리자 공지사항 작성 2번 선택시
		
		if(!memberVo.getMb_right().equals("ADMIN") || memberVo==null  ) {
			return;
		}
		
		System.out.println("공지사항 작성을 시작합니다.");
		
		int po_bo_num=1; 	//1번을 공지사항 게시판으로 넣어서
		int po_notice=1;
		
		printService.printPostCategory();
		System.out.print("공지사항 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		
		scan.nextLine();
		System.out.print("공지사항 제목을 입력하세요.");
		String po_title=scan.nextLine();
		System.out.print("공지사항 내용을 입력하세요.");
		String po_content=scan.nextLine();

		PostVO postVo = new PostVO(po_title,po_content, po_notice,memberVo.getMb_id(),po_bo_num,po_pc_num);
		
		if(postService.writePostMain(postVo)) {	
			System.out.println("공지사항 추가 성공!");
			return;
		}
			System.out.println("공지사항 추가 실패!");
		
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
				writePost(tmpBoard,tmpMember); return;		//여기서 공지사항과 게시글을 선택하게 만들어야 됨
				default:
					throw new InputMismatchException();
				}
			}
			if(page<1) {
				page = 1;
			}
		}
	}
	
	//관리자 게시글 작성
	private void writePost(BoardVO tmpBoard, MemberVO tmpMember) {	
		
		
		int po_notice=0;
		
		System.out.println("게시글 작성을 시작합니다.");
		printService.printPostCategory();
		System.out.print("게시글 말머리 번호를 입력하세요.");
		int po_pc_num=scan.nextInt();
		
		scan.nextLine();
		System.out.print("게시글 제목을 입력하세요.");
		String po_title=scan.nextLine();
		System.out.print("게시글 내용을 입력하세요.");
		String po_content=scan.nextLine();

		PostVO postVo = new PostVO(po_title,po_content,tmpMember.getMb_id(),po_pc_num,po_notice);
		
		if(postService.writePostMain(postVo)) {	
			System.out.println("게시글 추가 성공!");
			return;
		}
			System.out.println("게시글 추가 실패!");
			
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
		case 3: deletePost(tmpPost); break;	//박석훈 해야될 것 게시글 삭제
		default:
			throw new InputMismatchException();
		}
	}
	
	
	private void deletePost(PostVO tmpPost) {
		postDetail(tmpPost);
		System.out.println("이 게시글을 정말 삭제하시겠습니까? (삭제:1,삭제취소:0 을 누르세요)");
		int menuselect=scan.nextInt();
		if(postService.deletePost(tmpPost.getPo_num()) && menuselect==1) {
			System.out.println("게시글 삭제에 성공했습니다.");
		}else {
			System.out.println("게시글 삭제에 실패했습니다.");
		}
		
		//예외처리1 기본키-게시글 번호가 일치하지 않는지 확인->일단 후순위
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
