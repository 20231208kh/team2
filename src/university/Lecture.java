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
	//강의 요일 string
	
	//강의 시작시간
	
	//수업시간
	
	//같은 교수 id 같은 요일 같은 시작 시간 => 같은 강의다.
	
	@Override
	public String toString() {
		return "[강의번호 : " + lectureId + " ] " + "[강의명 : " + lectureName + " ] " + "[점수 : " + lectureScore + " ] ";
	}
	
	
}
