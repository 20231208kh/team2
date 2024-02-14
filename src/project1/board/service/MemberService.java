package project1.board.service;

import java.util.ArrayList;

import project1.board.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO memberVo);

	boolean signIn(MemberVO member);


}
