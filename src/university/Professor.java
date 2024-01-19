package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Professor {
	
	//성함
	String professorName;
	//교수 번호
	String professorId;
	//교수님 전공
	String professorMajor;
	//소속 학과가 필요함
	
	//과목 정보
	List<Lecture> lectureList = new ArrayList<Lecture>();

	@Override
	public int hashCode() {
		return Objects.hash(professorId, professorMajor, professorName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(professorId, other.professorId) && Objects.equals(professorMajor, other.professorMajor)
				&& Objects.equals(professorName, other.professorName);
	}
	
	public void Professor(String professorName, String professorId, String professorMajor) {
		
	}
	
}
