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
	void myCoummunityUsedUpdateMenu();



}
