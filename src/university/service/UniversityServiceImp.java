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
	
	//교수 확인
	@Override
	public boolean matchProfessorID(String professorId) {
		Professor professor = new Professor(professorId);
		if(professorList == null) {
			professorList = new ArrayList<Professor>();
		}
		int index = professorList.indexOf(professor);
		if(index == -1) {
			return false;
		}
		System.out.println(professorList.get(index).equals(lectureList));
		return true;
	}
	
	//수강하고있는 학생 전체 출력
	@Override
	public boolean matchLectureWithStudent(Lecture lecture) {
		if(lectureList == null) {
			return false;
		}
		//반복문 stream이용해서 리스트 다 출력
		int index = professorList.indexOf(lecture);
		if(index == -1) {
			return false;
		}
		for(int i = 0; i < lectureList.size(); i++) {
			//해당 강의를 수강하는 모든 학생 출력
			if(professorList.get(index).getLectureList().equals(i)) {
			
			}
			
		}
		return false;
	}
	/*
		---a교수 강의목록--
		1. 경영학원론
		2. 경영회계
		선택 : 2
	
		2.경영회계 << 인스턴스
		
		--경영회계를 수강하는 학생--
		1. 홍길동(학번)
		2.임꺽정(학번)
		선택 : 20241201
	
		--임꺽정 성적 입력-- 
		studentList.get(i).getLectureList(1).setLectureScore()
		
		임꺽정(이름,나이,학년,학번 , 강의 [ (강의1이름,점수),(경영회계,점수) ] 
		점수 입력 : 
		
		
		3단계 : 그 중 선택(string)
			Lecture lecture  = new Lecture(lectureName)
			professorList.get(i).get(lectureList)
			professor [이름 나이 전공 , [강의(강의1,강의2) 
		
		4단계 : 교수가 선택한 강의를 가지고있는 학생 인스턴스 출력
	 */
	
	//성적 추가
	@Override
	//교수 강의가 
	public boolean insertScore(String studentId, Lecture lecture) {
		if(studentList.contains(studentId)) {
			int index = studentList.indexOf(studentId);
			if(index==-1) {
				return false;
			}
			studentList.get(index).getLectureList().get(1).setLectureScore(index);
			return true;
		}
		studentList (Student(A,B,C,[LeturList(lecture1),lecture(2)]), Student2(~~~))
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
