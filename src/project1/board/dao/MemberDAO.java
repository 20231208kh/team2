
package project1.board.dao;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.annotations.Param;

import project1.board.model.vo.MemberVO;

public interface MemberDAO {
	ArrayList<MemberVO> selectMemberList();
	MemberVO getMember(@Param("member")MemberVO member);
	boolean insertMember(@Param("member")MemberVO member);
	boolean updateMember(@Param("member")MemberVO member);
	boolean updateMemberAge(@Param("memberVo")MemberVO memberVo, @Param("updateAge") int updateAge);
	boolean updateMemberEmail(@Param("memberVo")MemberVO memberVo, @Param("updateEmail")String updateEmail);
	boolean updateMemberPw(@Param("memberVo")MemberVO memberVo, @Param("updatePw")String updatePw);
	boolean deleteMember(@Param("memberVo")MemberVO memberVo);

//	List<MemberVO> selectMemberList(@Param("mb_id")String mb_id);
	
	

}

