package project1.board.service;

import project1.board.controller.MemberController;

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
	void myCommunityUsed(); //게시글 관리
	
	void printPostCategory();
	void printBoardCategory();
	void printBoard();
	

}
