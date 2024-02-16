package project1.board.dao;



import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;


import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;

public interface PostDAO {	
	void increaseVeiwCount(@Param("post")PostVO tmpPost);

	List<PostVO> getPost(@Param("post")PostVO tmpPost);

	ArrayList<PostVO> getMyPost(@Param("member")MemberVO memberVo, @Param("page")int page);

	ArrayList<ReplyVO> getMyReply(@Param("member")MemberVO memberVo, @Param("page")int page);

	ArrayList<PostVO> getAllPost(@Param("page")int page);

	void insertReply(@Param("content")String content, @Param("member")MemberVO tmpMember, @Param("post")PostVO tmpPost);

	ArrayList<ReplyVO> getPostReply(@Param("post")PostVO tmpPost, @Param("page")int page);

	ArrayList<PostVO> getPostByTitle(@Param("keyword")String keyword, @Param("page")int page);

	ArrayList<PostVO> getPostByWriter(@Param("keyword")String keyword, @Param("page")int page);

	ArrayList<PostVO> getPostByDate(@Param("year")String year, @Param("month")String month, @Param("day")String day, @Param("page")int page);

	ArrayList<PostVO> getPostByBoard(@Param("board")BoardVO tmpBoard, @Param("page")int page);

	void deleteReply(@Param("reply")ReplyVO tmpReply);

	boolean updateReply(@Param("reply")ReplyVO tmpReply, @Param("content")String content);
	


	boolean writePost(@Param("postVo")PostVO postVo);

	List<PostVO> selectPostList();

	boolean updatePost(@Param("postVo")PostVO tmpPost);

	

	

	




}
