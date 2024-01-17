package homework3.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor {
	
	private int id; //교수 고유 번호
	private int age;	//교수 나이
	private String name; //교수 이름
	
//	입학년도 + 과코드 + 2자리
//	특별한숫자 + 과코드 + 2자리 
	
	List<Lecture> lecture=new ArrayList<Lecture>();
	
	//(강의1, 강의1 정원현황(0/20)) (전공) 
	

	@Override
	public int hashCode() {	
		return Objects.hash(id);
	}


	

	@Override
	public String toString() {
		return "[교수번호 = " + id + " , 나이 = " + age + " , 이름 = " + name + " , 강의 " + lecture + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return id == other.id;
	}


	public Professor(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
}