package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Lecture;
import university.Major;
import university.Professor;
import university.Student;


public class UniversityServiceImp implements UniversityService{
	List<Professor> professorList = new ArrayList<Professor>();
	List<Lecture> lectureList = new ArrayList<Lecture>(); 
	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	
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
		if(professorList == null) {
			professorList = new ArrayList<Professor>();
		}
		if(professorList.contains(new Professor(id))) {
			return false;
		}
		Professor tmp = new Professor(name, id, major);
		professorList.add(tmp);
		return true;
	}
	
	@Override
	//수정할 교수 특정
	public Professor selectUpdateProfessor(String id) {
		if(professorList == null || professorList.size()==0) {
			return null;
		}
		Professor tmp = new Professor(id);
		int num = professorList.indexOf(tmp);
		return professorList.get(num);

	}

	@Override
	//교수 이름 수정
	public boolean updateProfessorName(Professor tmp ,String name) {
		if(tmp == null|| professorList == null || professorList.size()==0) {
			return false;
		}
		final Professor res = tmp;
		professorList.stream().filter(p->p.equals(res)).forEach(p->p.setProfessorName(name));
		return true;
	}

	@Override
	//교수 ID 수정
	public boolean updateProfessorID(Professor tmp ,String newID) {
		if(tmp == null|| professorList == null || professorList.size()==0) {
			return false;
		}
		final Professor res = tmp;
		professorList.stream().filter(p->p.equals(res)).forEach(p->p.setProfessorId(newID));
		return true;

	}

	@Override
	//교수 전공 수정
	public boolean updateProfessorMajor(Professor tmp , String major) {
		if(tmp == null|| professorList == null || professorList.size()==0) {
			return false;
		}
		final Professor res = tmp;
		professorList.stream().filter(p->p.equals(res)).forEach(p->p.setProfessorMajor(major));
		return true;
	}
	
	

	
	
	@Override
	// 교수 삭제
	public boolean deleteProfessor(int num) {
		if(professorList == null || professorList.size()==0) {
			return false;
		}
		professorList.remove(--num);
		return true;
	}

	@Override
	// 강의 등록
	public boolean addLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// 강의 수정
	public boolean updateLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// 강의 삭제
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

	
	@Override
	//교수 리스트를 보내는 메서드
	public List<Professor> sendProfessorList() {
		return professorList;
	}
	
	@Override
	public List<Lecture> sendLectureList() {
		return lectureList;
	}

	@Override
	public List<Student> sendStudentList() {
		return studentList;
	}

	@Override
	public List<Major> sendMajorList() {
		return majorList;
	}

	
	
	
}
