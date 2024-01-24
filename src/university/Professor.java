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
	String professorId; // 포탈 ID
	//교수 소속학과
	Major porfessorBTM; // 등록 학과 중 하나를 가져온다 (아직 생성자에 추가 전)
	//교수 전공
	String professorMajor;
	//과목 정보
	List<Lecture> lectureList = new ArrayList<Lecture>();
	
	
	public Professor(String professorName, String professorId, String professorMajor) {
		this.professorName = professorName;
		this.professorId = professorId;
		this.professorMajor = professorMajor;
	}

	public Professor(String professorId) {
		this.professorId = professorId;
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
		return Objects.equals(professorId, other.professorId);
	}


	@Override
	public int hashCode() {
		return Objects.hash(professorId);
	}


	
	
	
	
}
