package homwork2.bank.service;

import java.util.ArrayList;
import java.util.List;

import homwork2.bank.Bank;

public class AccountBookServiceImp implements AccountBookService {

	private List<Bank> bankList = new ArrayList<Bank>();
	
	@Override
	public boolean addDeposit(Bank bank) {
			bankList.add(bank);
			return true ;
	}
		
	
	@Override
	public boolean setDeposit() {
		if(bankList == null) {
			System.out.println("등록된 내역이 없습니다.");
		}
		return false;
	}
	//카테고리 입력받고 해당 카테고리와 일치하는 값이 입력된 리스트가 있다면 for문이로 걔들 출력
	
	
	@Override
	public boolean deleteDeposit(Bank bank) {
		if(bankList == null) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if(bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			bankList.remove(index);
			//bankList.remove();
			System.out.println("삭제 되었습니다.");
			return true;
		}
		return false;
	}
	
	public boolean printCategori(Bank bank) {
		if(bankList == null) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		} else {
			if(bankList.contains(bank)) {
				int index = bankList.indexOf(bank);
				System.out.println(bankList.get(index));
			}
			return true;
		}
	}
	
	public boolean updateDepositMoney() {
		return true;
		/*id 가 contains 없는경우 << false
		money < 0 << false (출력 : 지출 수정을 이용해주세요)
		bankList == null < false
		*/
	}
	
	public boolean updateDepositDate() {
		return false;
	}
	public boolean updateDepositCategori() {
		return false;
	}
	public boolean updateDepositUsage() {
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

	
	
}
