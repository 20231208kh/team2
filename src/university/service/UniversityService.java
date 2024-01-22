package university.service;

import university.Major;
import university.Student;

public interface UniversityService {
	
	
	//학생 등록
	boolean addStudent();
	//학생 수정
	boolean updateStudent();
	//학생 삭제
	boolean deleteStudent();
	
	//전공 등록
	boolean addMajor();
	//전공 수정
	boolean UpdateMajor();
	//전공 삭제
	boolean deleteMajor();
	
	//교수 전공별 조회
	boolean searchByProfessorMajor();
	//학생 전공별 조회
	boolean searchByMajor(Major majorName);
	//학생 이름으로 조회
	boolean searchByStudentName(Student studentName);
	//학생 학번으로 조회
	boolean searchByStudentId(Student studentId);
	
	//성적 입력
	boolean insertScore();
	//성적 수정
	boolean updateScore();
	//성적 출력
	boolean printScore();
	
	//강의 등록
	boolean addLecture();
	//강의 수정
	boolean updateLecture();
	
	boolean addMajor(Major major);
	
}
