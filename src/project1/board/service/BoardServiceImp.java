package project1.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project1.board.dao.BoardDAO;
import project1.board.model.vo.BoardCategoryVO;
import project1.board.model.vo.BoardVO;
import project1.board.model.vo.PostCategoryVO;

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
	
	//카테고리 입력
	@Override
	public boolean insertBoardCategory(BoardCategoryVO boardCategoryVO) {
		boolean res = boardDAO.insertBoardType(boardCategoryVO);
		if(boardCategoryVO == null || boardCategoryVO.getBc_title() == null) {
			System.out.println("카테고리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardCategoryVO.equals(boardDAO.selectBoardCategory())) {
			System.out.println("중복된 카테고리 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//카테고리 이름 수정
	@Override
	public boolean updateBoardCategory(BoardCategoryVO uBoardCategoryVo) {
		boolean res = boardDAO.updateBoardCategory(uBoardCategoryVo);
		if(uBoardCategoryVo == null || uBoardCategoryVo.getBc_title() == null) {
			System.out.println("게시판 이름을 입력하지 않았습니다.");
			return false;
		}
		if(uBoardCategoryVo.equals(boardDAO.selectBoardCategory())) {
			System.out.println("중복된 카테고리 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//카테고리 데이터 받아오는 메서드
	@Override
	public ArrayList<BoardCategoryVO> getBoardCategory() {
		return boardDAO.selectBoardCategory();
	}
	
	//게시판 입력
	@Override
	public boolean insertBoard(BoardVO boardVo) {
		boolean res = boardDAO.insertBoard(boardVo);
		if(boardVo == null || boardVo.getBo_title() == null) {
			System.out.println("게시판 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardVo.equals(boardDAO.selectBoard())) {
			System.out.println("중복된 게시판 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//게시판 수정
	@Override
	public boolean updateBoard(BoardVO uBoardVo) {
		boolean res = boardDAO.updateBoard(uBoardVo);
		if(uBoardVo == null || uBoardVo.getBo_title() == null) {
			System.out.println("게시판 이름을 입력하지 않았습니다.");
			return false;
		}
		if(uBoardVo.equals(boardDAO.selectBoard())) {
			System.out.println("중복된 게시판 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//게시판 데이터 받아오는 메서드
	@Override
	public ArrayList<BoardVO> getBoard() {
		return boardDAO.selectBoard();
	}

	//말머리 입력
	@Override
	public boolean insertPostCategory(PostCategoryVO postCategoryVo) {
		boolean res = boardDAO.insertPostCategory(postCategoryVo);
		if(postCategoryVo == null || postCategoryVo.getPc_title() == null) {
			System.out.println("말머리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(postCategoryVo.equals(boardDAO.selectPostCategory())) {
			System.out.println("중복된 말머리 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//말머리 수정
	@Override
	public boolean updatePostCategory(PostCategoryVO uPostCategoryVo) {
		boolean res = boardDAO.updatePostCategory(uPostCategoryVo);
		if(uPostCategoryVo == null || uPostCategoryVo.getPc_title() == null) {
			System.out.println("말머리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(uPostCategoryVo.equals(boardDAO.selectPostCategory())) {
			System.out.println("중복된 말머리 이름입니다.");
			return false;
		}
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//말머리 데이터 받아오는 메서드
	@Override
	public ArrayList<PostCategoryVO> getPostCategory() {
		return boardDAO.selectPostCategory();
	}

}
