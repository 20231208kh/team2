package university;

import java.util.ArrayList;
import java.util.List;

//교수 클래스에서는 학생과 관련된 정보만 취급
public class Student {
	
	//과목 정보 저장할 list
	List<Lecture> lectureList = new ArrayList<Lecture>();
	//전공 다 받아오는 생성자(복수전공)
	List<Major> majorList = new ArrayList<Major>();
	
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
	
	//학생 학번 생성해주는 생성자
	public Student(String studentName, int year, int grade, Major major) {
		this.studentName = studentName;
		this.year = year;
		this.grade = grade;
		//여기에 학번 만드는거 계산
		//this.studentNum = 
	}
	
	
	//Student1 (이름, 학번, 학년, 나이 , 전공([전공1],[전공2]), 강의([강의1],[강의2] ))
	@Override
	public String toString() {
		return "[studenId]" + "[이름: " + studentName + " ]" + majorList;
	}
}
