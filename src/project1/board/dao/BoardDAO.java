package project1.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardDAO {

	boolean insertBoardType(@Param("boardCategoryVO")BoardCategoryVO boardCategoryVO);

	ArrayList<BoardCategoryVO> selectBoardCategory();

	boolean insertBoard(@Param("boardVO")BoardVO boardVo);

	ArrayList<BoardVO> selectBoard();

	boolean insertPostCategory(@Param("postCategoryVO")PostCategoryVO postCategoryVo);

}
