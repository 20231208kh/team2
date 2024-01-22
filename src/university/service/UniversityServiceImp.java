package university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import university.Major;
import university.Student;

public class UniversityServiceImp implements UniversityService{
	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	
	//전공을 먼저 검색하고 학생을 찾는것이 아니기 때문에 studentMajor => Major로 변경하여 교수, 학생 등 다양하게 사용가능할 것 같음.
	@Override
	public boolean searchByMajor(Major majorName) {
		if(majorList == null) {
			System.out.println("등록된 전공이 없습니다.");
			return false;
		}
		if(majorList.contains(majorName)){
			Stream<Major> stream = majorList.stream();
			stream.forEach(m->System.out.print(m));
			return true;
		}
		return false;
	}
	
	//학번으로 학생 조회
	@Override
	public boolean searchByStudentId(Student studentId) {
		if(studentList == null) {
			System.out.println("등록된 학번이 없습니다.");
			return false;
		}
		if(studentList.contains(studentId)){
			Stream<Student> stream = studentList.stream();
			stream.forEach(m->System.out.print(m));
			return true;
		}
		return false;
	}
	
	//학생 이름으로 조회(등록된 동명이인 모두 출력. 앞에 번호 1 --- 2 --- 이런식으로 출력되게)
	@Override
	public boolean searchByStudentName(Student studentName) {
		if(studentList == null) {
			System.out.println("등록된 학생이 없습니다.");
			return false;
		}
		if(studentList.contains(studentName)){
			Stream<Student> stream = studentList.stream();
			stream.forEach(m->System.out.print(m));
			return true;
		}
		return false;
	}

	@Override
	public boolean addStudent() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean addMajor() {
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
	
}
