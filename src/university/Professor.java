package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Professor {
	
	//교수 이름
	String professorName;
	//교수 번호
	String professorId;
	//교수님 전공
	String professorMajor;
	//소속 학과가 필요함
	
	//과목 정보
	List<Lecture> lectureList = new ArrayList<Lecture>();

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


	//equals를 위한 생성자
	public Professor(String professorName, String professorId, String professorMajor) {
		super();
		this.professorName=professorName;
		this.professorId = professorId;
		this.professorMajor=professorMajor;
	}



	public Professor(String professorId) {
		super();
		this.professorId = professorId;
	}



	@Override
	public String toString() {
		
		return "교수 [ 교수 이름 : " + professorName + ", 교수 번호 : " + professorId + ", 교수 전공 : "
				+ professorMajor + ", 교수 강의 : " + lectureList + "] \n";
	}
	
	
}