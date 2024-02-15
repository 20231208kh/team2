package project1.board.service;

import java.util.ArrayList;
import java.util.List;

import project1.board.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO memberVo);

	boolean signIn(MemberVO member);

	boolean updateAge(MemberVO memberVo, int updateAge);

	boolean updateEmail(MemberVO memberVo, String updateEmail);

	boolean updatePw(MemberVO memberVo, String updatePw);

	boolean deleteMember(MemberVO memberVo);

	//List<MemberVO> getMemberList(String mb_id);

	

	


	


}