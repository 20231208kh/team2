package project1.board.service;

import java.util.ArrayList;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;

public interface PrintService {

	void startMenu();
	void manageMemberMenu();
	void manageBoardMenu();
	void managePostCategory();
	void loggedinUserMenu();
	void loggedinAdminMenu();
	void updateMyInfo();

	void manageBoardCategory();
	void manageBoard();


	ArrayList<BoardVO> getBoard();
  
  
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
	ArrayList<PostCategoryVO> getPostCategoryByBoard(BoardVO tmpBoard);
	void printPostCategoryList(ArrayList<PostCategoryVO> pCList);




}
