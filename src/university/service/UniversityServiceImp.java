package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Lecture;
import university.Major;
import university.Professor;
import university.Student;

public class UniversityServiceImp implements UniversityService{
	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	List<Professor> professorList = new ArrayList<Professor>();
	List<Lecture> lectureList = new ArrayList<Lecture>();
	
	//전공 조회
	@Override
	public boolean searchByMajor(Major majorName) {
		if(majorList == null) {
			majorList = new ArrayList<Major>();
		}
		int index = majorList.indexOf(majorName);
		if(index == -1) {
			return false;
		}
		System.out.print(majorList.get(index));
		return true;			
	}
	/*
	if(majorList.contains(majorName)){
		Stream<Major> stream = majorList.stream();
		//filter(majorName)
		stream.filter(m->m.equals(majorName)).forEach(m->System.out.print(m));
		return true;
	}
	*/
	
	//학번을 받아서 학생 조회(1명)
	@Override
	public boolean searchStudent(Student student) {
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		int index = studentList.indexOf(student);
		if(index == -1) {
			return false;
		}
		System.out.print(studentList.get(index));
		return true;
	}
	
	//학생 이름으로 조회(등록된 동명이인 모두 출력. 앞에 번호 1 --- 2 --- 이런식으로 출력되게 equals로 걍 바로 조회가능 string이여서
	//학번 빠른순서대로 숫자매겨볼수있을까
	@Override
	public boolean searchByStudentName(Student student) {
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		for(int i = 0; i<studentList.size(); i++) {
			if(studentList.size() != 0) {
				studentList.get(i).getStudentName().equals(student.getStudentName());
				System.out.println(studentList.get(i));
			}else {
				return false;
			}
		}
		return true;
	}
	
	//수강하고있는 학생 전체 출력
	@Override
	public boolean matchLectureWithStudent(Lecture lecture) {
		if(lectureList == null) {
			return false;
		}
		//교수list에서 lecture와 이름이 같은 번지 index 저장
		int index = professorList.indexOf(lecture);
		if(index == -1) {
			return false;
		}
		//강의list보다 작은동안
		for(int i = 0; i < lectureList.size(); i++) {
			if(lectureList == null) {
				return false;
			}
			//강의 리스트의 i번째 강의가 교수list의 index번째 강의와 같다면 
			if(professorList.get(index).getLectureList().equals(i)) {
				//studentList에서 lecture를 가지고 있는 학생 출력
				System.out.println(studentList.equals(lecture));
			}
			return true;
		}
		return false;
	}
	
	//성적 추가
	@Override
	//교수 강의가 
	public boolean insertScore(String studentId, Lecture lecture, int score) {
		//학생list의 id가 입력받은 studentId와 같다면
		if(studentList.contains(studentId)) {
			//studentList의 index를 indexStudentId에 저장
			int indexStudentId = studentList.indexOf(studentId);
			//없으면 false
			if(indexStudentId == -1) {
				return false;
			}
			//lecturelist의 lecture가 위에서 입력된 lecture와 같다면
			if(lectureList.contains(lecture)) {
				//lectureList의 index를 indexLecture에 저장
				int indexLecture = lectureList.indexOf(lecture);
				//없으면 false;
				if(indexLecture == -1) {
					return false;
				}
				//lectureList의 indexLecture와 같은 전공을 등록한 학생리스트의 indexStudentId에 입력받은 score 저장
				studentList.get(indexStudentId).getLectureList().get(indexLecture).setLectureScore(score);
				return true;
			}
		}
		return false;
	}
	
	//성적 출력
	@Override
	public boolean printScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudent(Student student) {
		if(studentList.contains(student)) {
			return false;
		}
		studentList.add(student);
		return true;
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
	public boolean updateScore() {
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
	public boolean addMajor(Major major) {
		if(majorList.contains(major)) {
			return false;
		}
		majorList.add(major);
		return true;
	}

}
