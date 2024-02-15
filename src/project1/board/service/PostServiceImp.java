package project1.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project1.board.dao.PostDAO;
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
		PostVO post = postDAO.getPost(tmpPost).get(0);
		return post;
	}

	@Override
	public ArrayList<PostVO> getMyPost(MemberVO memberVo, int page) {
		page = (page-1)*10;
		ArrayList<PostVO> postList = postDAO.getMyPost(memberVo,page);
		return postList;
	}

	@Override
	public ArrayList<ReplyVO> getMyReply(MemberVO memberVo, int page) {
		page = (page-1)*10;
		ArrayList<ReplyVO> replyList = postDAO.getMyReply(memberVo,page);
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

}
