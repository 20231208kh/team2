package homwork2.bank.service;

public class PrintServiceImp implements PrintService {

	@Override
	public void printMainMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 가계부 수입 내역 관리");
		System.out.println("2. 가계부 지출 내역 관리");
		System.out.println("3. 가계부 조회");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void printDepositMenu() {
		System.out.println("----수입 내역 관리----");
		System.out.println("1. 수입 내역 추가");
		System.out.println("2. 수입 내역 수정");
		System.out.println("3. 수입 내역 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
		
	}
	
	@Override
	public void printSetDepositMenu() {
		System.out.println("----수입 내역 수정----");
		System.out.println("1. 수입 금액 수정");
		System.out.println("2. 수입 카테고리&상세 내역 수정");
		System.out.println("3. 수입 날짜 수정");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void printWithdrawMenu() {
		System.out.println("----지출 내역 관리----");
		System.out.println("1. 지출 내역 추가");
		System.out.println("2. 지출 내역 수정");
		System.out.println("3. 지출 내역 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
		
	}
	
	@Override
	public void printSetWithdrawMenu() {
		System.out.println("----지출 내역 수정----");
		System.out.println("1. 지출 금액 수정");
		System.out.println("2. 지출 카테고리&상세 내역 수정");
		System.out.println("3. 지출 날짜 수정");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void printSearchMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printExit() {
		System.out.println("================");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("================");
		
	}




	
}
