package homework3.university.service;

public interface UniversityService {

	
	//교수 관리
	boolean addProfessor(); 	//교수 추가
	boolean setProfessor(); 	//교수 수정
	boolean deleteProfessor(); 	//교수 삭제
	

	//교수 관리: 교수 수정
	boolean setProfessorId();		//교수 번호 수정
	boolean setProfessorAge();  	//교수 나이 수정
	boolean setProfessorName(); 	//교수 이름 수정
	

	//교수가 학생에게 성적 관리 
	boolean addScore(); 	//교수가 성적 부여
	boolean setScore(); 	//교수가 성적 부여
	boolean deleteScore(); 	//교수가 성적 부여
	
	
	//교수 전공 관리
	boolean professorAddMajor();	 //교수 전공 추가
	boolean professorSetMajor(); 	 //교수 전공 수정
	boolean  professorDeleteMajor(); //교수 전공 삭제
	
	//교수 강의 관리
	boolean professorAddLecture();		//교수 강의 추가
	boolean professorSetLecture();  	// 교수 강의 수정
	boolean professorDeleteLecture(); 	//교수 강의 삭제
	
	
	boolean addStudent();//학생 추가 

	//학생 수정
	boolean setStudentStudNum();	//학생 학번 수정
	boolean setStudentAge(); 		//학생 나이 수정
	boolean setStudentName();		//학생 이름 수정
	
	boolean deleteStudent(); //학생 삭제
	
	//학생 수강 강의 관리
	boolean addStudentLecture();		//학생 수강 강의 추가
	boolean setStudentLecture();		//학생 수강 강의 수정
	boolean deleteStudentLecture(); 	//학생 수강 강의 삭제
	
	//대학교 조회 메뉴
	
	
	

}	
