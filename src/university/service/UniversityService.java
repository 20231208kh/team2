package university.service;



import java.util.List;

import university.Major;
import university.Student;
import university.Lecture;
import university.Professor;



public interface UniversityService {
	
	//학생 등록
	boolean addStudent(Student student);
	//학생 수정
	boolean updateStudentName(Student student,String name);
	boolean updateStudentMajor(Student student, Major major);
	boolean updateStudentAge(Student student, int studentAge);
	boolean updateStudentGrade(Student student, int grade);

	//학생 삭제
	boolean deleteStudent(Student student);
	void printMajorList() ;
	
	//전공 등록
	boolean addMajor(Major major);
	//전공 수정
	boolean updateMajor(Major major, String majorTitle);
	//전공 삭제
	boolean deleteMajor(Major major);

	
	//교수 등록 : 김준수
	boolean addProfessor(String name, String id, Major professorMajor);
	//교수 수정 : 김준수
	Professor selectUpdateProfessor(String id);
	boolean updateProfessorName(Professor tmp ,String name);
	boolean updateProfessorID(Professor tmp ,String newID);
	boolean updateProfessorMajor(Professor tmp ,Major professorMajor);
	//교수 삭제 : 김준수
	boolean deleteProfessor(int num);
	
	//강의 등록 : 김준수
	boolean addLecture(String professorID, String lectureName, int lectureMaxCount, String lectureDay, int lectureST, int lectureLT);
	//강의 수정 : 김준수
	void updateLectureName(Lecture tmpLecture, String professorID, String newLectureName);
	boolean updateLectureMaxCount(Lecture tmpLecture, String professorID, int newLectureMaxCount);
	boolean updateLectureDay(Lecture tmpLecture, String professorID,String newLectureDay);
	boolean updateLectureTime(Lecture tmpLecture, String professorID,int newLectureST, int newLectureLT);
	//강의 삭제 : 김준수
	boolean deleteLecture(Lecture tmpLecture, Professor tmp);
	

	
	//교수 전공별 조회
	boolean searchByProfessorMajor();
	//학생 전공별 조회

	boolean searchByMajor(Major majorName);
	//학생 이름으로 조회
	boolean searchByStudentName(Student student);
	//학생 학번으로 조회
	boolean searchStudent(Student student);
	

	//수강 신청 : 김준수
	boolean signUpForLectures(int index, Student tmp);
	//수강 취소 : 김준수
	boolean deleteForLectures(int index, Student tmp);
	
	
	//성적 입력
	boolean insertScore(String studentId, Lecture lecture, int score);
	//강의에 등록된 학생 출력
	boolean matchLectureWithStudent(Lecture lecture);
	//성적 수정
	boolean updateScore();
	//성적 출력
	boolean printScore();
	
	

	//리스트 보내기
	List<Professor> sendProfessorList();
	List<Lecture> sendLectureList();
	List<Student> sendStudentList();
	List<Major> sendMajorList();
	
	List<Student> getStudent();
	List<Major> getMajor();
	
	//각종 확인 메서드
	boolean isStudentID(String studentID);
	boolean isProfessorID(String professorID);
	boolean isLectureEmpty(Lecture tmpLecture);
	Student selectStudent(String studentID);
	
	
	//박석훈
	
	//교수 조회
	//교수 전체 조회
	boolean searchAllProfessor(); 
	//교수 이름에 해당하는 교수 강의 조회
	boolean searchLecturesByProfessorName(String professorName); 
	// 전공에 해당하는 교수 이름 조회
	boolean professorNameSearchByMajor(String professorMajor);
	//교수 강의 현재 인원 조회
	boolean currentNumberOfLecture(String professorName);
	
	//교수 강의 조회
	 //해당 요일의 교수 수업 시작 시간과 강의 이름만 조회
	boolean searchLectureStartTimeAndLectureName(String professorId,String lectureDay);
	 //교수의 강의를 입력받고 해당 강의의 현재 정원 조회
	boolean searchSelectLectureAndLectureCount(String professorId, String lectureName);
	// 해당 교수의 수업을 듣는 학생들 이름 조회
	boolean searchStudentNameFromLecture(String professortId, String lectureDay);
		
	//학생 강의 조회
	
}

