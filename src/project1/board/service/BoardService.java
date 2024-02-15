package project1.board.service;

import java.util.ArrayList;
import java.util.List;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardService {

	boolean insertBoardCategory(BoardCategoryVO boardCategoryVO);

	ArrayList<BoardCategoryVO> getBoardCategory();

	boolean insertBoard(BoardVO boardVo);

	ArrayList<BoardVO> getBoard();

	boolean insertPostCategory(PostCategoryVO postCategoryVo);
	
	ArrayList<PostCategoryVO> getPostCategory();

	boolean updateBoardCategory(BoardCategoryVO uBoardCategoryVo);

	boolean updateBoard(BoardVO uBoardVo);

	boolean updatePostCategory(PostCategoryVO uPostCategoryVo);

	
}
