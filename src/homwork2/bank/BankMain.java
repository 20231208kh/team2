package homwork2.bank;


/*
	
		[파일]
		[지출 / 지출내역(어디다썼는지) / 날짜(등록된)]
		
		[1. 지출 금액수정]
		[2. 지출내역 수정]
		[3. 지출 날짜수정]
		[4. 지출 내역 삭제]
				
		[수입 / 수입출처(어디서 얻었는지)/ 날짜(등록된)]
		[1. 수입 금액수정]
		[2. 수입 출처수정]
		[3. 수입 날짜수정]
		[4. 수입 내역 삭제]
		
		[조회]
		[1. 출처별 조회]
		[2. 금액별 조회]
		[3. 날짜별 조회]
		[4. 전체 조회]
				
		[파일]
		[종료]
		*/


public class BankMain {

	public static void main(String[] args) {
		
		BankProgram bp = new BankProgram();
		bp.run();

	}

}

