package project1.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project1.board.dao.MemberDAO;
import project1.board.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDAO;
	private InputStream inputStream;
	private SqlSession session;
	
	public MemberServiceImp() {
		String resource = "project1/board/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDAO = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO login(MemberVO memberVo) {
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = memberDAO.selectMemberList();
		if(memberList.contains(memberVo)) {
			int index = memberList.indexOf(memberVo);
			MemberVO tmp = memberList.get(index);
			return tmp;
		}
		
		return null;
	}

	@Override
	public boolean signIn(MemberVO member) {
		if(member == null 
				|| member.getMb_id() == null 
				|| member.getMb_pw() == null
				|| member.getMb_email() == null) {
			return false;
		}
		boolean res = memberDAO.insertMember(member);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public boolean updateAge(MemberVO memberVo, int updateAge) {
		if(memberVo == null 
				|| memberVo.getMb_id() == null 
				|| memberVo.getMb_pw() == null
				|| memberVo.getMb_email() == null) {
			return false;
		}
		boolean res = memberDAO.updateMemberAge(memberVo,updateAge);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public boolean updateEmail(MemberVO memberVo, String updateEmail) {
		if(memberVo == null 
				|| memberVo.getMb_id() == null 
				|| memberVo.getMb_pw() == null
				|| memberVo.getMb_email() == null) {
			return false;
		}
		boolean res = memberDAO.updateMemberEmail(memberVo,updateEmail);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public boolean updatePw(MemberVO memberVo, String updatePw) {
		if(memberVo == null 
				|| memberVo.getMb_id() == null 
				|| memberVo.getMb_pw() == null
				|| memberVo.getMb_email() == null) {
			return false;
		}
		boolean res = memberDAO.updateMemberPw(memberVo,updatePw);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public boolean deleteMember(MemberVO memberVo) {
		if(memberVo == null 
				|| memberVo.getMb_id() == null 
				|| memberVo.getMb_pw() == null
				|| memberVo.getMb_email() == null) {
			return false;
		}
		boolean res = memberDAO.deleteMember(memberVo);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public MemberVO getMember(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return null;
	}
}