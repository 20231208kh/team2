package project1.board.service;


import project1.board.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO memberVo);

	boolean signIn(MemberVO member);

	boolean updateAge(MemberVO memberVo, int updateAge);

	boolean updateEmail(MemberVO memberVo, String updateEmail);

	boolean updatePw(MemberVO memberVo, String updatePw);

	boolean deleteMember(MemberVO memberVo);

	MemberVO getMember(MemberVO memberVo);



}

