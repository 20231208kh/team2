package homwork2.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bank {
	
	
	private String arr1[] = new String[]{"병원비","식비","교통비","유흥비","보험료","기타"}; //대분류(지출)
	private String arr2[] = new String[]{"급여","불로소득","실비","용돈","기타"}; //대분류(수입)
	private int money;
	private String usage; //상세
	private String today;
	private String categori; //뽑아올거
	Date date = new Date();
	private int id;
	//toString 메서드 오버라이딩
	@Override
	public String toString() {
		
		return id+"//"+categori+"//"+money+"//"+usage+"//"+today;
		
//		if (money<0) {
//			return "[지출 금액 : "+Math.abs(money)+"] [지출 용도 : "+usage+", 날짜 : "+today+"]\n";
//		}
//			return"[수입 : " + money +"] [ 지출용도 : "+usage+", 날짜 : "+today+"]\n";
	}


	public Bank(int id,int user,int money, String usage) {
		super();
		
		this.id = id;
		if (money<0) {
			this.categori = arr1[user-1];
		}else {
			this.categori = arr2[user-1];
		}
		
		this.money = money;
		this.usage = usage;
		this.today = new SimpleDateFormat("yyyy/MM/dd").format(date);
	}


	public Bank(int id) {
		super();
		this.id = id;
	}
	
	
	

	
}
