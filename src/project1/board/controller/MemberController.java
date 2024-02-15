package project1.board.controller;

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
	private MemberVO memberVo;
	private Scanner scan = new Scanner(System.in);
	private PrintService printService = new PrintServiceImp();
	private PostController postController =new PostController();
	
	
	public MemberVO login() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = scan.next();
		System.out.println("비밀번호를 입력해주세요 : ");
		String pw = scan.next();
		memberVo = new MemberVO(id,pw);
		
		if(memberService.login(memberVo)!=null) {
			return memberService.login(memberVo);
		}
		return null;
		
		

	}

	public MemberVO getMemberInfo() {
		// TODO Auto-generated method stub
		return null;
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
		
		if(memberService.signIn(member)) {
			return true;
		};
		
		return false;
	}

	public void run() {
		int menu = 0;
		do {
			printService.loggedinUserMenu();
			menu=scan.nextInt();
			runUser(menu);
		}while(menu !=6);
		
	}

	private void runUser(int menu) {
		switch(menu) {
		case 1:
			postController.writePost();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			updateUser();
			break;
		case 6:
			System.out.println("로그아웃 합니다.");
			break;
		}
		
	}

	private void updateUser() {
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
	
	private void updateAge() {
		// TODO Auto-generated method stub
		
	}

	private void updateEmail() {
		// TODO Auto-generated method stub
		
	}

	private void updatePw() {
		// TODO Auto-generated method stub
		
	}

	private void deleteUser() {
		// TODO Auto-generated method stub
		
	}

}
