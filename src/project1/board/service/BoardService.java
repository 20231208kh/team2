package project1.board.service;

import java.util.ArrayList;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardService {

	boolean insertBoardCategory(BoardCategoryVO boardCategoryVO);
	boolean updateBoardCategory(BoardCategoryVO uBoardCategoryVo);
	boolean deleteBoardCategory(BoardCategoryVO dBoardCategoryVo);
	ArrayList<BoardCategoryVO> getBoardCategory();

	boolean insertBoard(BoardVO boardVo);
	boolean updateBoard(BoardVO uBoardVo);
	boolean deleteBoard(BoardVO dBoardVo);


	boolean insertPostCategory(PostCategoryVO postCategoryVo);
	boolean updatePostCategory(PostCategoryVO uPostCategoryVo);
	boolean deletePostCategory(PostCategoryVO dPostCategoryVo);
	ArrayList<PostCategoryVO> getPostCategory();
	
	void printBoardCategory();
	void printBoard();
	void printPostCategory();
	
	ArrayList<BoardVO> getBoard();	//전체 게시판에 대한 정보를 가져오는 함수

	
	void printAdminPostCategory();	//공지사항 게시글 카테고리s



}

