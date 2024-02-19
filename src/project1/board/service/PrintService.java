package project1.board.service;

import java.util.ArrayList;

import project1.board.model.vo.BoardVO;

public interface PrintService {

	void startMenu();
	void mainMenu();
	void manageMemberMenu();
	void manageBoardMenu();
	void postMenu();
	void managePostCategory();
	void manageBoardCategory();
	void updateBoard();
	void loggedinUserMenu();
	void loggedinAdminMenu();
	void updateMyInfo();

	ArrayList<BoardVO> getBoard();
  
  
	void myCommunityUsed(); //게시글 관리
	void printPostCategory();
	void printBoardCategory();
	void printBoard();
	void manageMyPostUpdateMenu();
	
	void adminChoosePostMenu(); //관리자가 일반 게시판을 쓸 지 아니면 공지사항을 쓸지 고르는 메뉴
	
	


}
