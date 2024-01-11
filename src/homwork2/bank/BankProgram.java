package homwork2.bank;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homwork2.bank.service.AccountBookService;
import homwork2.bank.service.AccountBookServiceImp;
import homwork2.bank.service.PrintService;
import homwork2.bank.service.PrintServiceImp;
import program.Program;

public class BankProgram implements Program{
	private PrintService printService= new PrintServiceImp();
	private AccountBookService absi = new AccountBookServiceImp();

	private final int EXIT = 4;
	private int id = 1;
	private Scanner scan = new Scanner(System.in);
	@Override
	public void run() {
		int menu = 0;
		
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

	private void addDeposit() {
//		
//		System.out.println("급여(1)/불로소득(2)/실비(3)/용돈(4)기타(5)");
//		System.out.print("카테고리를 입력해주세요 : ");
//		int user = scan.nextInt();
//		System.out.print("수입 금액을 입력해주세요 : ");
//		int money = scan.nextInt();
//		System.out.println("상세 내역을 입력해주세요 : ");
//		scan.nextLine();
//		String usage = scan.nextLine();
//		Bank bank = new Bank(id,user,money,usage);
//		if(absi.addDeposit(bank)) {
//			System.out.println("등록에 성공하였습니다.");
//			id ++;
//			return;
//		}
//		System.out.println("등록에 실패하였습니다. ");

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

	private void updateDepositMoney() {
//		System.out.println(absi.getBankList());
//		System.out.print("수정할 id를 입력 : ");
//		int userId = scan.nextInt();
//		System.out.print("금액 수정 : ");
//		int userMoney =scan.nextInt();
//		if (userMoney < 0 ) {
//			System.out.println("지출 내역 수정을 이용해주세요.");
//			return;
//		}
//		Bank bank = new Bank(userId);
//		if(absi.updateDepositMoney(bank,userMoney)) {
//			System.out.println("등록 성공");
//		}
//		System.out.println("등록 되지 않은 내역입니다.");
//		System.out.println(absi.getBankList());
		
	}

	private void updateDepositCategori() {
		// TODO Auto-generated method stub
		
	}

	private void updateDepositDate() {
		// TODO Auto-generated method stub
		
	}

	private void deleteDeposit() {
//		System.out.println(absi.getBankList());
//		System.out.print("삭제할 id를 입력 : ");
//		int userId = scan.nextInt();
//		Bank bank = new Bank(userId);
//		
//		absi.deleteDeposit(bank);
		
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

	private void addWithdraw() {
		// TODO Auto-generated method stub
		
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

	private void updateWithdrawMoney() {
		// TODO Auto-generated method stub
		
	}

	private void updateWithdrawCategori() {
		// TODO Auto-generated method stub
		
	}

	private void updateWithdrawDate() {
		// TODO Auto-generated method stub
		
	}

	private void deleteWithdraw() {
		// TODO Auto-generated method stub
		
	}

	private void manageSearch() {
		// TODO Auto-generated method stub
		
	}

	private void updateWithdrawCategori() {
		// TODO Auto-generated method stub
		
	}

	private void updateWithdrawDate() {
		// TODO Auto-generated method stub
		
	}

	private void deleteWithdraw() {
		// TODO Auto-generated method stub
		
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

	private void searchByYear() {
		List<Bank> tmp = new ArrayList<Bank>();
		System.out.print("조회할 연 입력 : ");
		String year = scan.next();
		if(absi.searchByDate(year, tmp)) {
			absi.printDetail(tmp);
			return;
		}
	}

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