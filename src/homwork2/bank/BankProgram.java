package homwork2.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

import homwork2.bank.service.PrintService;
import homwork2.bank.service.PrintServiceImp;
import program.Program;

public class BankProgram implements Program{
	private PrintService printService= new PrintServiceImp();
	private final int EXIT = 4;
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
		// TODO Auto-generated method stub
		
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

	private void deleteDeposit() {
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
