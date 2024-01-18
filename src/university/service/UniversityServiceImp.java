package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Professor;


public class UniversityServiceImp implements UniversityService{
	List<Professor> professorList = new ArrayList<Professor>();
	
	
	@Override
	public boolean addStudent() {
		// TODO Auto-generated method stub
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
	public boolean addProfessor(String name, String id, String major) {
		if(professorList==null) {
			professorList = new ArrayList<Professor>();
		}
		if(professorList.contains(new Professor(id))) {
			return false;
		}
		Professor tmp = new Professor(name, id, major);
		professorList.add(tmp);
		return true;
	}
	// 교수 수정 : 이름, id, 전공
	@Override
	public Professor updateProfessor(String id) {
		if(professorList ==null || professorList.size()==0) {
			return null;
		}
		Professor tmp = new Professor(id);
		int num = professorList.indexOf(tmp);
		return professorList.get(num);

	}

	@Override
	public boolean updateProfessorName(Professor tmp ,String name) {
		if(tmp.equals(null)|| professorList ==null || professorList.size()==0) {
			
		}
		return false;
	}

	@Override
	public boolean updateProfessorId(Professor tmp ,String newID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfessorMajor(Professor tmp , String major) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	@Override
	public boolean deleteProfessor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLecture() {
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

	
	
}
