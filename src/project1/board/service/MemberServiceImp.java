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
	public MemberVO login(MemberVO memberVo) {	//MemberVO 
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();  //MemberVo 클래스를 기반으로 한 리스트 memberList를 정의
		memberList = memberDAO.selectMemberList();	//memberList에 memberDAO가 가지고 오는 멤버의 정보 모두를 넣어줌
		if(memberList.contains(memberVo)) { //memberList에 memberVo 객체를 가지는 것이 있다면
			int index = memberList.indexOf(memberVo);	//그 인덱스 번호를 변수 index에 저장
			MemberVO tmp = memberList.get(index);	//memberList에서 가져온 해당 인덱스의 객체를 tmp 객체 넣어줌
			return tmp;	//tmp를 반환
		}
		
		return null;
	}

	@Override
	public boolean signIn(MemberVO member) {	
		if(member == null 	//member 객체와 member 객체가 가지는 id,pw,email이 null이라면
				|| member.getMb_id() == null 
				|| member.getMb_pw() == null
				|| member.getMb_email() == null) {
			return false;		
		}
		boolean res = memberDAO.insertMember(member);	// boolean 변수 res에 memberDAO의 insertMember(member 객체) 반환 값을 넣어줌 
		if(res) {
			session.commit();	//
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
	public ArrayList<MemberVO> getMember() {
		return memberDAO.selectMemberList();
	}

	@Override
	public boolean updateMemberRight(String id) {
		if(getMember().size()==0) {
			return false;
		}
		
		for(int i=0; i<getMember().size(); i++) {
			if(getMember().get(i).getMb_id().equals(id)&&!getMember().get(i).getMb_right().equals("ADMIN")) {
				if(memberDAO.updateMemberRight(id)) {
				   return true;
				}
				
			}
		}
		return false;

	}




	
}

