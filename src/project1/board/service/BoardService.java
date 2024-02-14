package project1.board.service;

import java.util.ArrayList;
import java.util.List;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardService {

	boolean insertBoardType(BoardCategoryVO boardCategoryVO);

	ArrayList<BoardCategoryVO> getBoardType();

	boolean insertBoard(BoardVO boardVo);

	ArrayList<BoardVO> getBoard();

	boolean insertPostCategory(PostCategoryVO postCategoryVo);

}
