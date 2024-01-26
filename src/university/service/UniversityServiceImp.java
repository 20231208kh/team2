package university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import university.Lecture;
import university.Major;
import university.Professor;
import university.Student;



public class UniversityServiceImp implements UniversityService {
	PrintService prsi = new PrintServiceImp();
	List<Student> studentList = new ArrayList<Student>();
	List<Major> majorList = new ArrayList<Major>();
	List<Lecture> lectureList = new ArrayList<Lecture>();
	List<Professor> professorList = new ArrayList<Professor>();
	Scanner scan = new Scanner(System.in);
	
	
	@Override
	public boolean addStudent(Student student) {
		
		if(studentList.contains(student)) {
			System.out.println("중복된 학번 입력입니다.");
			return false;
		}
		
		studentList.add(student);
		System.out.println(studentList);
		return true;
	}


	@Override
	public boolean addProfessor(String name, String id, Major professorMajor) {
		if(professorList == null) {
			professorList = new ArrayList<Professor>();
		}
		if(professorList.contains(new Professor(id))) {
			return false;
		}
		Professor tmp = new Professor(name, id, professorMajor);
		professorList.add(tmp);
		return true;
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
	public boolean updateStudentName(Student student,String name) {
		if(studentList==null) {
			return false;
		}
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setStudentName(name);
			System.out.println(studentList.get(index));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		if(studentList == null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			return studentList.remove(student);
		}
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
	public boolean updateProfessorMajor(Professor tmp , Major professorMajor) {
		if(tmp == null|| professorList == null || professorList.size()==0) {
			return false;
		}
		if(professorList.contains(tmp)) {
			int index = professorList.indexOf(tmp);
			if (index==-1) {
				return false;
			}
			if(professorList.get(index).getProfessorMajor().getMajorId()==professorMajor.getMajorId()) {
				
				System.out.println("기존의 전공과 같은 전공을 선택하였습니다.");
				return false;
			}
			professorList.get(index).setProfessorMajor(professorMajor);
			return true;
			
		}
		return false;
	}
	
	

	
	
	@Override
	// 교수 삭제
	public boolean deleteProfessor(int num) {
		if(professorList == null || professorList.size()==0) {
			return false;
		}
		if(professorList.size()<num) {
			return false;
		}
		professorList.remove(--num);
		return true;
	}
	
	@Override

	public boolean updateMajor(Major major, String majorTitle) {
		if(majorList ==null) {
			return false;
		}
		int index = majorList.indexOf(major);
		if(index ==-1) {
			return false;
		}
		majorList.get(index).setMajorName(majorTitle);
		System.out.println(majorList.get(index));
		return true;
	}
	
	@Override
	public boolean deleteMajor(Major major) {
		if(majorList == null) {
			return false;
		}
		if(majorList.contains(major)) {
			return majorList.remove(major);
		}
		return false;
	}


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
		professorList.get(professorList.indexOf(new Professor(professorID)))
			.getLectureList().get(index).setLectureName(newLectureName);
		lectureList.get(lectureList.indexOf(tmpLecture)).setLectureName(newLectureName);
		
	}
	
	@Override
	// 강의 최대 수강인원 수정
	public boolean updateLectureMaxCount(Lecture tmpLecture, String professorID, int newLectureMaxCount) {
		Professor tmp = professorList.get(professorList.indexOf(new Professor(professorID)));
		if(newLectureMaxCount >= lectureList.get(lectureList.indexOf(tmpLecture)).getLectureCount()) {
			int index = tmp.getLectureList().indexOf(tmpLecture);
			professorList.get(professorList.indexOf(new Professor(professorID)))
				.getLectureList().get(index).setLectureMaxCount(newLectureMaxCount);
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
		professorList.get(professorList.indexOf(new Professor(professorID)))
			.getLectureList().get(index).setLectureDay(newLectureDay);
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
		professorList.get(professorList.indexOf(new Professor(professorID)))
			.getLectureList().get(index).setLectureST(newLectureST);
		professorList.get(professorList.indexOf(new Professor(professorID)))
			.getLectureList().get(index).setLectureLT(newLectureLT);
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
	//수강신청
	public boolean signUpForLectures(int index , Student tmp) {
		int errorCode;
		if(lectureList == null || lectureList.size() == 0) {
			errorCode = 1;
			prsi.printSignUpError(errorCode);
			return false;
		}
		if(index<0 || index>= lectureList.size() ) {
			errorCode = 2;
			prsi.printSignUpError(errorCode);
			return false;
		}
		int totalHour = 0;
		for(int i = 0 ; i <tmp.getLectureList().size(); i++) {
		 	totalHour += tmp.getLectureList().get(i).getLectureLT();
		 	Lecture tmpLecture = tmp.getLectureList().get(i);
		 	if(tmpLecture.getLectureDay().equals(lectureList.get(index).getLectureDay())
	 			&& tmpLecture.getLectureST() < lectureList.get(index).getLectureST()+ lectureList.get(index).getLectureLT() 
	 			&& lectureList.get(index).getLectureST() < tmpLecture.getLectureST() + tmpLecture.getLectureLT()) {
		 		errorCode = 3;
		 		prsi.printSignUpError(errorCode);
		 		return false;
		 	}
		}
		totalHour += lectureList.get(index).getLectureLT();
		if(totalHour> 22) {
			errorCode = 4;
			prsi.printSignUpError(errorCode);
			return false;
		}
		int tmpCount = lectureList.get(index).getLectureCount();
		for(int i=0; i< professorList.size() ; i++) {
			if(professorList.get(i).getLectureList().contains(lectureList.get(index))) {
				professorList.get(i).getLectureList().get(professorList.get(i).getLectureList().indexOf(lectureList.get(index)))
				.setLectureCount(tmpCount+1);
			}
		}
		lectureList.get(index).setLectureCount(tmpCount+1);
		studentList.get(studentList.indexOf(tmp)).getLectureList().add(lectureList.get(index));
		return true;
	}
		
	@Override
	//수강취소
	public boolean deleteForLectures(int index, Student tmp) {
		int errorCode;
		if(index < 0|| tmp.getLectureList().size() <= index) {
			errorCode = 1;
			prsi.printDeleteForLecturesError(errorCode);
			return false;
		}
		if(!lectureList.contains(tmp.getLectureList().get(index))) {
			errorCode = 2;
			prsi.printDeleteForLecturesError(errorCode);
			return false;
		}
		studentList.get(studentList.indexOf(tmp)).getLectureList().remove(index);
		lectureList.get(lectureList.indexOf(tmp.getLectureList().get(index)))
		.setLectureCount(lectureList.get(lectureList.indexOf(tmp.getLectureList().get(index)))
		.getLectureCount()-1);
		for(int i = 0 ; i< professorList.size(); i++) {
			if(professorList.get(i).getLectureList().contains(tmp.getLectureList().get(index))) {
				professorList.get(i).getLectureList().get(professorList.get(i).getLectureList().indexOf(tmp.getLectureList().get(index)))
				.setLectureCount(professorList.get(i).getLectureList().get(professorList.get(i).getLectureList().indexOf(tmp.getLectureList().get(index)))
				.getLectureCount()-1);
				return true;
			}
		}
		errorCode = 3;
		prsi.printDeleteForLecturesError(errorCode);
		return false;
	}
	
	
	
	


	@Override

	
	public boolean searchByStudentMajor() {
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
	public List<Major> getMajor() {
		return majorList;

	}

	@Override
	public void printMajorList() {
		for(int i = 0; i<majorList.size(); i++) {
			System.out.print((i+1)+" : "+majorList.get(i));
		}
		
	}

	@Override
	public List<Student> getStudent() {
    return studentList;
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

	public boolean updateStudentMajor(Student student, Major major) {
		if(majorList==null || studentList==null) {
			return false;
		}
		
		if(majorList.contains(major)) {
			int index= studentList.indexOf(student);
			
			if(index == -1) {
				return false;
			}
			if(studentList.get(index).getMajor().getMajorId()==major.getMajorId()) {
				
				System.out.println("기존의 전공과 같은 전공을 선택하였습니다.");
				return false;
			}
			
			String id = studentList.get(index).getStudentId();
			String newId = id.substring(0,4) + major.getMajorId()+id.substring(6);
			Student tmp = new Student(newId);
			while(studentList.contains(tmp)){
				System.out.println("중복된 학번, 마지막 두 자리 수정 필요");
				System.out.print("수정할 마지막 두 자리 학번 입력 : ");
				String lastNum = scan.next();
				newId = id.substring(0,4)+major.getMajorId()+lastNum;
				tmp = new Student(newId);
			}
			studentList.get(index).setMajor(major);
			studentList.get(index).setStudentId(newId);
			System.out.println("학생 전공 수정 성공!");
			System.out.println(studentList.get(index));
			return true;
			
		}
		System.out.println("학생 전공 수정 실패");
		return false;
	}

	@Override
	public boolean updateStudentAge(Student student, int studentAge) {
		if(studentList==null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setAge(studentAge);
			System.out.println(studentList.get(index));
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudentGrade(Student student, int grade) {
		if(studentList==null) {
			return false;
		}
		
		if(studentList.contains(student)) {
			int index = studentList.indexOf(student);
			if(index==-1) {
				return false;
			}
			studentList.get(index).setGrade(grade);
			System.out.println(studentList.get(index));
			return true;
		}
		return false;
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
	public boolean isStudentID(String studentID) {
		if(studentList == null || studentList.size()==0) {
			return false;
		}
		if(studentList.contains(new Student(studentID))) {
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

	




	@Override
	public boolean searchByProfessorMajor() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean searchByStudentId() {
		// TODO Auto-generated method stub
		return false;
	}


	

	
	@Override
	//교수 특정
	public Professor selectUpdateProfessor(String id) {
		if(professorList == null || professorList.size()==0) {
			return null;
		}
		Professor tmp = new Professor(id);
		int num = professorList.indexOf(tmp);
		if(num <0) {
			return null;
		}
		return professorList.get(num);
	}

	
	
	@Override
	//학생특정
	public Student selectStudent(String studentID) {
		if(professorList == null || professorList.size()==0) {
			return null;
		}
		Student tmp = new Student(studentID);
		int num = studentList.indexOf(tmp);
		if(num <0) {
			return null;
		}
		return studentList.get(num);
	}
	
	
	


	
}
