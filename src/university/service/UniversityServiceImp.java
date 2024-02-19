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

	

	//교수전체 조회
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
		
		if(professorList == null || professorList.size() == 0) {
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++){

			
			if(professorList.get(i).getProfessorMajor().getMajorName().equals(professorMajor)){
			
				System.out.println(professorList.get(i).getProfessorName());
			

			
			}
		}
		return true;
	}

	@Override //교수 강의 현재 인원 최대정원이랑 합치는게 좋아보임
	public boolean currentNumberOfLecture(String professorName) {
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++)
		{
			
			if(professorList.get(i).getProfessorName().equals(professorName)) {
					
				System.out.println(professorList.get(i).getProfessorName());
				
					for(int j=0; j<professorList.get(i).getLectureList().size(); j++) {
						
						
							System.out.println("교수 이름:"+professorList.get(i).getProfessorName()+
									"현재 정원 : "+professorList.get(i).getLectureList().get(j).getLectureCount()+ 
									" 최대 정원 : "+professorList.get(i).getLectureList().get(j).getLectureMaxCount());
				
			
					}
			}
		}
		return true;
	}
	
	//교수 강의 조회
	
	@Override  //교수 1명 특정하고 강의 리스트를 가져옴
			   // 강의리스트에서 강의 이름과 동일한 것을 뽑아 오고 그 강의의 이름과 강의 시작 시간을 가져옴.
	public boolean searchLectureStartTimeAndLectureName(String professorId, String lectureName) {
		if(professorList == null || professorList.size() == 0){
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<professorList.size(); i++){
		
			if(professorList.get(i).getProfessorId().equals(professorId)){ //교수리스트의 번호와 입력한 교수 번호가 동일하다면 
			
				for(int j=0; j<professorList.get(i).getLectureList().size(); j++){ //강의 리스트 j를 가진 for문을 돌림
				
					if(professorList.get(i).getLectureList().get(j).getLectureName().equals(lectureName)){
					
							System.out.println("강의 이름:"+professorList.get(i).getLectureList().get(j).getLectureName()
							+"강의 시작 시간 : " +professorList.get(i).getLectureList().get(j).getLectureST());
					}
					
				}
			}
		
		}
		return true;
	}

	@Override //교수 id를 입력받고 교수가 가지고 있는 강의들 중에 강의를 선택해서 그 강의를 듣는 학생들의 이름 조회
				
	public boolean  searchStudentNameFromLecture(String professorId, String lectureName) {
		
		if(professorList == null || professorList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		
		// Professor tmp = new Professor(professorId); 를 선언한 뒤 넣어준것과 같다
		// professorList에서 professorId를 갖는 교수를 Professor tmp라고 선언
		// Professor tmp2 = professorList.get(professorList.indexOf(new Professor(professorId)));
		// tmp2교수의 강의리스트중 i번지 강의 이름이 lectureName과 같은가
		// 강의를 특정하고 학생 리스트를 가져와서 for문 j 사용 
		// j학생의 강의 리스트에 특정한 강의가 포함 된다면 출력
		
		for(int i=0; i<lectureList.size(); i++){
			

			if(lectureList.get(i).getProfessorID().equals(professorId)){ //강의 리스트에 있는 교수의 번호와 내가 입력한 교수 번호가 일치한다면
				
				for(int j=0; j<studentList.size(); j++) {
					
					for(int k=0; k<studentList.get(j).getLectureList().size(); k++) {
							
						if(studentList.get(j).getLectureList().get(k).getLectureName().equals(lectureName)){
							
							//학생 리스트에 있는 강의 리스트를 가져오고 그 강의 리스트에 있는 강의 이름과 내가 입력한 강의 이름과 동일하다면
							
							System.out.println("학생 이름 : "+studentList.get(j).getStudentName()); //학생 리스트에 있는 학생 이름을 가져와서 출력해라
							
							
						}
					}

				}
			}
		
		}
		
		return true;
	}
	

	//학생 강의 조회
	@Override
	//입력받은 학생의 강의 점수를 조회
	public boolean searchStudentLectureScore(String studentId, String lectureName) {
		
		if(studentList == null || studentList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		
		for(int i=0; i<studentList.size(); i++) {
			
			if(studentList.get(i).getStudentId().equals(studentId)) { //학생 리스트안에 학생 학번이 사용자가 입력한 학번과 동일하다면
			
				for(int j=0; j<studentList.get(i).getLectureList().size(); j++) {
					
					if(studentList.get(i).getLectureList().get(j).getLectureName().equals(lectureName)){ 
						//입력한 학생의 학번과 동일한 학생의 강의 리스트에서 사용자가 강의 이름을 입력한 것과 동일한 강의 이름이라면
						
						System.out.println("강의 이름 : "+studentList.get(i).getLectureList().get(j).getLectureName() //해당 강의 이름과 해당 강의의 점수를 출력하시오.
								+ "강의 점수 : " + studentList.get(i).getLectureList().get(j).getLectureScore());
								
						
						
					}
				}
			}
		}
		return true;
		
		
	}

	@Override
	//입력받은 학생의 강의 이름과 성적 모두 조회
	public boolean searchStudentAllLecture(String studentId) {
		if(studentList == null || studentList.size() == 0)
		{
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		for(int i=0; i<studentList.size(); i++) {
			
			if(studentList.get(i).getStudentId().equals(studentId)) { //학생 리스트안에 학생 학번이 사용자가 입력한 학번과 동일하다면
						
				for(int j=0; j<studentList.size(); j++) {	//해당 학생의 강의 이름과 강의 성적을 모두 출력
					System.out.println("강의 이름: "+studentList.get(i).getLectureList().get(j).getLectureName() +
							" 강의 성적 : " + studentList.get(i).getLectureList().get(j).getLectureScore());
					
				}
			}
				
			
		}
		
		return true;
	}

	@Override
	//입력받은 학번의 학생이 가지고 있는 강의들의 점수의 평균 조회
	public boolean searchStudentAverageScore(String studentId) {
		int sum_score=0; //학생 강의 점수 합계
		int count=0; //학생 강의 개수 세기
		int average;
		if(studentList == null || studentList.size() == 0) {
			System.out.println("조회할 수 없습니다.");
			return false;
		}
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).getStudentId().equals(studentId)) { //학생 리스트안에 학생 학번이 사용자가 입력한 학번과 동일하다면
				for(int j=0; j<studentList.get(i).getLectureList().size(); j++) { //해당 학생의 강의 리스트의 크기만큼 반복
					sum_score+=studentList.get(i).getLectureList().get(j).getLectureScore(); //학생이 가진 강의의 점수를 sum_score에 합쳐줌
					count++; //학생 강의 개수 만큼 더함	
				}
			}
		}
		average=sum_score/count; //이 학생의 이름을 반복문 안에 넣으면 이름이 반복되어 이름을 특정해서 출력하는 것이 어렵다고 느껴 반복문 밖에 씀
		System.out.println("이 학생의 평균은 : "+average);
		return true;
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
		//equals, contains, indexOf
		/*
		var str = "abc";
		if(str == "abcd")
		if(str.equals("abc"))
		if(str.contains("ac")) 
		*/
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
  @Override
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
		for(int i=0 ;i<tmp.getLectureList().size(); i++) {
			if(tmp.getLectureList().get(i).getLectureName().equals(lectureList.get(index).getLectureName())) {
				errorCode = 5;
				prsi.printSignUpError(errorCode);
				return false;
			}
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
		lectureList.get(lectureList.indexOf(tmp.getLectureList().get(index)))
		.setLectureCount(lectureList.get(lectureList.indexOf(tmp.getLectureList().get(index)))
		.getLectureCount()-1);
		studentList.get(studentList.indexOf(tmp)).getLectureList().remove(index);
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
	
	//전공 조회
	@Override
	public boolean searchByMajor(String majorName) {
		if(majorList == null) {
			majorList = new ArrayList<Major>();
		}
		for(int i = 0; i<majorList.size(); i++) {			
			Major major = majorList.get(i);
			if(major.getMajorName().equals(majorName)) {
				System.out.println(major);
				return true;
			}
		}
		return false;
	}
	
	//학번을 받아서 학생 조회(1명)
	@Override
	public boolean searchStudent(String stdId) {
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		for(int i = 0; i<studentList.size(); i++) {
			Student std = studentList.get(i);
			if(std.getStudentId().equals(stdId)) {
				System.out.println(std);
				return true;
			}
		}
		return false;
	}
	
	//학번으로 성적조회
	@Override
	public boolean searchStudentByStudentId(Student tmp) {
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		if(studentList.contains(tmp)) {
			System.out.println(tmp);
			return true;
		}
		return false;
	}
	
	//동명이인 모두 출력
	@Override
	public boolean searchByStudentName(String stdName) {
		
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		
		for(int i = 0; i<studentList.size(); i++) {
			Student std = studentList.get(i);
			if(std.getStudentName().equals(stdName)) {
				System.out.println(std);
				return true;
			}
		}
		return false;
	}
	

	//수강하고있는 학생 전체 출력
	@Override
	public boolean matchLectureWithStudent(Professor tmp, String lectureName) {
		if(lectureList == null || lectureList.size() == 0) {
			return false;
		}
		for(int i = 0; i<tmp.getLectureList().size(); i++) {
			Lecture lecture = tmp.getLectureList().get(i);
			if(lecture.getLectureName().equals(lectureName)) {
				for(int j = 0; j<studentList.size(); j++) {
					Student std = studentList.get(j);
					if(std.getLectureList().contains(lecture)) {
						System.out.println("학번 : "+std.getStudentId() +" 이름 : "+ std.getStudentName() + " 전공 : " + std.getMajor().getMajorName());
						return true;
					}
				}
			}
		}
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
	
	//성적 추가
	@Override
	public boolean insertScore(String studentId, String lectureName, int score) {
		for(int i = 0; i < studentList.size(); i++) {
			Student std = studentList.get(i);
			if(std.getStudentId().equals(studentId)) {
				for(int j = 0; j<std.getLectureList().size(); j++) {
					Lecture lecture = std.getLectureList().get(j);
					if(lecture.getLectureName().equals(lectureName)) {
						lecture.setLectureScore(score);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//성적 출력
	@Override
	public boolean printScore(Student tmp, String lectureName) {
		if(lectureList == null || lectureList.size() == 0) {
			return false;	
		}
		for(int j = 0; j<tmp.getLectureList().size(); j++) {
			Lecture lecture = tmp.getLectureList().get(j);
			if(lecture.getLectureName().equals(lectureName)) {
				System.out.println("[강의 : " + lecture.getLectureName() + "] " + "[성적 : " + lecture.getLectureScore() + "]");
				return true;
			}
		}
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
	public boolean updateScore(String studentId,String lectureName,int score) {
		if(lectureList == null || lectureList.size() == 0) {
			return false;	
		}
		for(int i = 0; i < studentList.size(); i++) {
			Student std = studentList.get(i);
			if(std.getStudentId().equals(studentId)) {
				for(int j = 0; j<std.getLectureList().size(); j++) {
					Lecture lecture = std.getLectureList().get(i);
					if(lecture.getLectureScore() < 0 || lecture == null){
						return false;
					}
					if(lecture.getLectureName().equals(lectureName)) {
						lecture.setLectureScore(score);
						return true;
					}
				}
			}
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

	

}

