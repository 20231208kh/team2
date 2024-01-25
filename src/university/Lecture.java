package university;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
@Data
public class Lecture {
	//등록교수 ID
	String professorID;
	//과목명
	String lectureName;
	//현인원
	int lectureCount;
	//정원
	int lectureMaxCount; // 최대 수강인원 설정
	//강의 요일
	String lectureDay; // 월~금 선택
	//강의 시작 시간
	int lectureST;	// 1 ~ 7교시 시작
	//교시 수
	int lectureLT; // 1~3 강의 지속(1< lectureST + lectureLT < 9)
	//점수
	int lectureScore; // 학생인스턴스의 과목리스트에 넣을 점수
	
	// 강의 등록 생성자
	public Lecture(String professorID,String lectureName, int lectureMaxCount, String lectureDay, int lectureST, int lectureLT) {
		this.professorID = professorID;
		this.lectureName = lectureName;
		this.lectureMaxCount = lectureMaxCount;
		this.lectureDay = lectureDay;
		this.lectureST = lectureST;
		this.lectureLT = lectureLT;
		lectureCount = 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecture other = (Lecture) obj;
		return Objects.equals(lectureDay, other.lectureDay) && lectureST == other.lectureST
				&& Objects.equals(professorID, other.professorID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lectureDay, lectureST, professorID);
	}

	@Override
	public String toString() {
		return  lectureName +  " / " + lectureDay + "요일 / 강의 시작 " + lectureST + "교시, 종료 "
				+ (lectureLT+lectureST-1) + "교시, "+ lectureLT +"H (" + lectureCount + " / " + lectureMaxCount +")";
	}


	

	
	

	
}
