package homwork2.bank.service;


import java.io.Serializable;
import java.text.DecimalFormat;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import homwork2.bank.Bank;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountBookServiceImp implements AccountBookService , Serializable {
	private static final long serialVersionUID = 6760830936819586275L;
	private List<Bank> bankList = new ArrayList<Bank>();
	@Override
	// 수입 추가
	public boolean addDeposit(Bank bank) {
		if(bankList == null ) {
			List<Bank> bankList = new ArrayList<Bank>();
			bankList.add(bank);
			return true ;
		}
		bankList.add(bank);
		return true ;
	}

	//카테고리 입력받고 해당 카테고리와 일치하는 값이 입력된 리스트가 있다면 for문이로 걔들 출력
	@Override
	// 수입 내역 삭제
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
	// 수입 금액 수정
	public boolean updateDepositMoney(Bank bank, int money) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		if (bankList.contains(bank)) {
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
	// 지출 추가
	public boolean addWithdraw(Bank bank) {	
		if(bankList == null ) {
			List<Bank> bankList = new ArrayList<Bank>();
			bankList.add(bank);
			return true ;
		}
		bankList.add(bank);
		return true;
	}


	@Override
	// 지출 내역 삭제
	public boolean deleteWithdraw(Bank bank,int userid) {
		
		if(bankList==null||bankList.size()==0) {
			
			System.out.println("입력된 내역이 없습니다.");
			return false;
		}
		
		if(bankList.contains(bank))
		{			
			bankList.remove(userid);
			System.out.println("삭제 성공");
			return true;
		}
		
			return false;
		
	}





	@Override
	// 지출 금액 수정
	public boolean updateWithdrawMoney(Bank bank, int money) { //박석훈
		
		if (bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			bankList.get(index).setMoney(money);
			System.out.println(bankList.get(index));

			return true;
		}
		return false;
	}

	
	@Override
	// 수입 일자 수정
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
			sort(bankList);
			return true;
		}
		return false;
	}
	
	
	
	@Override
	// 수입 카테고리 수정
	public boolean updateDepositCategori(Bank bank, int user) {
		if(bankList == null || bankList.size() == 0) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		try {
				if(bankList.contains(bank)) {
					int index = bankList.indexOf(bank);
					if(bankList.get(index).getMoney()<0) {
						return false;
				}
				bankList.get(index).setCategori(bank.getArr2()[user-1]);
				return true;
				}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("잘못 선택한 카테고리입니다.");
			}
		return false;
	}
	
	@Override
	// 수입 상세내역 수정
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
	// 지출 카테고리 수정
	public boolean updateWithdrawCategori(Bank bank, int user) { //박석훈

		if (bankList.contains(bank)) {
			int index = bankList.indexOf(bank);
			
			if(bankList.get(index).getMoney()>0) {
				return false;
			}
			try {
				String categori = bankList.get(index).getArr1()[user-1];
				bankList.get(index).setCategori(categori);
				System.out.println(bankList.get(index));
				return true;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("잘못된 카테고리 입력");
			}
		}
		
		return false;
	}



	
	
	
	@Override
	// 지출 일자수정
	public boolean updateWithdrawDate(Bank bank, String date) {  //박석훈
		if(bankList.contains(bank)) {
			int index=bankList.indexOf(bank);
			if(bankList.get(index).getMoney()>0) {
				return false;
			}

			System.out.println(bankList.get(index));

			bankList.get(index).setToday(date);
			sort(bankList);
			return true;
		}
		return false;	
	}
	




	@Override
	//지출 상세내역 수정
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

  //수입내역 출력
	@Override
	public void printDeposit() {
		Stream<Bank> stream = bankList.stream();
		stream.filter(m->m.getMoney()>=0).forEach(m->System.out.print(m));
	}
  //지출내역 출력
  public void printWithdraw() {
		Stream<Bank> stream = bankList.stream();
		stream.filter(m->m.getMoney()<0).forEach(m->System.out.print(m));
	}
  
	@Override
	//리스트 정렬 - 날짜 수정시에만 추가해 줄것
	public void sort(List<Bank> tmpList) {
		tmpList.sort((l1,l2)-> l1.getToday().compareTo(l2.getToday()));
	}

	@Override
	public void listLoad(List<Bank> bankList) {
		this.bankList = bankList;
	}
	
	@Override
	public List<Bank> readList() {
		return bankList;
	}
	
}
	


