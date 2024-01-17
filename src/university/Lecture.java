package university;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Lecture {
	
	//과목명
	String lectureName;
	//과목식별번호
	int lectureNum;
	//학점
	int lectureGrade;
	//현인원
	int lectureCount;
	//정원
	int lectureMaxCount;
	//점수
	int lectureScore;
	//강의 시간
	
	@Override
	public String toString() {
		return "[lectureNum]" + "[과목명: " + lectureName + " ]" + "[정원: " + "lectureCount" + "/" + lectureMaxCount + " ]";
	}

}
