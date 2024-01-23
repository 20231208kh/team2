package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Lecture;
import university.Professor;

public class UniversityServiceImp implements UniversityService {
	List<Professor> professorList = new ArrayList<Professor>();
	List<Lecture> lectureList = new ArrayList<Lecture>();

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
	
	

	//교수 추가 임시->지울것
	@Override
	public boolean addProfessor(Professor professor) {
		professorList.add(professor);
		return true;
		
	}

	//교수 강의 조회
	@Override
	public boolean searchProfessorLecture() {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++)
		{
			System.out.println("강의 이름" + professorList.get(i).getLectureList());
		}
		
		return true;
	}

	//교수 이름 조회
	@Override
	public boolean searchProfessorName() {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++)
		{
			System.out.println("교수 이름 : " + professorList.get(i).getProfessorName());
			
		}
		return true;
	}

	//교수 번호 조회
	@Override
	public boolean searchProfessorId() {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++)
		{
			
			System.out.println("교수 번호 : "+ professorList.get(i).getProfessorId());
		}
		
		return true;
	}

	//강의 추가 임시->지울것
	@Override
	public boolean addLecture(Lecture lecture) {

		lectureList.add(lecture);
		return true;
		
	}
	
	
	
	

}
