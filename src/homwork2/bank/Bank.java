package homwork2.bank;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;


@Data
public class Bank implements Serializable {
	private static final long serialVersionUID = 5549820094779313605L;
	
	private String arr1[] = new String[]{"병원비","식비","교통비","유흥비","보험료","기타"}; //대분류(지출)
	private String arr2[] = new String[]{"급여","불로소득","실비","용돈","기타"}; //대분류(수입)
	private int money;
	private String usage; //상세 출처
	private String today;
	private String categori; //분류
	Date date = new Date();
	private int id;


	//추가를 위한 생성자
	public Bank(int user,int money, String usage) {
		super();
		if (money<0) {
			this.categori = arr1[user-1];
		}else {
			this.categori = arr2[user-1];
		}
		this.money = money;
		this.usage = usage;
		this.today = new SimpleDateFormat("yyyy/MM/dd").format(date);
	}
	
	//비교를 위한 생성자
	public Bank(int id) {
		super();
		this.id = id;
	}	
	
	
	
	
	
	
	@Override
	//toString
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###");
		if (money<0) {
			return "[번호 : "+id+"] [카테고리 : "+categori+"] [ 지출 금액 : "+df.format(Math.abs(money))+"] [상세 내역 : "+usage+", 날짜 : "+today+"]\n";
		}
		return "[번호 : "+id+"] [카테고리 : "+categori+"] [ 수입 금액 : "+df.format(money)+"] [상세 내역 : "+usage+", 날짜 : "+today+"]\n";
	}


	
	@Override
	//equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
  
	
}

