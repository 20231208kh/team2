package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

public class Professor {
	
	//성함
	String professorName;
	//교수 번호
	String professorId;
	//교수님 전공
	String professorMajor;
	//과목 정보
	List<Lecture> lectureList = new ArrayList<Lecture>();
	
}
