package homwork2.bank.service;

import java.util.List;

import homwork2.bank.Bank;
import lombok.Data;

@Data
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
	// min ~ max 사이 조회, min이 0이면 자동으로 max 이하, max가 없으면 자동으로 min 이상으로 조회됨
	// 메뉴 1. 최대 최소(min max 입력) 2. 최소(max 제외)  3. 최대(min = 0)
	public boolean searchByMoney(int min, int max, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
				.filter(b-> min <= Math.abs(b.getMoney()) && max >= Math.abs(b.getMoney()))
				.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("해당하는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	// min 이상 조회
	public boolean searchByMoney(int min, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
				.filter(b-> min <= Math.abs(b.getMoney()))
				.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}

	@Override
	public boolean searchAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//수입 지출 구분 출력
	public void printCome(List<Bank> tmpList) {
		if(tmpList == null || tmpList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return;
		}
		if(tmpList.stream().filter(l->l.getMoney()>=0).count() != 0) {
			System.out.println("수입 내역");
			tmpList.stream().filter(l->l.getMoney()>=0).forEach(i->System.out.print(i));
			System.out.println("---------");
		}
		if(tmpList.stream().filter(l->l.getMoney()<0).count() != 0) {
			System.out.println("지출 내역");
			tmpList.stream().filter(l->l.getMoney()<0).forEach(i->System.out.print(i));
			System.out.println("---------");
		}
	}

	@Override
	//리스트 정렬
	public void sort(List<Bank> tmpList) {
		tmpList.sort((l1,l2)-> l1.getToday().compareTo(l2.getToday()));
	}
	
	
}
