package university.service;

import university.Lecture;
import university.Major;
import university.Student;

public interface UniversityService {
	
	
	//학생 등록
	boolean addStudent(Student student);
	//학생 수정
	boolean updateStudent();
	//학생 삭제
	boolean deleteStudent();
	
	//전공 등록
	boolean addMajor(Major major);
	//전공 수정
	boolean UpdateMajor();
	//전공 삭제
	boolean deleteMajor();
	
	//교수 전공별 조회
	boolean searchByProfessorMajor();
	//학생 전공별 조회
	boolean searchByMajor(Major majorName);
	//학생 이름으로 조회
	boolean searchByStudentName(Student student);
	//학생 학번으로 조회
	boolean searchStudent(Student student);
	
	//성적 입력
	boolean insertScore(String studentId, Lecture lecture);
	//교수 확인
	boolean matchProfessorID(String professorId);
	//강의에 등록된 학생 출력
	boolean matchLectureWithStudent(Lecture lecture);
	//성적 수정
	boolean updateScore();
	//성적 출력
	boolean printScore();
	
	//강의 등록
	boolean addLecture();
	//강의 수정
	boolean updateLecture();
	
}
