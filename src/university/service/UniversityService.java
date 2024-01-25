package university.service;

import university.Lecture;
import university.Professor;

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
	boolean searchByStudentMajor();
	//학생 학번 조회
	boolean searchByStudentId();
	
	//성적 입력
	boolean insertScore();
	//성적 수정
	boolean updateScore();
	
	//강의 등록
	boolean addLecture(Lecture lecture);
	//강의 수정
	boolean updateLecture();
	
	//교수 등록 지울 것 테스트 용
	boolean addProfessor(Professor professor);
	
	//교수 전체 조회
	boolean searchAllProfessor();
	
	//교수 이름을 입력받아 교수 강의들 조회
	boolean searchLecturesByProfessorName(String professorName);
	
	//전공을 입력받아 교수들 이름을 조회
	boolean professorNameSearchByMajor(String professorMajor);
	
	//교수 강의의 현재 인원
	boolean currentNumberOfLecture(String professorName);
	

	
}