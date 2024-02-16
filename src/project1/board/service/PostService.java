package project1.board.service;



import java.util.ArrayList;
import java.util.List;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;

public interface PostService {

	PostVO increaseVeiwCount(PostVO tmpPost);

	ArrayList<PostVO> getMyPost(MemberVO memberVo, int page);

	ArrayList<ReplyVO> getMyReply(MemberVO memberVo, int page);

	ArrayList<PostVO> getAllPost(int page);

	boolean writeReply(String content, MemberVO tmpMember, PostVO tmpPost);

	ArrayList<ReplyVO> getPostReply(PostVO tmpPost, int page);

	ArrayList<PostVO> getPostByTitle(String keyword, int page);

	ArrayList<PostVO> getPostByWriter(String keyword, int page);

	ArrayList<PostVO> getPostByDate(String year, String month, String day, int page);

	ArrayList<PostVO> getPostByBoard(BoardVO tmpBoard, int page);

	void deleteReply(ReplyVO tmpReply);

	boolean updateReply(ReplyVO tmpReply, String content);

	boolean write(PostVO postVo);

	List<PostVO> getPostList(); //게시글 가져오기

	List<PostVO> getPo_Title(int po_num);	//제목 수정을 위함


}
