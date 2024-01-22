package university;

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
		return "[강의번호 : " + lectureId + " ] " + "[강의명 : " + lectureName + " ] " + "[점수 : " + lectureScore + " ] ";
	}
	
	
}
