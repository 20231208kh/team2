package university.service;

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
	//전공관리
	void printManageMajor();
	//교수관리
	void printManageProfessor();
	//학생관리
	void printManageStudent();

}