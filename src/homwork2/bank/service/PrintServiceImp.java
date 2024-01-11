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
		System.out.println("----가계부 조회----"); 
		System.out.println("1. 전체 조회");
		System.out.println("2. 금액별 조회"); // 지정범위, 일정금액 이상, 일정금액 이하
		System.out.println("3. 분류별 조회"); // 카테고리, 사용처
		System.out.println("4. 일자별 조회"); // 월별, 일별?
		System.out.println("5. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printSearchByMoney() {
		System.out.println("----금액별 조회----");
		System.out.println("1. 지정범위 금액 조회");
		System.out.println("2. 일정금액 이하 조회");
		System.out.println("3. 일정금액 이상 조회");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void printSearchByType() {
		System.out.println("----분류별 조회----");
		System.out.println("1. 카테고리 조회");
		System.out.println("2. 상세내역 조회");
		System.out.println("3. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void printSearchByDate() {
		System.out.println("----일자별 조회----");
		System.out.println("1. 연 내역 조회");
		System.out.println("2. 월 내역 조회");
		System.out.println("3. 일 내역 조회");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}

	
	@Override
	public void printExit() {
		System.out.println("================");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("================");
		
	}

}
