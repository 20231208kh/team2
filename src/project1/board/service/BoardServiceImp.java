package project1.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
		if(boardCategoryVO == null || boardCategoryVO.getBc_title() == null) {
			System.out.println("카테고리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectBoardCategory().contains(boardCategoryVO)) {
			System.out.println("중복된 카테고리 이름입니다.");
			return false;
		}
		boolean res = boardDAO.insertBoardType(boardCategoryVO);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//카테고리 이름 수정
	@Override
	public boolean updateBoardCategory(BoardCategoryVO uBoardCategoryVo) {
		if(uBoardCategoryVo == null || uBoardCategoryVo.getBc_title() == null) {
			System.out.println("카테고리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(!boardDAO.selectBoardCategory().contains(uBoardCategoryVo.getBc_num())) {
			System.out.println("해당 카테고리가 존재하지 않습니다.");
			return false;
		}
		if(boardDAO.selectBoardCategory().contains(uBoardCategoryVo)) {
			System.out.println("중복된 카테고리 이름입니다.");
			return false;
		}
		boolean res = boardDAO.updateBoardCategory(uBoardCategoryVo);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//카테고리 삭제
	@Override
	public boolean deleteBoardCategory(BoardCategoryVO dBoardCategoryVo) {
		if(dBoardCategoryVo == null) {
			System.out.println("카테고리 번호를 입력하지 않았습니다.");
			return false;
		}
		if(!boardDAO.selectBoardCategory().contains(dBoardCategoryVo.getBc_num())) {
			System.out.println("해당 카테고리가 존재하지 않습니다.");
			return false;
		}
		if(boardDAO.selectBoardCategory().size() == 1) {
			System.out.println("최소 하나의 카테고리는 존재해야합니다.");
			return false;
		}
		boolean res = boardDAO.deleteBoardCategory(dBoardCategoryVo);
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
		if(!boardDAO.selectBoard().contains(boardVo.getBo_bc_num())) {
			System.out.println("해당 카테고리가 존재하지 않습니다.");
			return false;
		}
		if(boardVo == null || boardVo.getBo_title() == null) {
			System.out.println("게시판 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectBoard().contains(boardVo)) {
			System.out.println("중복된 게시판 이름입니다.");
			return false;
		}
		boolean res = boardDAO.insertBoard(boardVo);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//게시판 수정
	@Override
	public boolean updateBoard(BoardVO uBoardVo) {
		if(uBoardVo == null || uBoardVo.getBo_title() == null) {
			System.out.println("게시판 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectBoard().contains(uBoardVo)) {
			System.out.println("중복된 게시판 이름입니다.");
			return false;
		}
		boolean res = boardDAO.updateBoard(uBoardVo);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//게시판 삭제
	@Override
	public boolean deleteBoard(BoardVO dBoardVo) {
		if(dBoardVo == null) {
			System.out.println("게시판 번호를 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectBoard().size() == 1) {
			System.out.println("최소 하나의 게시판은 존재해야합니다.");
			return false;
		}
		boolean res = boardDAO.deleteBoard(dBoardVo);
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
		if(postCategoryVo == null || postCategoryVo.getPc_title() == null) {
			System.out.println("말머리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectPostCategory().contains(postCategoryVo)) {
			System.out.println("중복된 말머리 이름입니다.");
			return false;
		}
		boolean res = boardDAO.insertPostCategory(postCategoryVo);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//말머리 수정
	@Override
	public boolean updatePostCategory(PostCategoryVO uPostCategoryVo) {
		if(uPostCategoryVo == null || uPostCategoryVo.getPc_title() == null) {
			System.out.println("말머리 이름을 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectPostCategory().contains(uPostCategoryVo)) {
			System.out.println("중복된 말머리 이름입니다.");
			return false;
		}
		boolean res = boardDAO.updatePostCategory(uPostCategoryVo);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	//말머리 삭제
	@Override
	public boolean deletePostCategory(PostCategoryVO dPostCategoryVo) {
		if(dPostCategoryVo == null) {
			System.out.println("말머리 번호를 입력하지 않았습니다.");
			return false;
		}
		if(boardDAO.selectPostCategory().size() == 1) {
			System.out.println("최소 하나의 말머리는 존재해야합니다.");
			return false;
		}
		boolean res = boardDAO.deletePostCategory(dPostCategoryVo);
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
	
	//게시판 출력
	@Override
	public void printBoard() {
		ArrayList<BoardVO> BoardList = getBoard();
		if(BoardList.size() == 0) {
			System.out.println("등록된 게시판이 없습니다.");
			return;
		}
		for(BoardVO tmp : BoardList) {
			System.out.println(tmp);
		}
		
	}
	
	//카테고리 출력
	@Override
	public void printBoardCategory() {
		ArrayList<BoardCategoryVO> boardCategoryList = getBoardCategory();
		if(boardCategoryList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
		for(BoardCategoryVO tmp : boardCategoryList) {
			System.out.println(tmp);
		}
	}
	
	//말머리 출력
	@Override
	public void printPostCategory() {
		ArrayList<BoardVO> boardList = getBoard();
		if(boardList.size() == 0) {
			System.out.println("등록된 카테고리가 없습니다.");
			return;
		}
		for(BoardVO tmp : boardList) {
			System.out.println(tmp);
		}
	}

}