package homwork2.bank.service;

import java.util.ArrayList;
import java.util.List;

import homwork2.bank.Bank;
import lombok.Data;

@Data

public class AccountBookServiceImp implements AccountBookService {

	private List<Bank> bankList = new ArrayList<Bank>();
	
	
	
	
	
	@Override
	public boolean addDeposit(Bank bank) {
		bankList.add(bank);
		System.out.println(bankList);
		return true;
	}

	
	public boolean updateDepositMoney(Bank bank, int money) {

		if (bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			bankList.get(index).setMoney(money);
			return true;
		}
		
		
		return false;
		
	}


	@Override
	public boolean deleteDeposit(Bank bank) {
		if (bankList.contains(bank)) {
			bankList.remove(bank);
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean addWithdraw() {
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
	public boolean updateDepositCategori(Bank bank, String categori) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateDepositDate(Bank bank, String date) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateWithdrawMoney(Bank bank, int money) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateWithdrawCategori(Bank bank, String categori) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateWithdrawDate(Bank bank, String date) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
