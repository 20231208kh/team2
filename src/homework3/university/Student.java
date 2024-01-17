package homework3.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;



public class Student {

	private int studNum; //학번

	private int age; 	//나이

	private String name; //이름
	
	List<Lecture> lecture=new ArrayList<Lecture>(); //강의 리스트
	
	List<Major> major=new ArrayList<Major>(); //전공 리스트
	
	


}
