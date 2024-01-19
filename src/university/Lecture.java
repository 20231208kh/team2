package university;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Lecture {
	//과목명
	String lectureName;
	//과목식별번호
	int lectureId; // 연도 + 학기 + 전공 + 카운트
	//현인원
	int lectureCount;
	//정원
	int lectureMaxCount; // 최대 수강인원 설정
	//강의 요일
	String lectureDay; // 월~금 선택
	//강의 시작 시간
	int lectureST;	// 1 ~ 7교시
	//교시 수
	int lectureLT; // 1~3
	//점수
	int lectureScore; // 학생인스턴스의 과목리스트에 넣을 점수
	
}
