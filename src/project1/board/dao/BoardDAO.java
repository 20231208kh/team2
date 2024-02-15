package project1.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardDAO {

	boolean insertBoardType(@Param("boardCategoryVO")BoardCategoryVO boardCategoryVO);
	boolean updateBoardCategory(@Param("boardCategoryVO") BoardCategoryVO uBoardCategoryVo);
	ArrayList<BoardCategoryVO> selectBoardCategory();

	boolean insertBoard(@Param("boardVO")BoardVO boardVo);
	boolean updateBoard(@Param("boardVO")BoardVO uBoardVo);
	ArrayList<BoardVO> selectBoard();

	boolean insertPostCategory(@Param("postCategoryVO")PostCategoryVO postCategoryVo);
	boolean updatePostCategory(@Param("postCategoryVO")PostCategoryVO uPostCategoryVo);
	ArrayList<PostCategoryVO> selectPostCategory();

}
