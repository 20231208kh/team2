package homwork2.bank.service;

import java.util.List;

import homwork2.bank.Bank;

public interface AccountBookService {

	
	//회원가입 : 김준수, 박성훈
	
	//가계부 수입 관리 : 김태원
	boolean addDeposit();
	//수정
	//날짜+용도
	//1. 금액
	//2. 날짜
	//3. 용도/출처 
	boolean setDeposit();
	boolean deleteDeposit();
	
	//가계부 지출 관리 : 김태원
	boolean addWithdraw();
	boolean setWithdraw();
	boolean deleteWithdraw();
	
	//가계부 조회 관리 : 박석훈
	boolean searchByDate();
	//출처별 조회
	//지출 용도
	//수입 출처
	boolean searchByUsage();
	//1000원이하 지출
	//1000원이상 10000원이하 지출
	//10000이상 지출
	boolean searchByMoney(int min, int max, List<Bank> tmpList);
	
	//전체 조회
	boolean searchAll();
	
	
	//수입, 지출 출력
	void printCome(List<Bank> tmpList);
	//정렬
	void sort(List<Bank> tmpList);
	
}
