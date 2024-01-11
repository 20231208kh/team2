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
	private AccountBookServiceImp abs = new AccountBookServiceImp();
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
		//카테고리 출력
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		System.out.print("카테고리 선택 : ");
		//카테고리 선택
		int user = scan.nextInt();
		
		//카테고리에 해당하는 금액 입력
		System.out.println("금액 입력(0원 이상) : ");
		int money = scan.nextInt();
		//입금 금액이 양수인지 확인
		if(!abs.moneyCheck(money)) {
			return;
		}
		
		//상세 출처 입력
		System.out.println("상세내역 입력 : ");
		scan.nextLine();
		String usage = scan.nextLine();
		//입력값을 bank에 저장
		Bank bank = new Bank(id,user,money,usage);
		//banklist에 bank값이 없으면 저장
		abs.addDeposit(bank);
		id++;
		abs.printDeposit();
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
		abs.printDeposit();
		System.out.println("삭제할 ID 선택 : ");
		//유저 삭제 원하는 id 입력한다.
		int id = scan.nextInt();
		Bank bank = new Bank(id);
		if(abs.deleteDeposit(bank)) {
			System.out.println("삭제 성공");
			abs.printList();
			return;
		}
		System.out.println("잘못된 ID입력");
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
		abs.printDeposit();
		System.out.println("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.println("수정할 금액 입력 : ");
		int money = scan.nextInt();
		//수정할 금액이 양수인지 확인
		if(!abs.moneyCheck(money)) {
			return;
		}
		Bank bank = new Bank(id);
		if(abs.updateDepositMoney(bank, money)) {
			System.out.println("수정 성공.");
			abs.printList();
			return;
		}
		System.out.println("잘못된 ID입력");
	}

	private void updateDepositCategori() {
		char ask = 'n';
		abs.printDeposit();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.println("1.급여"+"\n2.불로소득"+"\n3.실비"+"\n4.용돈"+"\n5.기타");
		System.out.print("수정할 출처 입력 : ");
		int user = scan.nextInt();
		Bank bank = new Bank(id);
		if(abs.updateDepositCategori(bank, user)) {
			System.out.println("수정 성공.");
			abs.printList();
		}
		System.out.print("상세내역을 수정하시겠습니까?(y/n) : ");
		ask = scan.next().charAt(0);
		if(ask == 'y') {
			System.out.print("수정할 상세내역 입력 : ");
			scan.nextLine();
			String usage = scan.nextLine();
			Bank use = new Bank(id);
			if(abs.updateDepositUsage(use, usage)) {
				System.out.println("수정 성공.");
				abs.printList();
				return;
			}
			System.out.println("잘못된 ID입력");
		}else {
			System.out.println("메뉴로 돌아갑니다.");
			return;
		}
	}

	private void updateDepositDate() {
		abs.printDeposit();
		System.out.print("수정할 ID 입력 : ");
		int id = scan.nextInt();
		System.out.print("수정할 날짜(yyyy/MM/dd) 입력 : ");
		scan.nextLine();
		String today = scan.nextLine();
		Bank bank = new Bank(id);
		if(abs.updateDepositDate(bank, today)) {
			System.out.println("수정 성공.");
			abs.printList();
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

	@Override
	public void printMenu() {
		printService.printMainMenu();
		
	}

	@Override
	public void exitMenu() {
		printService.printExit();
		
	}

}
