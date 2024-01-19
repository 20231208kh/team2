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
	
	//전공 사무실(행정실), 학과장, 대표번호 등
	
	@Override
	public String toString() {
		return "전공번호 : "+majorId+" 전공 이름 : "+majorName;
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
		return Objects.equals(majorId, other.majorId) && Objects.equals(majorName, other.majorName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(majorId, majorName);
	}

	
	
	
}
