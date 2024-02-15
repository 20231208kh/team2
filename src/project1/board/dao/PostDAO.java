package project1.board.dao;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.PostVO;

public interface PostDAO {

	boolean writePost(@Param("postVo")PostVO postVo);



	



}
