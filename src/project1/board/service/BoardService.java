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
	ArrayList<BoardVO> getBoard();

	boolean insertPostCategory(PostCategoryVO postCategoryVo);
	boolean updatePostCategory(PostCategoryVO uPostCategoryVo);
	boolean deletePostCategory(PostCategoryVO dPostCategoryVo);
	ArrayList<PostCategoryVO> getPostCategory();
	
	void printBoardCategory();
	void printBoard();
	void printPostCategory();

}

