package university.service;

import java.util.List;

import university.Major;
import university.Student;

public interface UniversityService {
	
	List<Major> getMajor();
	
	//학생 등록
	boolean addStudent(Student student);
	//학생 수정
	boolean updateStudent();
	//학생 삭제
	boolean deleteStudent();
	
	void printMajorList() ;
	
	//전공 등록
	boolean addMajor(Major major);
	//전공 수정
	boolean UpdateMajor();
	//전공 삭제
	boolean deleteMajor();
	
	//교수 전공별 조회
	boolean searchByProfessorMajor();
	//학생 전공별 조회
	boolean searchByStudentMajor();
	//학생 학번 조회
	boolean searchByStudentId();
	
	//성적 입력
	boolean insertScore();
	//성적 수정
	boolean updateScore();
	
	//강의 등록
	boolean addLecture();
	//강의 수정
	boolean updateLecture();
	
}
