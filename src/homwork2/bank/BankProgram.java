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
	private AccountBookServiceImp absi = new AccountBookServiceImp();
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
		default:
			throw new InputMismatchException();
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
		System.out.println("병원비(1)/식비(2)/교통비(3)/유흥비(4)/보험료(5)/기타(6)");
		System.out.println("카테고리 번호를 선택하세요.");
		int categorynum=scan.nextInt(); //카테고리 번호
		System.out.println("지출한 돈을 입력하세요.");
		int drawmoney= -scan.nextInt(); //지출한 돈
		System.out.println("지출 상세내역을 입력하세요.");
		scan.nextLine(); 
		String drawusage=scan.nextLine(); //
		Bank bank=new Bank(id, categorynum, drawmoney, drawusage);
		if(absi.addWithdraw(bank)) {
			System.out.println("등록에 성공하였습니다.");
			id ++;
		return;
		}
		System.out.println("등록에 실패하였습니다. ");
		absi.printWithdraw();
	}

	private void setWithdraw() {
		printService.printSetWithdrawMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			updateWithdrawMoney();
			break;
		case 2:
				printService.printSetCateogryorUsage();
				menu=scan.nextInt();
					switch(menu) {
					
					case 1:
						updateWithdrawCategori();
						break;
					case 2:
						updateWithdrawuage();
						break;
					case 3:
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					default:
						throw new InputMismatchException();
					}
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
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.println("수정할 금액을 입력 : ");
		int usermoney=scan.nextInt();
		if (usermoney > 0 ) {
		System.out.println("수입 내역 수정을 이용해주세요.");
		return;
		}
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawMoney(bank, usermoney)) {
			System.out.println("수정 성공하였습니다.");
		}
		else
		System.out.println("수정에 실패하였습니다.");
		System.out.println(absi.getBankList());
		
	}

	private void updateWithdrawCategori() {
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.println("[병원비,식비,교통비,유흥비,보험료,기타]");
		System.out.println("수정할 카테고리를 입력 : ");
		String category=scan.next();
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawCategori(bank, category)) {
			System.out.println("수정 성공하였습니다.");
		}
		else
		System.out.println("수정에 실패하였습니다.");
		absi.printWithdraw();
	}
	
	private void updateWithdrawuage() {
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.println("수정할 상세내역 입력 : ");
		scan.nextLine();
		String usage=scan.nextLine();
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawCategori(bank, usage)) {
			System.out.println("수정 성공하였습니다.");
		}
		else
		System.out.println("수정에 실패하였습니다.");
		absi.printWithdraw();
	}
	
	private void updateWithdrawDate() {
		absi.printWithdraw();
		System.out.print("수정할 번호를 입력 : ");
		int userId = scan.nextInt();
		System.out.println("수정할 날짜 입력 : ");
		scan.nextLine();
		String date=scan.nextLine();
		Bank bank=new Bank(userId);
		if(absi.updateWithdrawDate(bank, date))
			System.out.println("수정 성공하였습니다.");
		else
			System.out.println("수정에 실패하였습니다.");
		System.out.println();
		absi.printWithdraw();
	}

	private void deleteWithdraw() {
		absi.printWithdraw();
		System.out.print("삭제할 id를 입력 : ");
		int userId = scan.nextInt();
		Bank bank = new Bank(userId);
		absi.deleteWithdraw(bank,userId);
		absi.printWithdraw();
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
