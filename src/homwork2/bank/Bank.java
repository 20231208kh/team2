package homwork2.bank;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Bank {
	int money;
	String usage;
	String today;
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###");
			return "금액 : " + df.format(Math.abs(money)) + "원 / 출처 : " + usage + " / 날짜 : " + today +"\n";
	}
	
	// 생성자
	public Bank(int money, String usage) {
		this.money = money;
		this.usage = usage;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		this.today = format.format(new Date());
	}
	
	
}
