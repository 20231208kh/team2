package homework3.university.service;

public interface PrintService {
	
	void printMainMenu(); // 메뉴
	
	void printProfessorMenu(); //교수 메뉴
	
	void printProfessorManageMenu(); // 교수 관리
	
	void printProfessorFixedMenu(); //교수 수정
	
	void printScoreManagementMenu(); // 교수가 학생에게 주는 성적 관리
	
	void printProfessorMajorManageMentMenu(); //교수 전공 관리
	
    void printProfessorLectureManagementMenu(); //교수 강의 관리
	
	void printStudentMenu(); //학생 메뉴
	
	void printStudentManagementMenu(); //학생 관리
	
	 void printStudentFixedMenu(); //학생 수정
	
	void printStudentSubjectsManagementMenu(); // 학생 수강 과목 관리

	void universeSearchMenu(); //대학교 조회 메뉴
	
	void StudentSearchMenu(); //학생 조회 
	
	void professorSearchMenu(); //교수 조회
	
	void printExit(); //종료 메뉴
	
	
}