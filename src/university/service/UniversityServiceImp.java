package university.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import university.Lecture;
import university.Major;
import university.Professor;
import university.Student;


public class UniversityServiceImp implements UniversityService {

	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	List<Lecture> lectureList = new ArrayList<Lecture>();
	List<Professor> professorList = new ArrayList<Professor>();
	
	
	@Override
	public boolean addStudent(Student student) {
		
		if(studentList.contains(student)) {
			System.out.println("중복된 학번 입력입니다.");
			return false;
		}
		
		studentList.add(student);
		System.out.println(studentList);
		return true;
	}

	@Override
	public boolean updateStudentName(Student student,String name) {
		
		if(studentList==null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setStudentName(name);
			System.out.println(studentList.get(index));
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		if(studentList == null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			return studentList.remove(student);
			
		}
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

	@Override
	public boolean UpdateMajor() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteMajor(Major major) {
		if(majorList == null) {
			return false;
		}
		
		if(majorList.contains(major)) {
			return majorList.remove(major);
			
		}
		return false;
	}

	@Override
	public boolean searchByProfessorMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentId() {
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
	public List<Major> getMajor() {
		return majorList;

	}

	@Override
	public void printMajorList() {
		for(int i = 0; i<majorList.size(); i++) {
			System.out.println((i+1)+" : "+majorList.get(i));
		}
		
	}

	@Override
	public List<Student> getStudent() {
		return studentList;
	}

	@Override
	public boolean updateStudentMajor(Student student, Major major) {
		if(majorList==null || studentList==null) {
			return false;
		}
		
		if(majorList.contains(major)) {
			int index= studentList.indexOf(student);
			
			if(index == -1) {
				return false;
			}
			
			studentList.get(index).setMajor(major);
			
			System.out.println(studentList.get(index));
			return true;
			
		}
		
		return false;
	}

	@Override
	public boolean updateStudentAge(Student student, int studentAge) {
		if(studentList==null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setAge(studentAge);
			System.out.println(studentList.get(index));
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean updateStudentGrade(Student student, int grade) {
		if(studentList==null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setGrade(grade);
			System.out.println(studentList.get(index));
			return true;
		}
		
		
		return false;
	}
	
}
