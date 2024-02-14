package university.service;


import java.util.List;

import university.Lecture;
import university.Professor;


public interface PrintService {
	//메뉴출력
	void printMenu();
	//죵료 출력
	void printExitMenu();
	
	//학생사용메뉴
	void printStudentMenu();
	//수강관리
	void printManageSignUp();

	void manageUpdateStudent();
	
	void infoProgram();
	


	//교수사용메뉴
	void printProfessorMenu();
	//성적관리
	void printManageScore();
	//과목관리
	void printManageLecture();

	//학사사용메뉴
	void printUniversityMenu();
	//조회
	void printSearch();

	//학생조회 메뉴
	void printSearchStudentMenu();
	//전공조회 메뉴
	void printSearchMajorMenu();

	//전공관리
	void printManageMajor();
	//교수관리
	void printManageProfessor();

	//학생관리
	void printManageStudent();
	
	//교수조회
	void printProfessorSearch();

	//교수와학생 강의 조회 선택 메뉴
	void printProfessor_StudentLectureSearch();
	
	//교수 강의 조회
	void printProfessorLectuerSearch();
	
	//학생 강의 조회
	void printStudentLecturetSearch();
	
	//교수수정
	void printUpdateProfessor();

	//등록된 교수 출력
	void printProfessorList(List<Professor> tmp);
	
	
	
	
	void printManageUpdateLecture();
	
	//교수의 등록강의 리스트 출력
	void printProfessorLectureList(Professor tmp);
	
	//등록된 강의 리스트 출력
	void printLectureList(List<Lecture> tmp);
	
	//수강신청,취소 에러 출력
	void printSignUpError(int errorCode);
	void printDeleteForLecturesError(int errorCode);
	
}



