package university.service;

import java.util.List;

import university.Lecture;
import university.Major;
import university.Professor;
import university.Student;

public interface UniversityService {
	
	
	//학생 등록  : 박성훈
	boolean addStudent();
	//학생 수정  : 박성훈
	boolean updateStudent();
	//학생 삭제  : 박성훈
	boolean deleteStudent();
	
	//전공 등록  : 박성훈
	boolean addMajor();
	//전공 수정  : 박성훈
	boolean UpdateMajor();
	//전공 삭제  : 박성훈
	boolean deleteMajor();
	
	//교수 등록 : 김준수
	boolean addProfessor(String name, String id, String major);
	//교수 수정 : 김준수
	Professor selectUpdateProfessor(String id);
	boolean updateProfessorName(Professor tmp ,String name);
	boolean updateProfessorID(Professor tmp ,String newID);
	boolean updateProfessorMajor(Professor tmp ,String major);
	//교수 삭제 : 김준수
	boolean deleteProfessor(int num);
	
	//강의 등록 : 김준수
	boolean addLecture();
	//강의 수정 : 김준수
	boolean updateLecture();
	//강의 삭제 : 김준수
	boolean deleteLecture();
	
	
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
	
	//리스트 보내기
	List<Professor> sendProfessorList();
	List<Lecture> sendLectureList();
	List<Student> sendStudentList();
	List<Major> sendMajorList();
}
