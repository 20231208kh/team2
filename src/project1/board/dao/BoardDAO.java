package project1.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

public interface BoardDAO {

	boolean insertBoardType(@Param("boardCategoryVO")BoardCategoryVO boardCategoryVO);
	boolean updateBoardCategory(@Param("boardCategoryVO")BoardCategoryVO uBoardCategoryVo);
	boolean deleteBoardCategory(@Param("boardCategoryVO")BoardCategoryVO dBoardCategoryVo);
	ArrayList<BoardCategoryVO> selectBoardCategory();

	boolean insertBoard(@Param("boardVO")BoardVO boardVo);
	boolean updateBoard(@Param("boardVO")BoardVO uBoardVo);
	boolean deleteBoard(@Param("boardVO")BoardVO dBoardVo);
	ArrayList<BoardVO> selectBoard();

	boolean insertPostCategory(@Param("postCategoryVO")PostCategoryVO postCategoryVo);
	boolean updatePostCategory(@Param("postCategoryVO")PostCategoryVO uPostCategoryVo);
	boolean deletePostCategory(@Param("postCategoryVO")PostCategoryVO dPostCategoryVo);
	ArrayList<PostCategoryVO> selectPostCategory();

}