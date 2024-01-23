package university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import university.Major;
import university.Student;

public class UniversityServiceImp implements UniversityService{
	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	
	//전공 조회
	@Override
	public boolean searchByMajor(Major majorName) {
		if(majorList == null) {
			System.out.println("등록된 전공이 없습니다.");
			return false;
		}
		int index = majorList.indexOf(majorName);
		if(index == -1) {
			System.out.println("일치하는 전공이 없습니다.");
			return false;
		}
		System.out.print(majorList.get(index));
		return true;
	}
	/*
	//indexOf
	int index = majorList.indexOf(majorName);
	System.out.print(majorList.get(index).printMajorCount()); 
	
	if(majorList.contains(majorName)){
		Stream<Major> stream = majorList.stream();
		//filter(majorName)
		stream.filter(m->m.equals(majorName)).forEach(m->System.out.print(m));
		return true;
	}
	*/
	
	//학번이랑 이름 받아서 학생 조회(1명)
	@Override
	public boolean searchStudent(Student student) {
		if(studentList == null) {
			System.out.println("등록된 학번이 없습니다.");
			return false;
		}
		int index = studentList.indexOf(student);
		if(index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return false;
		}
		System.out.print(studentList.get(index));
		return true;
	}
	
	//학생 이름으로 조회(등록된 동명이인 모두 출력. 앞에 번호 1 --- 2 --- 이런식으로 출력되게)
	@Override
	public boolean searchByStudentName(Student student) {
		if(studentList == null) {
			System.out.println("등록된 학생이 없습니다.");
			return false;
		}
		int index = studentList.indexOf(student);
		if(index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return false;
		}
		System.out.print(studentList.get(index));
		return true;
	}
	
	//성적 출력
	@Override
	public boolean printScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudent(Student student) {
		if(studentList.contains(student)) {
			return false;
		}
		studentList.add(student);
		return true;
	}

	@Override
	public boolean updateStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean UpdateMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByProfessorMajor() {
		// TODO Auto-generated method stub
		return false;
	}

		@Override
	public boolean insertScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMajor(Major major) {
		if(majorList.contains(major)) {
			return false;
		}
		majorList.add(major);
		return true;
	}

}
