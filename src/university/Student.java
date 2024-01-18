package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Student {
	
	List<Lecture> lectureList = new ArrayList<Lecture>();
	Major major ;
	
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentId, other.studentId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}
	
	public Student(String studentName,int grade, int year, Major major) {
		super();
		this.major = major;
		this.studentName = studentName;
		this.grade = grade;
		this.year = year;
		this.studentId = year+major.getMajorId();
	}
	@Override
	public String toString() {
		return "학번 : "+studentId+ " 이름 : "+studentName+" 학년 : "+grade+ " 전공 : "+major.getMajorName()+" 수강중인 강의 : "+lectureList;
	}
	
	
	
}
