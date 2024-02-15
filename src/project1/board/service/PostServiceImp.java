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
import project1.board.model.vo.PostVO;

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
	public boolean write(PostVO postVo) {
		
		boolean res = postDAO.writePost(postVo);
		if(res) {
			session.commit();
		}
		
		return res;
	}
	

}
