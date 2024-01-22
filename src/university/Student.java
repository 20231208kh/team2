package university;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	List<Lecture> lectureList = new ArrayList<Lecture>();
	Major major = new Major();
	
	//학생 이름
	String studentName;
	//학번
	String studentId;
	//학년
	int grade;
	//입학년도
	int year;
	//점수
	int avgScore;
	
}