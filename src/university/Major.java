package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Major {
	
	//전공명
	String majorName;
	//전공번호
	String majorId;
	//현재 인원
	int majorCount;
	
	public Major() {
		
	}
	
	public Major(String majorName, String majorId) {
		this.majorName = majorName;
		this.majorId = majorId;
	}
	
	public Major(String majorName) {
		this.majorName = majorName;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(majorName);
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
		return Objects.equals(majorName, other.majorName);
	}

	@Override
	public String toString() {
		return "[전공번호 : " + majorId + " ] " + "[전공명 : " + majorName + " ] " + "[현재인원 : " + majorCount + " ] ";
	} 
	
	//현재 인원만(특정 정보만) 뽑고싶을때(indexOf사용시)
	public boolean printMajorCount() {
		if(majorCount == 0) {
			System.out.println("0명입니다.");
			return false;
		}
		System.out.print("[현재인원 : " + majorCount + " ] ");
		return true;
	}
	
}
