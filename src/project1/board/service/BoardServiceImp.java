package project1.board.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project1.board.dao.BoardDAO;

//BoardController에게 받은 입력값을 처리하고 쿼리에 필요한 정보를 BoardDAO에게 보내주는 서비스
public class BoardServiceImp implements BoardService {

	private BoardDAO boardDAO;
	private InputStream inputStream;
	private SqlSession session;
	public BoardServiceImp() {
		String resource = "project1/board/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDAO = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
