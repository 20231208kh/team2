package homwork2.bank.service;

import homwork2.bank.Bank;


public interface AccountBookService {

	
	
	//가계부 수입 관리 : (김태원, 박성훈)
	boolean addDeposit(Bank bank);
	
	//수입 내역 삭제
	boolean deleteDeposit(Bank bank);
	
	//수입 내역 각종수정 (김태원, 박성훈)
	boolean updateDepositMoney(Bank bank, int money);
	boolean updateDepositCategori(Bank bank, String categori);
	boolean updateDepositDate(Bank bank, String date);
	
	//가계부 지출 관리 : (박석훈, 박성훈)
	
	//지출 내역 추가
	boolean addWithdraw(Bank bank);
	
	//지출내역 삭제
	boolean deleteWithdraw(Bank bank, int userid);
	
	//지출 내역 각종 수정(박석훈, 박성훈)
	boolean updateWithdrawMoney(Bank bank, int money);
	
	
	boolean updateWithdrawCategori(Bank bank, int user);  //카테고리 수정
	boolean updateWithdrawDate(Bank bank,String date);  //날짜 수정
	boolean updateWithdrawUsage(Bank bank, String usage); //상세내역 수정 
	
	//가계부 조회 관리 : 김준수
	boolean searchByDate();
	//출처별 조회
	//지출 용도
	//수입 출처
	boolean searchByUsage();
	//1000원이하 지출
	//1000원이상 10000원이하 지출
	//10000이상 지출
	boolean searchByMoney();

	//전체 조회
	boolean searchAll();

	void printWithdraw();

	
	
	
	//추가기능?
	//1. 빈도수가 가장 많은 지출 용도
	//2. 
	
}
