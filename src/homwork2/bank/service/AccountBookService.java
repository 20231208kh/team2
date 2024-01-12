package homwork2.bank.service;


import java.util.List;
import homwork2.bank.Bank;

public interface AccountBookService {

	

	//가계부 수입 관리 : (김태원, 박성훈)
	boolean addDeposit(Bank bank);
	
	
	//수입 내역 각종 수정 : (김태원, 박성훈)
	boolean updateDepositMoney(Bank bank, int money);
	boolean updateDepositDate(Bank bank, String today);
	boolean updateDepositCategori(Bank bank, int user);
	boolean updateDepositUsage(Bank bank, String usage);
	
	//수입 내역 삭제 : (김태원, 박성훈)
	boolean deleteDeposit(Bank bank);
	
	//지출 내역 추가 : (박석훈, 박성훈)
	boolean addWithdraw(Bank bank);
	
	//지출내역 삭제 : (박석훈, 박성훈)
	boolean deleteWithdraw(Bank bank, int userid);
	
	//지출 내역 각종 수정 : (박석훈, 박성훈)
	boolean updateWithdrawMoney(Bank bank, int money);
	boolean updateWithdrawCategori(Bank bank, int user);  //카테고리 수정
	boolean updateWithdrawDate(Bank bank,String date);  //날짜 수정
	boolean updateWithdrawUsage(Bank bank, String usage); //상세내역 수정 

	
	//전체 조회 : 김준수
	boolean searchAll(List<Bank> tmpBankList);
	//금액 조회 : 김준수
	boolean searchByMoney(int min, int max, List<Bank> tmpList);
	boolean searchByMoney(int min, List<Bank> tmpList);
	//분류 조회 : 김준수
	boolean serchByCategori(String categori, List<Bank> tmpBankList );
	boolean searchByUsage(String useage, List<Bank> tmpBankList );
	//일자 조회 : 김준수
	boolean searchByDate(String year, List<Bank> tmpBankList);
	boolean searchByDate(String year, String month , List<Bank> tmpBankList);
	boolean searchByDate(String year, String month , String day , List<Bank> tmpBankList);


	
	
	//출력
	//수입 출력 : 박성훈
	void printDeposit();
	//지출 출력 : 박성훈
	void printWithdraw();
	//수입, 지출 그룹 출력 : 김준수
	void printGroup(List<Bank> tmpList);
	//수입, 지출 그룹 상세출력 : 김준수
	void printDetail(List<Bank> tmpList);
	
	//정렬 : 김준수
	void sort(List<Bank> tmpList);
	
	//파일 수신 : 김준수
	void fileLoad(AccountBookServiceImp abis); 

}
