package project1.board.service;

import java.util.List;

import project1.board.model.vo.PostVO;

public interface PostService {

	boolean write(PostVO postVo);

	List<PostVO> getPostList(); //게시글 가져오기

	List<PostVO> getPo_Title(int po_num);	//제목 수정을 위함

}
