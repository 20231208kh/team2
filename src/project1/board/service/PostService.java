package project1.board.service;


import java.util.ArrayList;

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

}
