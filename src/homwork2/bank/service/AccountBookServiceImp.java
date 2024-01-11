package homwork2.bank.service;


import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

import homwork2.bank.Bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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

	public boolean deleteDeposit(Bank bank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepositMoney(Bank bank, int money) {
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


	@Override
	public boolean deleteWithdraw(Bank bank) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addWithdraw() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	// 전체조회
	public boolean searchAll(List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream().forEach(b->tmpBankList.add(b));
		return true;
	}

	@Override
	// 금액 조회
	// 최소 ~ 최대 금액 조회
	public boolean searchByMoney(int min, int max, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
				.filter(b-> min <= Math.abs(b.getMoney()) 
						&& max >= Math.abs(b.getMoney()))
				.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	@Override
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
	// 일자별 조회
	// 연 내역 조회
	public boolean searchByDate(String year, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
		.filter(b->b.getToday().substring(0, 4).equals(year))
		.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	
	@Override
	// 월 내역 조회
	public boolean searchByDate(String year, String month, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
				.filter(b-> b.getToday().substring(0, 4).equals(year) 
						&& b.getToday().substring(5, 7).equals(month))
				.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	
	@Override
	// 일 내역 조회
	public boolean searchByDate(String year, String month, String day, List<Bank> tmpBankList) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream()
				.filter(b-> b.getToday().substring(0, 4).equals(year) 
						&& b.getToday().substring(5, 7).equals(month) 
						&& b.getToday().substring(8).equals(day))
				.forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	
	
	@Override
	// 카테고리별 조회
	public boolean serchByCategori(String categori, List<Bank> tmpBankList ) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream().filter(b->b.getCategori().equals(categori)).forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}
	@Override
	// 상세내역별 조회
	public boolean searchByUsage(String useage, List<Bank> tmpBankList ) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("가계부가 없습니다.");
			return false;
		}
		bankList.stream().filter(b->b.getUsage().equals(useage)).forEach(l->tmpBankList.add(l));
		if(tmpBankList == null || tmpBankList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return false;
		}
		return true;
	}

	
	

	@Override
	//입력받은 리스트에 수입, 지출이 있는지 파악하고 있다면 각각 구분하여 각 내역과 합계 출력
	public void printDetail(List<Bank> tmpList) {
		if(tmpList == null || tmpList.size() == 0) {
			System.out.println("조건에 맞는 기록이 없습니다.");
			return;
		}
		DecimalFormat df = new DecimalFormat("###,###");
		int sumDeposit = 0;
		int sumWithdraw = 0;
		if(tmpList.stream().filter(l->l.getMoney()>=0).count() != 0) {
			System.out.println("수입 내역");
			tmpList.stream().filter(l->l.getMoney()>=0).forEach(i->System.out.print(i));
			System.out.println("---------");
			List<Bank> sum = new ArrayList<Bank>();
			tmpList.stream().filter(l->l.getMoney()>=0).forEach(i-> sum.add(i));
			for(Bank i: sum) {sumDeposit += i.getMoney();}
			System.out.println("수입 합계 : " + df.format(sumDeposit) + "원");
		}
		if(tmpList.stream().filter(l->l.getMoney()<0).count() != 0) {
			System.out.println("지출 내역");
			tmpList.stream().filter(l->l.getMoney()<0).forEach(i->System.out.print(i));
			System.out.println("---------");
			List<Bank> sum = new ArrayList<Bank>();
			tmpList.stream().filter(l->l.getMoney()<0).forEach(i-> sum.add(i));
			for(Bank i: sum) {sumWithdraw += i.getMoney();}
			System.out.println("지출 합계 : " + df.format(Math.abs(sumWithdraw)) + "원");
		}
		if(sumDeposit != 0 && sumWithdraw != 0) {
			System.out.println("수입,지출 합계 : " + df.format(sumDeposit + sumWithdraw) + "원");
		}
	}
	
	@Override
	// 금액조회 출력
	public void printGroup(List<Bank> tmpList) {
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
	//리스트 정렬 - 날짜 수정시에만 추가해 줄것
	public void sort(List<Bank> tmpList) {
		tmpList.sort((l1,l2)-> l1.getToday().compareTo(l2.getToday()));
	}


	

	

	
}
