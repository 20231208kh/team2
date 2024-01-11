package homwork2.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
	public boolean addWithdraw(Bank bank) {	
		bankList.add(bank);
		return true;
	}


	@Override
	public boolean deleteWithdraw(Bank bank,int userid) {
		
		if(bankList==null||bankList.size()==0) {
			
			System.out.println("입력된 내역이 없습니다.");
			return false;
		}
		
		if(bankList.contains(bank))
		{			
			bankList.remove(userid);
			return true;
		}
		
			return false;
		
	}

	@Override
	public boolean searchByDate() {

		return false;
	}

	@Override
	public boolean searchByUsage() {
		
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
			
		return false;
	}


	@Override
	public boolean updateDepositDate(Bank bank, String date) { 
		return false;
	}


	public void printWithdraw() {
		Stream<Bank> stream = bankList.stream();
		stream.filter(m->m.getMoney()<0).forEach(m->System.out.print(m));
	}
	
	
	@Override
	public boolean updateWithdrawMoney(Bank bank, int money) { //박석훈
		
		if (bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			bankList.get(index).setMoney(money);
			return true;
		}
		
		
		return false;
		
	}


	@Override
	public boolean updateWithdrawCategori(Bank bank, String categori) { //박석훈

		if (bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			bankList.get(index).setCategori(categori);
			return true;
		}
		
		return false;
	}

	public boolean updateWithdrawUsage(Bank bank, String usage) {
		
		if(bankList.contains(bank))
		{
			int index=bankList.indexOf(bank);
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			bankList.get(index).setUsage(usage);
			return true;
		}
			return false;	
	}
	
	@Override
	public boolean updateWithdrawDate(Bank bank, String date) {  //박석훈
		if(bankList.contains(bank))
		{
			int index=bankList.indexOf(bank);
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			bankList.get(index).setToday(date);
			return true;
		}
			return false;	
	}
	

}

	
	

