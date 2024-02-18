package project1.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project1.board.dao.PostDAO;


import project1.board.model.vo.BoardVO;
import project1.board.model.vo.MemberVO;
import project1.board.model.vo.PostVO;
import project1.board.model.vo.ReplyVO;


public class PostServiceImp implements PostService {
	private PostDAO postDAO;
	private InputStream inputStream;
	private SqlSession session;
	
	public PostServiceImp() {
		String resource = "project1/board/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDAO = session.getMapper(PostDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override


	public PostVO increaseVeiwCount(PostVO tmpPost) {
		postDAO.increaseVeiwCount(tmpPost);
		PostVO post = postDAO.getPost(tmpPost).get(0);	//무슨 뜻이에요 이거 .. 이게 왜 되죠?
		return post;
	}

	@Override
	public ArrayList<PostVO> getMyPost(MemberVO memberVo, int page) {
		page = (page-1)*10;		//이거 왜 하신 거에요 준수님 모르겠는데요 이거
		ArrayList<PostVO> postList = postDAO.getMyPost(memberVo,page);	//PostVO를 클래스로 가지는 postList객체에 저장<-(postDAO->postMapper에서 limit page,10을 해놨으므로 page행번호부터 10개를 가져옴)
		return postList;	//postList 반환
	}

	@Override
	public ArrayList<ReplyVO> getMyReply(MemberVO memberVo, int page) {
		page = (page-1)*10;
		ArrayList<ReplyVO> replyList = postDAO.getMyReply(memberVo,page);	//댓글 (main에서 로그인을 성공한 사람의 아이디와 같은 댓글을 가져옴)
		return replyList;
	}

	@Override
	public ArrayList<PostVO> getAllPost(int page) {
		page = (page-1)*10;
		ArrayList<PostVO> postList = postDAO.getAllPost(page);	
		return postList;
	}

	@Override
	public boolean writeReply(String content, MemberVO tmpMember, PostVO tmpPost) {
		if(content == null 
				|| content.length() == 0 
				|| tmpMember == null 
				|| tmpPost == null) {
			return false;			
		}
		postDAO.insertReply(content, tmpMember, tmpPost);
		return true;
	}

	@Override
	public ArrayList<ReplyVO> getPostReply(PostVO tmpPost, int page) {
		page = (page-1)*10;
		ArrayList<ReplyVO> replyList = postDAO.getPostReply(tmpPost, page);
		return replyList;
	}

	@Override
	public ArrayList<PostVO> getPostByTitle(String keyword, int page) {
		page = (page-1)*10;
		ArrayList<PostVO> postList = postDAO.getPostByTitle(keyword,page);
		return postList;
	}

	@Override
	public ArrayList<PostVO> getPostByWriter(String keyword, int page) {
		page = (page-1)*10;
		ArrayList<PostVO> postList = postDAO.getPostByWriter(keyword,page);
		return postList;
	}

	@Override
	public ArrayList<PostVO> getPostByDate(String year, String month, String day, int page) {
		page = (page-1)*10;
		if(year.length() != 4) {
			year = null;
		}
		ArrayList<PostVO> postList = postDAO.getPostByDate(year, month, day,page);
		return postList;
	}

	@Override
	public ArrayList<PostVO> getPostByBoard(BoardVO tmpBoard, int page) {
		page = (page-1)*10;
		ArrayList<PostVO> postList = postDAO.getPostByBoard(tmpBoard,page);
		return postList;
	}

	@Override
	public void deleteReply(ReplyVO tmpReply) {
		postDAO.deleteReply(tmpReply);
		
	}

	@Override
	public boolean updateReply(ReplyVO tmpReply, String content) {
		if(postDAO.updateReply(tmpReply,content)) {
			return true;
		}
		return false;

	}

	@Override
	public List<PostVO> getPostList() {
		
		return postDAO.selectPostList();
	}

	@Override
	public boolean setPost(PostVO tmpPost) {
		if(tmpPost==null 
				|| tmpPost.getPo_title() == null || tmpPost.getPo_content() == null) {
			return false;
		}
		
		 return postDAO.updatePost(tmpPost);
		
		
		
		
	}

	@Override //게시글 삭제
	public boolean deletePost(int po_num) {
		
		return postDAO.deletePost(po_num);
	}

	
	//(공지사항 작성,게시글 작성)
	@Override
		public boolean writePost(PostVO postVo) {
			if(postVo == null 
					|| postVo.getPo_title() == null 
					|| postVo.getPo_content() == null
					|| postVo.getPo_mb_id() == null) {
				return false;
			}
			
			boolean res = postDAO.writePost(postVo);
			if(res) {
				session.commit();
			}
			
			return res;
		}


}
