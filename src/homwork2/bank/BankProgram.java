package homwork2.bank;


import java.util.InputMismatchException;
import java.util.Scanner;

import homwork2.bank.service.AccountBookService;
import homwork2.bank.service.AccountBookServiceImp;
import homwork2.bank.service.PrintService;
import homwork2.bank.service.PrintServiceImp;
import program.Program;

public class BankProgram implements Program{
	private PrintService printService= new PrintServiceImp();
	private AccountBookService abs = new AccountBookServiceImp();
	private final int EXIT = 4;
	private Scanner scan = new Scanner(System.in);
	int id = 1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
		//카테고리 출력
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		System.out.print("카테고리 선택 : ");
		//카테고리 선택
		int user = scan.nextInt();
		
		//카테고리에 해당하는 금액 입력
		System.out.println("금액 입력 : ");
		int money = scan.nextInt();
		//상세 출처 입력
		System.out.println("용도 입력 : ");
		scan.nextLine();
		String usage = scan.nextLine();
		//입력값을 bank에 저장
		Bank bank = new Bank(id,user,money,usage);
		//banklist에 bank값이 없으면 저장
		abs.addDeposit(bank);
		id++;
		//num(1) [카테고리 : 카테고리] [금액 : ] [상세내역 : ] [날짜 : ]
		//입력된 금액만큼 수입 total에 (+)로 추가
		System.out.println(bank);
	}
	
	/* 
	 * 입력받은 bankList 내역
	 * List [1,병원 , 2000, 정형외과] , [2,병원, 2000, 정형외과] [3,식비, 3000,제일식당] [4,교통비,1000,버스비] [5,4, 병원,2000,정형외과]
	 * 
	 * user = scan.nextInt();
	 * 
	 * Bank bank = new bank(user);
	 * 
	 * bankList.contains(bank)
	 * 
	 * int index = bankList.indexof(bank);
	 * 
	 * bankList.get(index).setMoney , setDate, setCategori, setUsage
	 * 

	 */
	
	private void deleteDeposit() {
		//수입내역 삭제
		//출력을 원하는 카테고리 선택
		//카테고리 출력
		System.out.println("카테고리 선택 : ");
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		//카테고리 선택
		int user = scan.nextInt();
		Bank categori = new Bank(user);
		//해당 카테고리만 bankList 출력
		if(abs.printCategori(categori));
		System.out.println("삭제할 ID 선택 : ");
		//유저 삭제 원하는 id 입력한다.
		int id = scan.nextInt();
		Bank bank = new Bank(id);
		//해당되는 id와 banklist의 아이디가 같은지 확인
		if(abs.deleteDeposit(bank)) {
			System.out.println("삭제되었습니다.");
		}
		
		
		/* 
		 * 입력받은 bankList 내역
		 * List [1,병원 , 2000, 정형외과] , [2,병원, 2000, 정형외과] [3,식비, 3000,제일식당] [4,교통비,1000,버스비] [5, 병원,2000,정형외과]
		 * 
		 * 카테고리 = scan.next();
		 * 
		 * bankList에서 입력받은 카테고리 인것만 출력
		 * 
		 * [1, 병원,2000,정형외과]
		 * [2, 병원,2000,정형외과]
		 * [5,병원,2000,정형외과]
		 * 
		 * 
		 * 
		 * userId = scan.nextInt();
		 * 
		 * Bank bank = new bank(userId);
		 * 
		 * bankList.contains(bank)
		 * 
		 * int index = bankList.indexOf(bank);
		 * 
		 * setMoney 
		 * 
		 * 
		 * 

		 */

	}

	private void setDeposit() {
		printService.printSetDepositMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			updateDepositMoney();
			break;
		case 2:
			updateDepositUsage();
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
		// TODO Auto-generated method stub
		
	}

	private void updateDepositUsage() {
		// TODO Auto-generated method stub
		
	}

	private void updateDepositDate() {
		// TODO Auto-generated method stub
		
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
			updateWithdrawUsage();
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

	private void updateWithdrawUsage() {
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

	@Override
	public void printMenu() {
		printService.printMainMenu();
		
	}

	@Override
	public void exitMenu() {
		printService.printExit();
		
	}

}
