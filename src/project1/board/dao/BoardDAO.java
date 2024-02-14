package project1.board.dao;

import org.apache.ibatis.annotations.Param;

public interface BoardDAO {

	boolean insertBoardType(@Param("boardType")String boardType);

}
