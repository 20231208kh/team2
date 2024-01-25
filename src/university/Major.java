package university;

import java.util.Objects;


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
		return "전공번호 : "+majorId+" 전공 이름 : "+majorName+"\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Major other = (Major) obj;
		return Objects.equals(majorId, other.majorId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(majorId);
	}

	public Major(String majorId) {
		super();
		this.majorId = majorId;
	}



	
	

	
}
