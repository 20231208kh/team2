package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Lecture;
import university.Professor;

public class UniversityServiceImp implements UniversityService {
	List<Professor> professorList = new ArrayList<Professor>();
	List<Lecture> lectureList = new ArrayList<Lecture>();
	int index;
	@Override
	public boolean addStudent() {
	
		return false;
	}

	@Override
	public boolean updateStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByProfessorMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentId() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLecture() {
		
		return false;
	}
	
	public boolean printProfessorSearch() {
		
		return false;
	}

	//전체 조회
	@Override
	public boolean searchAllProfessor() {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		  System.out.println(professorList);	
		  return true;	   
	}
	
	//강의 추가 임시->지울것
	@Override
	public boolean addLecture(Lecture lecture) {

		lectureList.add(lecture);
	
		return true;
		
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override //교수 이름을 입력받아 교수 강의들 조회
	public boolean searchLecturesByProfessorName(String professorName) {
	
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++){
			
		if(professorList.get(i).getProfessorName().equals(professorName)) {
				
				System.out.println(professorList.get(i).getLectureList());
				
		}
		}
		return true;
	
}

	@Override // 교수 전공을 받아서 교수들 이름을 출력
	public boolean professorNameSearchByMajor(String professorMajor) {
		
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++){
			
			if(professorList.get(i).getProfessorMajor().equals(professorMajor)){
			
				System.out.println(professorList.get(i).getProfessorName());
			
			}
			
		}
		return true;
		
}

	@Override //교수 강의 현재 인원
	public boolean currentNumberOfLecture(String professorName) {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++){
			
			if(professorList.get(i).getProfessorName().equals(professorName)){
				System.out.println(lectureList.get(i).getLectureCount()+"명/"+
				lectureList.get(i).getLectureMaxCount());
			}
		}
		return true;
	}
	
}
	
	
	
	

