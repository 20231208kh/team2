package homwork2.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;




@Data

public class Bank {

	int money;
	String usage;
	Date date = new Date();
	String today;
	
	
	//toString 메서드 오버라이딩
	@Override
	public String toString() {
		
		if (money<0) {
			return "[지출 금액 : "+Math.abs(money)+"] [지출 용도 : "+usage+", 날짜 : "+today+"]\n";
		}
			return"[수입 : " + money +"] [ 지출용도 : "+usage+", 날짜 : "+today+"]\n";
	}


	public Bank(int money, String usage) {
		super();
		this.money = money;
		this.usage = usage;
		this.today = new SimpleDateFormat("yyyy/MM/dd").format(date);
	}
	
	
}
