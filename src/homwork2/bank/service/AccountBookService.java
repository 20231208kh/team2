package homwork2.bank.service;

import java.util.List;

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
	boolean addWithdraw();
	
	//지출 내역 각종 수정(박석훈, 박성훈)
	boolean updateWithdrawMoney(Bank bank, int money);
	boolean updateWithdrawCategori(Bank bank, String categori);
	boolean updateWithdrawDate(Bank bank,String date);
	
	boolean deleteWithdraw(Bank bank);
	
	
	
	//전체 조회
	boolean searchAll(List<Bank> tmpBankList);
	//금액 조회
	boolean searchByMoney(int min, int max, List<Bank> tmpList);
	boolean searchByMoney(int min, List<Bank> tmpList);
	//분류 조회
	boolean serchByCategori(String categori, List<Bank> tmpBankList );
	boolean searchByUsage(String useage, List<Bank> tmpBankList );
	//일자 조회
	boolean searchByDate(String year, List<Bank> tmpBankList);
	boolean searchByDate(String year, String month , List<Bank> tmpBankList);
	boolean searchByDate(String year, String month , String day , List<Bank> tmpBankList);
	
	
	//수입, 지출 출력
	void printCome(List<Bank> tmpList);
	//정렬
	void sort(List<Bank> tmpList);

	
}
