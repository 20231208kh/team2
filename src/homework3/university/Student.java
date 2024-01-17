package homework3.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;


@Data
public class Student {
	@NonNull
	private int studNum; //학번
	@NonNull
	private int age; 	//나이
	@NonNull
	private String name; //이름
	
	List<Lecture> lecture=new ArrayList<Lecture>(); //강의 리스트
	
	List<Major> departlist=new ArrayList<Major>();
	
	
	

	

	@Override
	public String toString() {
		return "학생 [ 학번 = " + studNum + ", 나이 = " + age + ", 이름 = " + name + ", [ 강의 = " + lecture + " ] "+ " 학과 = " ;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studNum == other.studNum;
	}


	@Override
	public int hashCode() {
		return Objects.hash(studNum);  //학번 
	}


	public Student(int studNum, int age, String name) {	//학번,나이,이름 입력 받으면 집어넣을 생성자
		super();
		this.studNum = studNum;
		this.age = age;
		this.name = name;
	}	
	
}
