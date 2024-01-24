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
	public boolean addLecture(String professorID, String lectureName, int lectureMaxCount
							, String lectureDay, int lectureST, int lectureLT) {
		if(lectureList == null) {
			lectureList = new ArrayList<Lecture>();
		}
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		int index = professorList.indexOf(new Professor(professorID));
		Lecture tmpLecture = new Lecture(professorID, lectureName, lectureMaxCount, lectureDay, lectureST, lectureLT);
		if(lectureList.contains(tmpLecture)) {
			return false;
		}
		for(int i =0 ; i <tmp.getLectureList().size() ; i++) {
			Lecture tmpI = tmp.getLectureList().get(i);
			if(tmpLecture.getLectureST()< tmpI.getLectureST()+ tmpI.getLectureLT()
				&& tmpI.getLectureST() < tmpLecture.getLectureST()+ tmpLecture.getLectureLT()
				&& tmpI.getLectureDay().equals(lectureDay)) {
				return false;
			}
		}
		lectureList.add(tmpLecture);
		professorList.get(index).getLectureList().add(tmpLecture);
		return true;
	}

	@Override
	// 강의명 수정
	public void updateLectureName(Lecture tmpLecture, String professorID, String newLectureName) {
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		int index = tmp.getLectureList().indexOf(tmpLecture);
		professorList.get(professorList.indexOf(new Professor(professorID))).getLectureList().get(index).setLectureName(newLectureName);
		lectureList.get(lectureList.indexOf(tmpLecture)).setLectureName(newLectureName);
	}
	
	@Override
	// 강의 최대 수강인원 수정
	public boolean updateLectureMaxCount(Lecture tmpLecture, String professorID, int newLectureMaxCount) {
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		if(newLectureMaxCount >= lectureList.get(lectureList.indexOf(tmpLecture)).getLectureCount()) {
			int index = tmp.getLectureList().indexOf(tmpLecture);
			professorList.get(professorList.indexOf(new Professor(professorID))).getLectureList().get(index).setLectureMaxCount(newLectureMaxCount);
			lectureList.get(lectureList.indexOf(tmpLecture)).setLectureMaxCount(newLectureMaxCount);
			return true;
		}
		return false;
	}

	@Override
	// 강의 요일 수정
	public boolean updateLectureDay(Lecture tmpLecture, String professorID, String newLectureDay) {
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		int index = tmp.getLectureList().indexOf(tmpLecture);
		Lecture thisLecture = lectureList.get(lectureList.indexOf(tmpLecture));
		for(int i =0 ; i <tmp.getLectureList().size() ; i++) {
			Lecture tmpI = tmp.getLectureList().get(i);
			if(i != lectureList.indexOf(tmpLecture)
				&& tmpI.getLectureDay().equals(newLectureDay)
				&& thisLecture.getLectureST()< tmpI.getLectureST()+ tmpI.getLectureLT()
				&& tmpI.getLectureST() < thisLecture.getLectureST()+ thisLecture.getLectureLT()) {
				return false;
			}
		}
		professorList.get(professorList.indexOf(new Professor(professorID))).getLectureList().get(index).setLectureDay(newLectureDay);
		lectureList.get(lectureList.indexOf(tmpLecture)).setLectureDay(newLectureDay);
		return true;
	}
	
	@Override
	// 강의 시간 수정
	public boolean updateLectureTime(Lecture tmpLecture, String professorID, int newLectureST, int newLectureLT) {
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		int index = tmp.getLectureList().indexOf(tmpLecture);
		Lecture thisLecture = lectureList.get(lectureList.indexOf(tmpLecture));
		for(int i =0 ; i <tmp.getLectureList().size() ; i++) {
			Lecture tmpI = tmp.getLectureList().get(i);
			if(i != lectureList.indexOf(tmpLecture)
				&& tmpI.getLectureDay().equals(thisLecture.getLectureDay())
				&& newLectureST< tmpI.getLectureST() + tmpI.getLectureLT()
				&& tmpI.getLectureST() < newLectureST + newLectureLT) {
				return false;
			}
		}
		professorList.get(professorList.indexOf(new Professor(professorID))).getLectureList().get(index).setLectureST(newLectureST);
		professorList.get(professorList.indexOf(new Professor(professorID))).getLectureList().get(index).setLectureLT(newLectureLT);
		lectureList.get(lectureList.indexOf(tmpLecture)).setLectureST(newLectureST);
		lectureList.get(lectureList.indexOf(tmpLecture)).setLectureLT(newLectureLT);
		return true;
	}

	
	
	
	@Override
	// 강의 삭제
	public boolean deleteLecture(Lecture tmpLecture, Professor tmp) {
		if(!tmp.getLectureList().contains(tmpLecture) || !lectureList.contains(tmpLecture)) {
			return false;
		}
		int index = professorList.indexOf(tmp);
		professorList.get(index).getLectureList().remove(tmpLecture);
		lectureList.remove(tmpLecture);
		return true;
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
	
	@Override
	public boolean isProfessorID(String professorID) {
		if(professorList == null || professorList.size()==0) {
			return false;
		}
		if(professorList.contains(new Professor(professorID))) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isLectureEmpty(Lecture tmpLecture) {
		if(lectureList.get(lectureList.indexOf(tmpLecture)).getLectureCount()!=0) {
			return false;			
		}
		return true;
	}

	
	
	
	
}
