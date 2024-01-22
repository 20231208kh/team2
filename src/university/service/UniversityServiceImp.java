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
		if(majorList == null || majorList.size() < 0) {
			System.out.println("등록된 전공이 없습니다.");
			return false;
		}
		int index = majorList.indexOf(majorName);
		if(majorList.size() < 0) {
		System.out.print(majorList.get(index));
		
//		//indexOf
//		int index = majorList.indexOf(majorName);
//		System.out.print(majorList.get(index).printMajorCount()); 
		
//		if(majorList.contains(majorName)){
//			Stream<Major> stream = majorList.stream();
//			//filter(majorName)
//			stream.filter(m->m.equals(majorName)).forEach(m->System.out.print(m));
//			return true;
//		}
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
			stream.filter(m->m.equals(studentId)).forEach(m->System.out.print(m));
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
			stream.filter(m->m.equals(studentName)).forEach(m->System.out.print(m));
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

	@Override
	public boolean addMajor(Major major) {
		if(majorList.contains(major)) {
			return false;
		}
		majorList.add(major);
		return true;
	}
	
}
