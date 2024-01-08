package homwork2.bank.service;

import java.util.List;

import homwork2.bank.Bank;

public class AccountBookServiceImp implements AccountBookService {

	private List<Bank> bankList;
	
	
	
	@Override
	public boolean addDeposit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDeposit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDeposit() {
		// TODO Auto-generated method stub
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
	public boolean searchByMoney(int min, int max) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("");
			return false;
		}
		bankList.stream()
				.filter(b-> min<=Math.abs(b.getMoney()) && max >= Math.abs(b.getMoney()))
				.forEach(l->System.out.print(l));
		return true;
	}
	
	public boolean searchByMoney(int min) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("");
			return false;
		}
		bankList.stream()
				.filter(b-> min<=Math.abs(b.getMoney()))
				.forEach(l->System.out.print(l));
		return true;
	}
	
	public boolean searchByMoney(int max, String m) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("");
			return false;
		}
		bankList.stream()
				.filter(b->  max >= Math.abs(b.getMoney()))
				.forEach(l->System.out.print(l));
		return true;
	}

	@Override
	public boolean searchAll() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
