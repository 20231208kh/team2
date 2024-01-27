package university;


import java.text.DecimalFormat;


import java.util.InputMismatchException;


import java.util.Scanner;

import program.Program;
import university.service.PrintService;
import university.service.PrintServiceImp;
import university.service.UniversityService;
import university.service.UniversityServiceImp;

public class UniversityProgram implements Program{

	

	private PrintService printService = new PrintServiceImp();
	private UniversityService usi = new UniversityServiceImp();
	Scanner scan = new Scanner(System.in);
	private final int EXIT_PROGRAM = 5;

	
	@Override
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e){
				System.out.println("잘못된 메뉴 선택입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT_PROGRAM);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//교수 메뉴
			professorMenu();
			break;
		case 2:
			//학생 메뉴
			studentMenu();
			break;
		case 3:
			//학교 메뉴
			universityMenu();
			break;
		case 4:
			//프로그램 안내
			infoProgram();
			break;
		case 5:
			//프로그램 종료
			printService.printExitMenu();
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	private void infoProgram() {
		
		printService.infoProgram();
		
	}

	//학교 사용 메뉴
	private void universityMenu() {
		int menu = 0;
		do {
			printService.printUniversityMenu();
			try {
				menu = scan.nextInt();
				runUniversityMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다.");
				scan.nextLine();
			}
		}while(menu != 5);
	}
	
	//학교 사용 메뉴 실행
	private void runUniversityMenu(int menu) {
		switch(menu) {
		case 1:
			//교수관리
			manageProfessor();
			break;
		case 2:
			//학생관리
			manageStudent();
			break;
		case 3:
			//전공관리
			manageMajor();
			break;
		case 4:
			//조회
			search();
			break;
		case 5:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//조회
	private void search() {
		int menu = 0;
		do {
			printService.printSearch();
			try {
				menu = scan.nextInt();
				runSearch(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다.");
				scan.nextLine();
			}
		}while(menu != 5);
	}
	
	//조회 실행
	private void runSearch(int menu) {
		switch(menu) {
		case 1:
			//교수 조회
			searchProfessor();
			break;
		case 2:
			//학생 조회
			searchStudent();
			break;
		case 3:
			//전공 조회
			searchMajor();
			//1. 교수
			//2. 학생
			//3. 전공
			break;
		case 4:
			//강의 조회
			searchLecture();
			break;
		case 5:
			//돌아가기
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}


	//학생 조회
	private void searchStudent() {
		int menu = 0;
		do {
			printService.printSearchStudentMenu();
			menu = scan.nextInt();
			runSearchStudent(menu);				
		}while(menu != 3);
	}
	
	private void runSearchStudent(int menu) {
		switch(menu) {
		case 1:
			//학번으로 조회
			searchStudentId();
			break;
		case 2:
			//이름으로 조회
			searchStudentName();
			break;
		case 3:
			//돌아가기
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//학번으로 1명 조회
	private void searchStudentId() {
		//학번 입력
		System.out.print("학번 입력 : ");
		String stdId = scan.next();
		//객체 생성
		Student student = new Student(stdId);
		//serviceimp
		if(!usi.searchStudent(student)) {
			System.out.println("일치하는 학생이 없습니다.");
		}
		return;
	}
	
	//이름 중복되는 학생들 전체조회
	private void searchStudentName() {
		//이름 입력
		System.out.print("학생 이름 입력 : ");
		String stdName = scan.next();
		//객체 생성
		Student student = new Student(stdName);
		//serviceimp
		if(!usi.searchByStudentName(student)) {
			System.out.println("일치하는 학생이 없습니다.");
		}
		return;
	}

	//전공 조회
	private void searchMajor() {
		//전공명 입력
		scan.nextLine();
		System.out.print("전공명 입력 : ");
		String mName = scan.next();
		//객체 생성
		Major majorName = new Major(mName);
		//serviceimp
		if(!usi.searchByMajor(majorName)) {
			System.out.println("일치하는 전공이 없습니다.");
		}
		return;
	}


	//교수 조회
	private void searchProfessor() {
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			searchAllProfessor();
			break;
		case 2:
			searchProfessorByName();
			break;
		case 3:
			searchProfessorById();
			break;
		case 4:
			searchProfessorByMajor();
			break;
		case 5:
			System.out.println("뒤로 가기");
			break;
		default:
			throw new InputMismatchException();
			
		}
	}

	
	

	//강의 조회
	private void searchLecture() {
    
  }

	private void searchAllProfessor() {
//		usi.searchAllProfessor();
		
	}

	private void searchProfessorByName() {
//		usi.searchProfessorByName();
		
	}

	private void searchProfessorById() {
//		usi.searchProfessorById();
		
	}

	private void searchProfessorByMajor() {
//		usi.searchProfessorByMajor();

		
	}

	//전공 관리
	private void manageMajor() {
		int menu;
		do {
			printService.printManageMajor();
			menu = scan.nextInt();
			runManageMajor(menu);
		}while(menu != 4);
	}
	
	//전공 관리 실행
	private void runManageMajor(int menu) {
		switch(menu) {
		case 1:
			//전공 등록
			addMajor();
			break;
		case 2:
			//전공 수정
			updateMajor();
			break;
		case 3:
			//전공 삭제
			deleteMajor();
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");

			break;

		default:
			throw new InputMismatchException();
		}
	}
	
	//전공 추가
	private void addMajor() {
		System.out.print("전공 이름 : ");
		scan.nextLine();
		String majorName = scan.nextLine();
		System.out.print("전공 번호 : ");
		int num = scan.nextInt();
		DecimalFormat df = new DecimalFormat("00");
		String majorNum = df.format(num);
		Major major = new Major(majorName,majorNum);
		if(usi.addMajor(major)) {
			System.out.println("전공 등록 성공!");
			return;
		}
		System.out.println("전공 등록 실패");
	}
	
	//전공 수정
	private void updateMajor() {

		if(usi.getMajor().size()<=0) {
			System.out.println("등록된 전공이 없습니다.");
			return;
		}
		System.out.println("--전공 수정(전공이름 수정)--");
		usi.printMajorList();
		System.out.print("수정할 전공 번호 : ");
		String majorId = scan.next();
		Major major = new Major(majorId);
		if(!usi.getMajor().contains(major)) {
			System.out.println("등록되지 않은 전공입니다.");
			return;
		}
		System.out.print("전공 이름 입력(수정) : ");
		String majorTitle = scan.next();
		if(usi.updateMajor(major,majorTitle)) {
			System.out.println("전공 이름 수정 성공!");
			return;
		}
		System.out.println("전공 이름 수정 실패");
		
	

	}
	
	//전공 삭제
	private void deleteMajor() {

		if(usi.getMajor().size()<=0) {
			System.out.println("등록된 전공이 없습니다.");
			return;
		}
		usi.printMajorList();
		System.out.print("삭제할 전공 번호 : ");
		String majorId = scan.next();
		
		Major major = new Major(majorId);
		if(usi.deleteMajor(major)) {
			System.out.println("전공 삭제 성공!");
			return;
		}
		System.out.println("전공 삭제 실패");

		
	}

	//학생 관리
	private void manageStudent() {
		int menu;
		do {
			printService.printManageStudent();
			menu = scan.nextInt();
			runManageStudent(menu);
		}while(menu != 4);
	}
	
	//학생 관리 실행
	private void runManageStudent(int menu) {
		switch(menu) {
		case 1:
			//학생 등록
			addStudent();
			break;
		case 2:
			//학생 수정
			updateStudent();
			break;
		case 3:
			//학생 삭제
			deleteStudent();
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");

			break;


		default:
			throw new InputMismatchException();
		}
	}
	
	//학생 등록
	private void addStudent() {
		if(usi.getMajor().size()<=0) {
			System.out.println("전공을 먼저 등록해주세요.");
			return;
		}
		System.out.print("학생 이름 : ");
		String studentName = scan.next();
		System.out.print("입학 연도 : ");
		int year = scan.nextInt();
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("나이 : ");
		int studentAge = scan.nextInt();
		
		usi.printMajorList();
		System.out.print("전공 선택 : ");
		int index = scan.nextInt();
		System.out.print("학번 마지막 두자리 입력 : ");
		String lastNum = scan.next();
		
		try{
			Major major = usi.getMajor().get(index-1);
			Student student = new Student(studentName,grade,year,studentAge,major,lastNum);
			if(usi.addStudent(student)) {
				System.out.println("학생 등록 성공 !");
				return;
			}
			System.out.println("중복된 학번 입력입니다.");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("목록에 없는 전공 선택");
			return;
		}	

	}
	
	//학생 수정
	private void updateStudent() {

		//학번 입력
		System.out.print("수정할 학생의 학번을 입력 : ");
		//인스턴스 생성
		String studentId = scan.next();
		Student student = new Student(studentId);
		if(!usi.getStudent().contains(student)) {
			System.out.println("잘못된 학번 입력");
			return;
		}
		//이름,나이,학년,전공 수정 택1
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1.이름\n2.나이\n3.학년\n4.전공");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			System.out.print("학생 이름 입력(수정) : ");
			String studentName = scan.next();
			if(usi.updateStudentName(student, studentName)) {
				System.out.println("학생 이름 수정 성공!");
				return;
			}
			System.out.println("학생 이름 수정  실패");
			break;
		case 2:
			System.out.print("학생 나이 입력(수정) : ");
			int studentAge = scan.nextInt();
			if(usi.updateStudentAge(student, studentAge)) {
				System.out.println("학생 나이 수정 성공!");
				return;
			}
			System.out.println("학생 나이 수정 실패");
			break;
		case 3:
			System.out.print("학생 학년 입력(수정) : ");
			int grade = scan.nextInt();
			if(usi.updateStudentGrade(student, grade)) {
				System.out.println("학생 학년 수정 성공!");
				return;
			}
			System.out.println("학생 학년 수정 실패");
			break;
		case 4:
			try {
			usi.printMajorList();
				System.out.print("학생 전공 선택(수정) : ");
				int index = scan.nextInt();
				Major major = usi.getMajor().get(index-1);
				if(usi.updateStudentMajor(student,major)) {
					return;
				}
				
				break;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("목록에 없는 전공 선택");
				break;
			}
		default:
			throw new InputMismatchException();
		}
		

		
	}
	
	//학생 삭제
	private void deleteStudent() {

		System.out.print("삭제할 학생의 학번을 입력 : ");
		String studentId = scan.next();
		Student student = new Student(studentId);
		if(usi.deleteStudent(student)) {
			System.out.println("삭제 성공 !");
			return;
		}
		System.out.println("삭제 실패");

	}
	
	//교수 관리
	private void manageProfessor() {
		int menu;
		do {
			printService.printManageProfessor();
			menu = scan.nextInt();
			runManageProfessor(menu);
		}while(menu != 4);
		
	}
	
	//교수 관리 실행
	private void runManageProfessor(int menu) {
		switch(menu) {
		case 1:
			//교수 등록
			addProfessor();
			break;
		case 2:
			//교수 수정

			printService.printUpdateProfessor();
			int subMenu = scan.nextInt();
			runUpdateProfessor(subMenu);

			break;
		case 3:
			//교수 삭제
			deleteProfessor();
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");

			break;

		default:
			throw new InputMismatchException();
		}
	}
	
	//교수 추가
	private void addProfessor() {
		if(usi.getMajor().size() <=0) {
			System.out.println("전공을 먼저 등록해주세요.");
			return;
		}
		
		System.out.print("등록할 교수 이름 : ");
		String professorName = scan.next();
		System.out.print("등록할 교수 ID : ");
		String professorID = scan.next();
		usi.printMajorList();
		System.out.print("등록할 교수 전공 선택 : ");
		int index = scan.nextInt();
		try {
			Major professorMajor = usi.getMajor().get(index-1);
			if(usi.addProfessor(professorName, professorID, professorMajor)) {
				System.out.println(professorName+"교수 등록 완료");
				return;
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("목록에 없는 전공 선택");
		}
		System.out.println("등록된 ID 입니다.");
	}
	
	//교수 수정 실행
	private void runUpdateProfessor(int subMenu) {
		Professor tmp = null;
		if(subMenu<4 && 0<subMenu) {
			System.out.print("수정할 교수의 ID 입력 : ");
			String professorID = scan.next();
			tmp = usi.selectUpdateProfessor(professorID);
			if(tmp == null) {
				System.out.println(professorID+"로 등록된 교수가 없습니다.");
				return;
			}
		}
		switch(subMenu) {
		case 1:
			System.out.print(tmp.getProfessorName()+"교수의 수정할 이름 : ");
			String newName = scan.next();
			if(usi.updateProfessorName(tmp, newName)) {
				System.out.println(newName +"로 이름이 수정되었습니다.");
				return;
			}
			System.out.println("이름 수정에 실패했습니다.");
			break;
		case 2: 
			System.out.print(tmp.getProfessorName()+"교수의 수정할 ID : ");
			String newID = scan.next();
			if(usi.updateProfessorID(tmp, newID)) {
				System.out.println("ID가 "+newID +"로 수정되었습니다.");
				return;
			}
			System.out.println("ID 수정에 실패했습니다.");
			break;
		case 3: 
			usi.printMajorList();
			System.out.print("수정할 전공 선택 : ");
			int index = scan.nextInt();
			try {
				Major professorMajor = usi.getMajor().get(index-1);
				if(usi.updateProfessorMajor(tmp, professorMajor)) {
					System.out.println("전공이 수정되었습니다 : " + professorMajor);
					return;
				}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("목록에 없는 전공 선택");
				break;
			}
			System.out.println("전공 수정에 실패했습니다.");
			break;
		case 4: 
			System.out.println("메인 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}

	}
	
	//교수 삭제
	private void deleteProfessor() {

		printService.printProfessorList(usi.sendProfessorList());
		System.out.print("삭제할 교수의 번호를 입력해주세요 : ");
		int num = scan.nextInt();
		if(usi.deleteProfessor(num)) {
			System.out.println("삭제 됐습니다.");
			return;
		}
		System.out.println("삭제에 실패했습니다.");

	}
	
	//학생 사용 메뉴
	private void studentMenu() {
		int menu;
		System.out.print("학번을 입력해주세요 : ");
		String studentID = scan.next();
		Student tmp = usi.selectStudent(studentID);
		if(usi.isStudentID(studentID) && tmp != null) {
			System.out.println("로그인 성공");
			do {
				printService.printStudentMenu();
				menu = scan.nextInt();
				runStudentMenu(menu ,tmp);
			}while(menu != 3);
			return;
		}
		System.out.println("로그인 실패");

	}
	
	//학생 사용 메뉴 실행
	private void runStudentMenu(int menu, Student tmp) {
		switch(menu) {
		case 1:
			//수강 관리
			manageSingUp(tmp);
			break;
		case 2:
			//성적 조회
			searchScore();
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
		}
	}

	//수강 관리

	private void manageSingUp(Student tmp) {
		int menu;
		do {
			printService.printManageSignUp();
			menu = scan.nextInt();

			runManageSignUp(menu, tmp);

		}while(menu != 3);
	}
	
	//수강 관리 실행

	private void runManageSignUp(int menu, Student tmp) {
		switch(menu) {
		case 1:
			//수강 신청
			signUpForLectures(tmp);
			break;
		case 2:
			//수강 취소
			deleteForLectures(tmp);

			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	


	//수강 신청
	private void signUpForLectures(Student tmp) {
		
		System.out.println("-------수강신청--------");
		//강의리스트 전체 출력
		printService.printLectureList(usi.sendLectureList());
		System.out.print("수강신청 할 강의 : ");
		int index = scan.nextInt() - 1;
		if(usi.signUpForLectures(index, tmp)) {
			System.out.println("수강신청 성공");
			return;
		}
		System.out.println("수강신청 실패");
	}
	
	//수강 취소
	private void deleteForLectures(Student tmp) {
		if(tmp.getLectureList().size()==0 || tmp.getLectureList()== null) {
			System.out.println("수강신청한 강의가 없습니다");
			return;
		}
		System.out.println("-------수강취소--------");
		printService.printLectureList(tmp.getLectureList());
		System.out.print("수강취소 할 강의 : ");
		int index = scan.nextInt() - 1;
		if(usi.deleteForLectures(index, tmp)) {
			System.out.println("수강취소 성공");
			return;
		}
		System.out.println("수강취소 실패");
	}

	
	//성적 조회
	private void searchScore() {

		//학번 입력
		System.out.print("학번 입력 : ");
		String stdId = scan.next();
		//객체 생성
		Student studentId = new Student(stdId);
		//serviceimp
		if(!usi.searchStudent(studentId)) {
			System.out.println("등록되지 않은 학번입니다.");
		};
		return;
	}

	
	//교수 사용 메뉴
	private void professorMenu() {
		int menu;
		System.out.print("아이디를 입력해주세요 : ");
		String professorID = scan.next();
		if(usi.isProfessorID(professorID)) {
			System.out.println("로그인 성공");
			do {
				printService.printProfessorMenu();
				menu = scan.nextInt();
				runProfessorMenu(menu , professorID);
			}while(menu != 3);
			return;
		}
		System.out.println("로그인 실패");
	}
	
	//교수 사용 메뉴 실행
	private void runProfessorMenu(int menu, String professorID) {
		switch(menu) {
		case 1:
			//강의 관리
			manageLecture(professorID);
			break;
		case 2:
			//성적 관리
			manageScore(professorID);
			break;
			//내 강의를 듣고있는 학생 전체 출력
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	//강의 관리
	private void manageLecture(String professorID) {

		int menu;
		do {
			printService.printManageLecture();
			menu = scan.nextInt();

			runManageLecture(menu, professorID);
		}while(menu != 4);
	}
	
	//강의 관리 실행
	private void runManageLecture(int menu, String professorID) {
		switch(menu) {
		case 1:
			//강의 등록
			addLecture(professorID);
			break;
		case 2:
			//강의 수정
			manageUpdateLecture(professorID);
			break;
		case 3:
			//강의 삭제
			deleteLecture(professorID);
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//강의 등록

	private void addLecture(String professorID) {
		String lectureDay = "";
		int lectureST = 0;
		int lectureLT = 0;
		scan.nextLine();
		System.out.print("등록할 강의명 : ");
		String lectureName = scan.nextLine();
		System.out.print("최대 수강인원 : ");
		int lectureMaxCount = scan.nextInt();
		boolean ok = false;
		while(!ok) {
			System.out.print("강의 요일 : ");
			lectureDay = ""+scan.next().charAt(0);
			switch(lectureDay) {
			case "월", "화", "수", "목", "금": 
				ok = true; 
				break;
			default:
				System.out.println("잘못 입력했습니다");
			}
		}
		ok = false;
		while(!ok) {
			System.out.print("강의 시작 교시 (1~7) : ");
			lectureST = scan.nextInt();
			switch(lectureST) {
			case 1, 2, 3, 4, 5, 6, 7: 
				ok = true; 
				break;
			default:
				System.out.println("잘못 입력했습니다");
			}
		}
		ok = false;
		while(!ok) {
			System.out.print("강의 시간 (1~3) : ");
			lectureLT = scan.nextInt();
			switch(lectureLT) {
			case 1, 2, 3: 
				ok = true; 
				break;
			default:
				System.out.println("잘못 입력했습니다");
			}
		}
		if(usi.addLecture(professorID, lectureName, lectureMaxCount, lectureDay, lectureST, lectureLT)) {
			System.out.println("강의가 등록되었습니다.");
			return;
		}
		System.out.println("강의 등록에 실패했습니다.");
	}

	//강의 수정
	private void manageUpdateLecture(String professorID) {
		Professor tmp = usi.selectUpdateProfessor(professorID);
		if(tmp.getLectureList()==null ||tmp.getLectureList().size() ==0 ) {
			System.out.println("강의를 등록하지 않은 교수입니다.");
			return;
		}
		printService.printProfessorLectureList(tmp);
		System.out.print("수정할 강의 번호 입력 : ");
		int lectureIndex = scan.nextInt()-1;
		Lecture tmpLecture = tmp.lectureList.get(lectureIndex);
		int menu;
		do {
			printService.printManageUpdateLecture();
			menu = scan.nextInt();
			runUpdateLecture(menu , tmpLecture , professorID);
		}while(menu != 5);
	}
	
	private void runUpdateLecture(int menu, Lecture tmpLecture, String professorID) {
		switch(menu) {
		case 1: 
			// 강의명 수정
			updateLectureName(tmpLecture, professorID);
			break;
		case 2: 
			// 최대 수강인원 수정
			updateLectureMaxCount(tmpLecture, professorID);
			break;
		case 3: 
			// 강의 요일 수정
			updateLectureDay(tmpLecture, professorID);
			break;
		case 4: 
			// 강의 시간 수정
			updateLectureTime(tmpLecture, professorID);
			break;
		case 5: 
			// 뒤로가기
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	private void updateLectureName(Lecture tmpLecture, String professorID) {
		scan.nextLine();
		System.out.print("수정할 이름 : ");
		String newLectureName = scan.nextLine();
		usi.updateLectureName(tmpLecture, professorID, newLectureName);
		System.out.println("강의명 수정에 성공했습니다.");
	}

	private void updateLectureMaxCount(Lecture tmpLecture, String professorID) {
		System.out.print("수정할 최대 수강인원 : ");
		int newLectureMaxCount = scan.nextInt();
		if(usi.updateLectureMaxCount(tmpLecture, professorID, newLectureMaxCount)) {
			System.out.println("최대 수강인원 수정에 성공했습니다.");
			return;
		}
		System.out.println("최대 수강인원은 현 수강인원보다 작을 수 없습니다.");
	}

	//강의 요일 수정
	private void updateLectureDay(Lecture tmpLecture, String professorID) {
		if(!usi.isLectureEmpty(tmpLecture)) {
			System.out.println("이미 강의를 등록한 학생이 있어 강의 요일을 변경할 수 없습니다.");
			return;
		}
		String newLectureDay = "";
		boolean ok = false;
		while(!ok) {
			System.out.println("기존 강의 요일 : " + tmpLecture.lectureDay + "요일");
			System.out.print("수정할 강의 요일 : ");
			newLectureDay = ""+scan.next().charAt(0);
			if(newLectureDay.equals(tmpLecture.lectureDay)) {
				System.out.println("기존 강의 요일과 같습니다.");
				continue;
			}
			switch(newLectureDay) {
			case "월", "화", "수", "목", "금": 
				ok = true; 
				break;
			default:
				System.out.println("잘못 입력했습니다");
			}
		}
		if(usi.updateLectureDay(tmpLecture,  professorID, newLectureDay)) {
			System.out.println("강의 요일 수정에 성공했습니다.");
			return;
		}
		System.out.println("수정하고자 하는 요일에 시간이 겹치는 강의가 있습니다.");
	}
	
	//강의 시간 수정
	private void updateLectureTime(Lecture tmpLecture, String professorID) {
		if(!usi.isLectureEmpty(tmpLecture)) {
			System.out.println("이미 강의를 등록한 학생이 있어 강의 시간을 변경할 수 없습니다.");
			return;
		}
		boolean ok = false;
		int newLectureST = 0;
		int newLectureLT = 0;
		while(!ok) {
			System.out.println("기존 강의 시간 : 시작 " + tmpLecture.getLectureST()+ "교시, 종료 " 
								+(tmpLecture.getLectureLT()+tmpLecture.getLectureST()-1)+ "교시, " 
								+ tmpLecture.getLectureLT() + "H");
			System.out.print("수정할 강의 시작교시 (1~7) : ");
			newLectureST = scan.nextInt();
			switch(newLectureST) {
			case 1, 2, 3, 4, 5, 6, 7: 
				break;
			default:
				System.out.println("1에서 7 사이 정수를 입력해주세요");
				continue;
			}
			System.out.print("수정할 강의 시간 (1~3) : ");
			newLectureLT = scan.nextInt();
			if(tmpLecture.getLectureST() == newLectureST && tmpLecture.getLectureLT() == newLectureLT) {
				System.out.println("기존 강의시간과 같습니다");
				continue;
			}
			switch(newLectureLT) {
			case 1, 2, 3: 
				ok = true; 
				break;
			default:
				System.out.println("1에서 3 사이 정수를 입력해주세요");
			}
			
		}
		if(usi.updateLectureTime(tmpLecture, professorID, newLectureST, newLectureLT)) {
			System.out.println("강의 시간 수정에 성공했습니다.");
			return;
		}
		System.out.println("수정하고자 하는 시간에 등록한 강의가 있습니다.");	
	}

	

	//강의 삭제
	private void deleteLecture(String professorID) {
		Professor tmp = usi.selectUpdateProfessor(professorID);
		if(tmp.getLectureList()==null ||tmp.getLectureList().size() ==0 ) {
			System.out.println("강의를 등록하지 않은 교수입니다.");
			return;
		}
		printService.printProfessorLectureList(tmp);
		System.out.print("삭제할 강의 번호 입력 : ");
		int lectureIndex = scan.nextInt()-1;
		Lecture tmpLecture = tmp.lectureList.get(lectureIndex);
		if(!usi.isLectureEmpty(tmpLecture)) {
			System.out.println("강의에 수강 인원이 있어 삭제에 실패했습니다.");
			return;
		}
		if(usi.deleteLecture(tmpLecture, tmp)) {
			System.out.println("선택한 강의가 삭제되었습니다.");
			return;
		}
		System.out.println("강의 삭제에 실패했습니다.");
	}
	
	//성적 관리
	private void manageScore(String professorID) {

		int menu;
		do {
			printService.printManageScore();
			menu = scan.nextInt();

			runManageScore(menu , professorID);

		}while(menu != 3);
	}
	
	//성적 관리 실행

	private void runManageScore(int menu, String professorID) {

		switch(menu) {
		case 1:
			//성적 등록
			insertScore();
			break;
		case 2:
			//성적 수정
			updateScore();
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//성적 등록
	private void insertScore() {
		//Lecture lecture = professorList.get(index).getLectureList.get(0) 
		//교수 강의 출력 메서드(index)
		System.out.print("강의 선택 : ");
		String lectureName = scan.next();
		Lecture lecture = new Lecture(lectureName);
		if(!usi.matchLectureWithStudent(lecture)) {
			System.out.println("등록된 강의가 없습니다.");
		}
		//화학을 등록 -> 화학을 등록한 학생
		//학생list for문으로 돌려서 lecture랑 비교해서 있으면 출력 학생을 고르면
		System.out.print("학번 선택 : ");
		String studentId = scan.next();
		System.out.print("성적 입력 : ");
		int score = scan.nextInt();
		if(!usi.insertScore(studentId,lecture,score)) {
			System.out.println("성적 입력을 실패했습니다.");
		}
		System.out.println("성적 등록 성공!");
		return;
	}
	
	//성적 수정
	private void updateScore() {
		//등록 먼저 해주세요 하는 예외처리마 ㄴ추가되면 될 듯ㅅㅅㅅㅅㅅ
	}
	
	
	//메뉴 출력
	@Override
	public void printMenu() {
		printService.printMenu();
	}
	
	//종료 출력
	@Override
	public void exitMenu() {
		printService.printExitMenu();
	}

}
