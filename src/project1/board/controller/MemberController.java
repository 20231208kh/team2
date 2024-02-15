package project1.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.board.model.vo.MemberVO;
import project1.board.service.MemberService;
import project1.board.service.MemberServiceImp;
import project1.board.service.PrintService;
import project1.board.service.PrintServiceImp;

//회원 가입을 진행하는 컨트롤러
//회원 가입시 특별한 코드를 입력하면 ADMIN 권한을 가진 사용자가 됨
//회원 등록 수정 삭제의 역할을 하고, 입력받은 값을 MemberService에게 보내주는 역할의 컨트롤러

public class MemberController {
	private MemberService memberService = new MemberServiceImp();
	private PostController postController = new PostController();
	private MemberVO memberVo;
	private Scanner scan = new Scanner(System.in);
	private PrintService printService = new PrintServiceImp();
	
	
	public MemberVO login() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = scan.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = scan.next();
		MemberVO tmp = new MemberVO(id,pw);
		
		if(memberService.login(tmp)!=null) {
			
			return memberVo = memberService.login(tmp);
		}
		return null;
		
		

	}

	public MemberVO getMemberInfo() {
		return memberService.login(memberVo);
		
	}

	public boolean signIn() {
		System.out.println("--회원가입을 진행합니다.--");
		System.out.print("ID를 입력해주세요 : ");
		String id = scan.next();
		System.out.print("PW를 입력해주세요 : ");
		String pw = scan.next();
		System.out.print("Email을 입력해주세요 : ");
		String email = scan.next();
		System.out.print("나이를 입력해주세요 : ");
		int age = scan.nextInt();
		System.out.print("주민등록번호를 입력해주세요 : ");
		String localnum = scan.next();
		System.out.print("권한을 입력해주세요");
		String role = scan.next();
		MemberVO member = new MemberVO(id,pw,email,age,localnum,role);
		
		if(memberService.signIn(member)) {	//등록이 성공한다면 
			return true;
		};
		return false;
	}

	public void updateUser() {
		printService.updateMyInfo();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			updatePw();
			break;
		case 2:
			updateEmail();
			break;
		case 3:
			updateAge();
			break;
		case 4:
			deleteUser();
			break;
		case 5:
			System.out.println("뒤로 돌아갑니다.");
			break;
		}
		
	}

	public void updateAge() {
		System.out.print("수정할 나이를 입력해주세요 : ");
		int updateAge = scan.nextInt();
		if(memberVo.getMb_age()==updateAge){
			System.out.println("기존의 나이와 같은 나이로 수정할 수 없습니다.");
			return;

		}
		if(memberService.updateAge(memberVo,updateAge)) {
			System.out.println("수정이 완료되었습니다.");
			return;

		}
		System.out.println("수정 실패");
		
	}

	public void updateEmail() {
		System.out.print("수정할 이메일을 입력해주세요 : ");
		String updateEmail = scan.next();
		if(memberVo.getMb_email().equals(updateEmail)) {
			System.out.println("기존의 이메일과 같은 이메일로 수정할 수 없습니다.");
			return;
		}
		if(memberService.updateEmail(memberVo,updateEmail)) {
			System.out.println("수정이 완료되었습니다.");
			return;
		}
		System.out.println("수정 실패");
		
	}
		
	

	public void updatePw() {
		System.out.print("수정할 비밀번호를 입력해주세요 : ");
		String updatePw = scan.next();
		if(memberVo.getMb_pw().equals(updatePw)) {
			System.out.println("기존의 비밀번호와 같은 비밀번호로 수정할 수 없습니다.");
			return;
		}
		if(memberService.updatePw(memberVo,updatePw)) {
			System.out.println("수정이 완료되었습니다.");
			System.out.println("수정된 비밀번호로 다시 로그인해주세요.");
			return;
		}
		System.out.println("수정 실패");
		
	}

	public void deleteUser() {
		int menu=0;
		System.out.println("회원 탈퇴를 진행합니다.");
		System.out.println("비밀번호를 입력해주세요 : ");
		String pw = scan.next();
		System.out.println("주민등록번호를 입력해주세요 : ");
		String localNum = scan.next();
		if(memberVo.getMb_pw().equals(pw)&&memberVo.getMb_localnum().equals(localNum)) {
			System.out.println("입력 정보가 확인되었습니다.");
			System.out.println("정말 회원탈퇴를 하시겠습니까?");
			System.out.println("1. 회원 탈퇴");
			System.out.println("2. 취소");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
		}
		switch(menu) {
		case 1:
			if(memberService.deleteMember(memberVo)) {
				memberVo = null;
				System.out.println("회원 탈퇴 완료");
			};
			break;
		case 2:
			System.out.println("회원 탈퇴를 취소합니다. 이전 메뉴로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
			break;
		}
		
	}

}