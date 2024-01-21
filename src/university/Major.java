package university;

import java.util.Objects;

public class Major {
	
	//전공명
	String majorName;
	//전공번호
	int majorId;
	//현재 인원
	int majorCount;
	
	//의문점.
	//전공 찾아서 뭐할건데?...
	
	@Override
	public int hashCode() {
		return Objects.hash(majorId, majorName);
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
		return majorId == other.majorId && Objects.equals(majorName, other.majorName);
	}
	
	@Override
	public String toString() {
		return "[전공번호 : " + majorId + " ] " + "[전공명 : " + majorName + " ] " + "[현재인원 : " + majorCount + " ] ";
	} 
	
}
