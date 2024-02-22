package project1.board.service;

import java.util.ArrayList;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;

public interface PrintService {

	void startMenu();
	void mainMenu();
	void manageMemberMenu();
	void manageBoardMenu();
	void postMenu();
	void managePostCategory();
	void loggedinUserMenu();
	void loggedinAdminMenu();
	void updateMyInfo();

	void manageBoardCategory();
	void manageBoard();


	
  
  
	void myCommunityUsed(); //게시글 관리
	void printPostCategory();
	void printBoardCategory();
	void printBoard();

	void manageMyPostUpdateMenu();
	
	void adminChoosePostMenu(); //관리자가 일반 게시판을 쓸 지 아니면 공지사항을 쓸지 고르는 메뉴
	
	
	void postDetail(PostVO tmpPost);
	void printPostList(ArrayList<PostVO> postList);
	void printBoardList(ArrayList<BoardVO> boardList);
	void myPostDetail(PostVO tmpPost);
	void printReply(ArrayList<ReplyVO> replyList);
<<<<<<< HEAD
	
	ArrayList<PostCategoryVO> getpostList();
	ArrayList<BoardVO> getBoard();	//게시판 가져오기
	
	//게시판을 선택한 후 말머리글을 가져오기 위한 함수
=======
	ArrayList<PostCategoryVO> getPC(int num);
>>>>>>> c0a82aa11cdf35c37c798373516aca66f2be1517




}