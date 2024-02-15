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
}
