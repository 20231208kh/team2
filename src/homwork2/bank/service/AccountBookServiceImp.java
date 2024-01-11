package homwork2.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import homwork2.bank.Bank;
import lombok.Data;

@Data
public class AccountBookServiceImp implements AccountBookService {
	private List<Bank> bankList = new ArrayList<Bank>();
	private Bank bank = new Bank();

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
		}
		if(bankList.contains(bank)){
			int index = bankList.indexOf(bank);
			//banklist의 선택한 배열에 입력된 금액이 0보다작으면 return false;
			if(bankList.get(index).getMoney()<0) {
				return false;
			}
			bankList.remove(index);
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean updateDepositMoney(Bank bank, int money) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if(bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()<0) {
				return false;
			}
			bankList.get(index).setMoney(money);
			return true;
			}
		return false;
	}
	
	@Override
	public boolean updateDepositDate(Bank bank, String today) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if(bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()<0) {
				return false;
				}
			bankList.get(index).setToday(today);
			return true;
			}
		return false;
	}
	
	//수입내역 출력
	@Override
	public void printDeposit() {
		Stream<Bank> stream = bankList.stream();
		stream.filter(m->m.getMoney()>0).forEach(m->System.out.print(m));
	}
	
	@Override
	public boolean updateDepositCategori(Bank bank, int user) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if(bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()<0) {
				return false;
				}
			bankList.get(index).setCategori(bank.getArr2()[user-1]);
			return true;
			}
		return false;
	}
	
	@Override
	public boolean updateDepositUsage(Bank bank, String usage) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if(bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()<0) {
				return false;
				}
			bankList.get(index).setUsage(usage);
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
	public boolean moneyCheck(int money) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
