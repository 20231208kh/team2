package homwork2.bank;

import homwork2.bank.service.PrintService;
import homwork2.bank.service.PrintServiceImp;
import program.Program;

public class BankProgram implements Program{
	private PrintService printService= new PrintServiceImp();
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runMenu(int menu) {
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
