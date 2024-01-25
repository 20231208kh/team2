package homwork2.bank;


import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homwork2.bank.service.AccountBookService;
import homwork2.bank.service.AccountBookServiceImp;
import homwork2.bank.service.FileService;
import homwork2.bank.service.FileServiceImp;
import homwork2.bank.service.PrintService;
import homwork2.bank.service.PrintServiceImp;

import program.Program;

public class BankProgram implements Program , Serializable{
	private static final long serialVersionUID = 1416137387017570546L;
	private Scanner scan = new Scanner(System.in);
	private PrintService printService= new PrintServiceImp();
	private AccountBookService absi = new AccountBookServiceImp();
	private FileService fsi = new FileServiceImp(); 
	
	private String fileName = "src/homwork2/bank/service/AccountBook.txt";
	private final int EXIT = 5;
	
	@Override
	public void run() {
		int menu = 0;
		absi.fileLoad(fsi.load(fileName));
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e){
				System.out.println("잘못된 메뉴 선택입니다.");
				scan.nextLine();
			}
		}while(menu!=EXIT);
		fsi.save((AccountBookServiceImp) absi, fileName);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			manageDeposit();
			break;
		case 2:
			manageWithdraw();
			break;
		case 3:
			manageSearch();
			break;
		case 4:
			absi.reset();
			break;
		case 5:
			exitMenu();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	
	private void manageDeposit() {
		printService.printDepositMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			addDeposit();
			break;
		case 2:
			setDeposit();
			break;
		case 3:
			deleteDeposit();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	// 수입 내역 추가
	private void addDeposit() {
		//카테고리 출력
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		System.out.print("카테고리 선택 : ");
		//카테고리 선택
		int user = scan.nextInt();
		//카테고리에 해당하는 금액 입력
		System.out.print("금액 입력(0원 이상) : ");
		int money = scan.nextInt();
		if (money<=0) {
			System.out.println("0 혹은 음수는 입력이 불가합니다.");
			return;
		}
		//상세 출처 입력
		System.out.print("상세내역 입력 : ");
		scan.nextLine();
		String usage = scan.nextLine();
		try {
			//입력값을 bank에 저장
			Bank bank = new Bank(user,money,usage);
			absi.addDeposit(bank);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못 선택된 카테고리입니다.");
		}
	}
	
	// 수입 내역 삭제
	private void deleteDeposit() {
		absi.printDeposit();
		System.out.print("삭제할 ID 선택 : ");
		int id = scan.nextInt();
		Bank bank = new Bank(id);
		if(absi.deleteDeposit(bank)) {
			System.out.println("삭제 성공");
			absi.printDeposit();
			return;
		}
		System.out.println("잘못된 ID입력");
	}
		
	
	private void setDeposit() {
		printService.printSetDepositMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			updateDepositMoney();
			break;
		case 2:
			updateDepositCategori();
			break;
		case 3:
			updateDepositDate();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;

		}
	}
	
	// 수입 내역 금액 수정
	private void updateDepositMoney() {
		absi.printDeposit();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.print("수정할 금액 입력 : ");
		int money = scan.nextInt();
		if (money<=0) {
			System.out.println("0혹은 음수는 입력이 불가능합니다.");
			return;
		}
		Bank bank = new Bank(id);
		if(absi.updateDepositMoney(bank, money)) {
			System.out.println("수정 성공.");
			return;
		}
		System.out.println("잘못된 ID입력");
	}

	// 수입 내역 분류 수정
	private void updateDepositCategori() {
		char ask = 'n';
		absi.printDeposit();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		System.out.print("수정할 카테고리 입력 : ");
		int user = scan.nextInt();
		Bank bank = new Bank(id);
		if(absi.updateDepositCategori(bank, user)) {
			System.out.println("수정 성공.");
			absi.printDeposit();
			System.out.print("상세내역을 수정하시겠습니까?(y/n) : ");
			ask = scan.next().charAt(0);
			if(ask == 'y') {
				System.out.print("수정할 상세내역 입력 : ");
				scan.nextLine();
				String usage = scan.nextLine();
				if(absi.updateDepositUsage(bank, usage)) {
					System.out.println("수정 성공.");
					return;
				}
				System.out.println("잘못된 ID입력");
			}
		}
		System.out.println("메뉴로 돌아갑니다.");
	}
	
	// 수입 내역 일자 수정
	private void updateDepositDate() {
		absi.printDeposit();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.print("수정할 연도 입력 : ");
		String year = scan.next();
		System.out.print("수정할 월 입력 : ");
		String month = scan.next();
		if(month.length()==1) {month = "0"+month;}
		System.out.print("수정할 일 입력 : ");
		String day = scan.next();
		if(day.length()==1) {day = "0"+day;}
		String p = "{0}/{1}/{2}";
		String date = MessageFormat.format(p,year,month,day);
		
		Bank bank = new Bank(id);
		if(absi.updateDepositDate(bank, date)) {
			System.out.println("수정 성공.");
			return;
		}
		System.out.println("잘못된 ID입력");
	}

	
	
	
	private void manageWithdraw() {
		printService.printWithdrawMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			addWithdraw();
			break;
		case 2:
			setWithdraw();
			break;
		case 3:
			deleteWithdraw();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
		
	}


	private void setWithdraw() {
		printService.printSetWithdrawMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			updateWithdrawMoney();
			break;
		case 2:
			updateWithdrawCategori();
			break;
		case 3:
			updateWithdrawDate();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
			
		}
		
	}


	//지출 내역 추가
	private void addWithdraw() {
		System.out.println("1.병원비\n2.식비\n3.교통비\n4.유흥비\n5.보험료\n6.기타");
		System.out.print("카테고리 번호를 선택하세요 : ");
		int categorynum=scan.nextInt(); //카테고리 번호
		System.out.print("지출한 돈을 입력하세요 : ");
		int drawmoney= -scan.nextInt(); //지출한 돈
		System.out.print("지출 상세내역을 입력하세요 : ");
		scan.nextLine(); 
		String drawusage=scan.nextLine(); //
		try {
			Bank bank=new Bank(categorynum, drawmoney, drawusage);
			if(absi.addWithdraw(bank)) {
				System.out.println("등록에 성공하였습니다.");
				return;
			}
		}catch (IndexOutOfBoundsException e) {
				System.out.println("잘못된 카테고리 입력");
		}
		System.out.println("등록 실패");
		
	}

	//지출 내역 금액 수정
	private void updateWithdrawMoney() {
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.print("수정할 금액을 입력 : ");
		int usermoney= -scan.nextInt();
		
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawMoney(bank, usermoney)) {
			System.out.println("수정 성공하였습니다.");
			return;
		}
		System.out.println("수정에 실패하였습니다.");
		
	}
	
	//지출 내역 분류 수정
	private void updateWithdrawCategori() {
		char ask = 'n';
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.println("1.병원비\n2.식비\n3.교통비\n4.유흥비\n5.보험료\n6.기타");
		System.out.print("수정할 카테고리를 입력 : ");
		int user = scan.nextInt();
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawCategori(bank, user)) {
			System.out.println("수정 성공하였습니다.");
			return;
		}
		System.out.print("상세내역을 수정하시겠습니까?(y/n) : ");
		ask=scan.next().charAt(0);
		if(ask == 'y') {
			System.out.print("수정할 상세내역 입력 : ");
			scan.nextLine();
			String usage = scan.nextLine();
			if(absi.updateWithdrawUsage(bank, usage)) {
				System.out.println("수정 성공.");
				return;
			}
			System.out.println("잘못된 ID입력");
		}
		
		System.out.println("메뉴로 돌아갑니다.");
			
	}
	
	

	//지출 내역 일자 수정
	private void updateWithdrawDate() {
		absi.printWithdraw();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.print("수정할 연도 입력 : ");
		String year = scan.next();
		System.out.print("수정할 월 입력 : ");
		String month = scan.next();
		if(month.length()==1) {month = "0"+month;}
		System.out.print("수정할 일 입력 : ");
		String day = scan.next();
		if(day.length()==1) {day = "0"+day;}
		String p ="{0}/{1}/{2}";
		String date = MessageFormat.format(p,year,month,day);
		
		Bank bank= new Bank(id);
		if(absi.updateWithdrawDate(bank, date)){
			System.out.println("수정 성공.");
			return;
	}
		System.out.println("잘못된 ID입력");
	}
		
	//지출 내역 삭제
	private void deleteWithdraw() {
		absi.printWithdraw();
		System.out.print("삭제할 id를 입력 : ");
		int userId = scan.nextInt();
		Bank bank = new Bank(userId);
	
		if(absi.deleteWithdraw(bank,userId)) {
			System.out.println("삭제 성공");
			absi.printWithdraw();
			return;
		}
		System.out.println("삭제 실패");
		
	}


	
	
	private void manageSearch() {
		printService.printSearchMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			searchAll();
			break;
		case 2:
			searchByMoney();
			break;
		case 3:
			searchByType();
			break;
		case 4:
			searchByDate();
			break;
		case 5:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	//전체 조회
	private void searchAll() {
		List<Bank> tmp = new ArrayList<Bank>();
		if(absi.searchAll(tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}
	
	
	private void searchByMoney() {
		printService.printSearchByMoney();
		int menu = scan.nextInt();
		switch(menu) {
		case 1: 
			searchByMinMax();
			break;
		case 2: 
			searchByMax();
			break;
		case 3: 
			searchByMin();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();	
		}
	}

	//최소 ~ 최대 금액 조회
	private void searchByMinMax() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 최소 금액 : ");
		int min = scan.nextInt();
		System.out.print("최대 금액 : ");
		int max = scan.nextInt();
		if(absi.searchByMoney(min, max, tmp)) {
			absi.printGroup(tmp);
			return;
		}
	}
	
	//	max 이하 조회
	private void searchByMax() {
		List<Bank> tmp = new ArrayList<Bank>();
		int min = 0;
		System.out.print("조회할 최대 금액 : ");
		int max = scan.nextInt();
		if(absi.searchByMoney(min, max, tmp)) {
			absi.printGroup(tmp);
			return;
		}
	}

	//	min 이상 조회
	private void searchByMin() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 최소 금액 : ");
		int min = scan.nextInt();
		if(absi.searchByMoney(min, tmp)) {
			absi.printGroup(tmp); 
			return;
		}
	}

	
	
	
	private void searchByType() {
		printService.printSearchByType();
		int menu = scan.nextInt();
		switch (menu) {
		case 1:
			searchByCategori();
			break;
		case 2: 
			searchByUsage();
			break;
		case 3: 
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	
	
	
	//분류별 조회
	private void searchByCategori() {
		String arr[] = new String[]{"급여","불로소득","실비","용돈","병원비","식비","교통비","유흥비","보험료","기타"};
		List<Bank> tmp = new ArrayList<Bank>();
		int i = 1;
		System.out.print("카테고리 : ");
		for(String a: arr ) {System.out.print("["+ i++ + "." + a + "]");}
		System.out.println();
		System.out.print("입력 : ");
		int user = scan.nextInt();
		if(user<1||user>10) {
			System.out.println("없는 카테고리 번호 입니다.");
			return;
		}
		String categori = arr[user-1];
		if(absi.serchByCategori(categori, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}

	//상세 출처 조회
	private void searchByUsage() {
		scan.nextLine();
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 출처 : ");
		String usage = scan.nextLine();
		if(absi.searchByUsage(usage, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}
	
	private void searchByDate() {
		printService.printSearchByDate();
		int menu = scan.nextInt();
		switch (menu) {
		case 1: 
			searchByYear();
			break;
		case 2: 
			searchByMonth();
			break;
		case 3: 
			searchByDay();
			break;
		case 4: 
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();	
		}
	}

	//연 조회
	private void searchByYear() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 연 입력 : ");
		String year = scan.next();
		if(absi.searchByDate(year, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}
	
	//월 조회
	private void searchByMonth() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 연 입력 : ");
		String year = scan.next();
		System.out.print("월 입력 : ");
		String month = scan.next();
		if(month.length()==1) {month = "0"+month;}
		if(absi.searchByDate(year, month, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}
	
	//일 조회
	private void searchByDay() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 연 입력 : ");
		String year = scan.next();
		System.out.print("월 입력 : ");
		String month = scan.next();
		if(month.length()==1) {month = "0"+month;}
		System.out.print("일 입력 : ");
		String day = scan.next();
		if(day.length()==1) {day = "0"+day;}
		if(absi.searchByDate(year, month, day, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}

	@Override
	public void printMenu() {
		printService.printMainMenu();
	}

	@Override
	public void exitMenu() {
		printService.printExit();
	}

}