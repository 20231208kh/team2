package project1.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.MemberVO;

public interface MemberDAO {
	
	
	ArrayList<MemberVO> selectMemberList();
	MemberVO getMember(@Param("member")MemberVO member);
	boolean insertMember(@Param("member")MemberVO member);
	boolean updateMember(@Param("member")MemberVO member);

}
