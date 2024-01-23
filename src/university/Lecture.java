package university;

import java.util.Objects;

import lombok.Data;

@Data
public class Lecture {
	
	
	//과목명
	String lectureName;
	//과목식별번호
	int lectureId;
	//현인원
	int lectureCount;
	//정원
	int lectureMaxCount;
	//점수
	int lectureScore;
	
	
	
	
	@Override
	public String toString() {
		return "교수 강의 정보 [ 강의 이름 : " + lectureName + ", 강의 번호 : " + lectureId + ", 강의 현인원 : " + lectureCount
				+ ", 강의 최대정원 : " + lectureMaxCount + ", 점수 : " + lectureScore + "]";
	}


	
	public Lecture(String lectureName, int lectureId) {
		super();
		this.lectureName = lectureName;
		this.lectureId = lectureId;
	}



	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecture other = (Lecture) obj;
		return lectureId == other.lectureId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lectureId);
	}
	
	
	
}