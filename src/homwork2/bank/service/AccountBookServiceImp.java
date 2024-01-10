package homwork2.bank.service;

import java.util.ArrayList;
import java.util.List;

import homwork2.bank.Bank;
import lombok.Data;
@Data
public class AccountBookServiceImp implements AccountBookService {
	private List<Bank> bankList = new ArrayList<Bank>();
	private Bank bank = new Bank();
	
	public void printList() {
		for(int i = 0; i<bankList.size(); i++) {
			System.out.println(bankList.get(i));
		}
	}
	
	@Override
	public boolean addDeposit(Bank bank) {
			bankList.add(bank);
			return true ;
	}
		
	//카테고리 입력받고 해당 카테고리와 일치하는 값이 입력된 리스트가 있다면 for문이로 걔들 출력
	@Override
	public boolean deleteDeposit(Bank bank) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			int index = bankList.indexOf(bank);
			bankList.remove(index);
			return true;
		}
	}
	
	/*
	public boolean printCategori(int categori) {
		if(bankList == null) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} 
		//정수값을 입력받고 그게 banklist의 arr1의 index
		if(bankList.contains(categori)) {
			for(int i = 0; i < bankList.size(); i++) {
			int index = bankList.indexOf(categori);
			System.out.println(bankList.get(index));
			}
			return true;
		}
		return false;
	}
	*/
	
	@Override
	public boolean setDeposit(Bank bank) {
		if(bankList == null) {
			System.out.println("등록된 내역이 없습니다.");
		}
		return false;
	}
	
	public boolean updateDepositMoney(Bank bank, int money) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			if(bankList.contains(bank)) {
				int index = bankList.indexOf(bank);
				bankList.get(index).setMoney(money);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateDepositDate(Bank bank, int money) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			if(bankList.contains(bank)) {
				int index = bankList.indexOf(bank);
				bankList.get(index).setDate(null);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateDepositCategori(Bank bank, String categori, String usage) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			if(bankList.contains(bank)) {
				int index = bankList.indexOf(bank);
				bankList.get(index).setCategori(categori);
				bankList.get(index).setUsage(usage);
				return true;
				
			}
		}
		return false;
	}
	
	public boolean updateDepositUsage(Bank bank, String usage) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			if(bankList.contains(bank)) {
				int index = bankList.indexOf(bank);
				bankList.get(index).setUsage(usage);
				return true;
			}
		}
		return false;
	}
	
	

	@Override
	public boolean addWithdraw() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setWithdraw() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWithdraw() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByDate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByUsage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByMoney() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean printCategori(Bank id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
