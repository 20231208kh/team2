package project1.board.service;



import java.util.ArrayList;
import java.util.List;

import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostCategoryVO;
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

	boolean writePost(PostVO postVo);	//게시글 작성

	boolean writePostMain(PostVO postVo); //main에서 가져온거 작성
	
	ArrayList<PostCategoryVO> getPostList(); //게시글 가져오기

	boolean setPost(PostVO tmpPost); //제목 수정

	boolean deletePost(int po_num);	//게시글 삭제

<<<<<<< HEAD
	ArrayList<PostCategoryVO> getAllPostCategory(BoardVO board);	







=======
	ArrayList<PostCategoryVO> getPC(int num);

	
>>>>>>> c0a82aa11cdf35c37c798373516aca66f2be1517


	



	



}
