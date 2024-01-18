package university;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Major {
	
	//전공명
	String majorName;
	//전공번호
	String majorId;
	@Override
	public String toString() {
		return "전공번호 : "+majorId+" 전공 이름 : "+majorName;
	}

	
	
	
}
