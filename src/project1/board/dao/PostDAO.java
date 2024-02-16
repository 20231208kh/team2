package project1.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.PostVO;

public interface PostDAO {

	boolean writePost(@Param("postVo")PostVO postVo);

	List<PostVO> selectPostList();

	List<PostVO> setPo_Title(int po_num);

	

	

	



}
