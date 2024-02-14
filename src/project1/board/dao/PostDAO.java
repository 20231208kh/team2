package project1.board.dao;

import java.util.ArrayList;

import project1.board.model.vo.PostVO;

public interface PostDAO {
	ArrayList<PostVO> selectPostList();
}
