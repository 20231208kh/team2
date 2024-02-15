package project1.board.service;

import java.util.List;

import project1.board.model.vo.PostVO;

public interface PostService {

	boolean write(PostVO postVo);

	List<PostVO> getPostList();

}
