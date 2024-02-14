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
}




