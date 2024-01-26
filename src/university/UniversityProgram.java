package university;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;
import university.service.PrintService;
import university.service.PrintServiceImp;
import university.service.UniversityService;
import university.service.UniversityServiceImp;

public class UniversityProgram implements Program{
	private UniversityService unis = new UniversityServiceImp();
	private PrintService printService = new PrintServiceImp();
	Scanner scan = new Scanner(System.in);
	int EXIT_PROGRAM = 4;
	
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
			//프로그램 종료
			printService.printExitMenu();
			break;
		default:
			throw new InputMismatchException();
		}
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
		if(!unis.searchStudent(student)) {
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
		if(!unis.searchByStudentName(student)) {
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
		if(!unis.searchByMajor(majorName)) {
			System.out.println("일치하는 전공이 없습니다.");
		}
		return;
	}

	//교수 조회
	private void searchProfessor() {
		
	}
	
	//강의 조회
	private void searchLecture() {
		
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
		String majorNum = scan.next();
		Major major = new Major(majorName,majorNum);
		if(unis.addMajor(major)) {
			System.out.println("전공 등록 성공!");
			return;
		}
		System.out.println("전공 등록 실패");
	}
	
	//전공 수정
	private void updateMajor() {
		
	}
	
	//전공 삭제
	private void deleteMajor() {
		
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
		default:
			throw new InputMismatchException();
		}
	}
	
	//학생 등록
	private void addStudent() {
		System.out.print("학생 이름 입력 : ");
		scan.nextLine();
		String studentName = scan.nextLine();
		System.out.print("학번 입력 : ");
		String studentId = scan.next();
		Student student = new Student(studentName,studentId);
		if(unis.addStudent(student)) {
			System.out.println("학생 등록 성공!");
			return;
		}
		System.out.println("학생 등록 실패");
	}
	
	//학생 수정
	private void updateStudent() {
		
	}
	
	//학생 삭제
	private void deleteStudent() {
		
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
			updateProfessor();
			break;
		case 3:
			//교수 삭제
			deleteProfessor();
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");
		default:
			throw new InputMismatchException();
		}
	}
	
	//교수 추가
	private void addProfessor() {
		
	}
	
	//교수 수정
	private void updateProfessor() {
		
	}
	
	//교수 삭제
	private void deleteProfessor() {
		
	}
	
	//학생 사용 메뉴
	private void studentMenu() {
		int menu;
		do {
			printService.printStudentMenu();
			menu = scan.nextInt();
			runStudentMenu(menu);
		}while(menu != 3);
	}
	
	//학생 사용 메뉴 실행
	private void runStudentMenu(int menu) {
		switch(menu) {
		case 1:
			//수강 관리
			manageSingUp();
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
	private void manageSingUp() {
		int menu;
		do {
			printService.printManageSignUp();
			menu = scan.nextInt();
			runManageSignUp(menu);
		}while(menu != 3);
	}
	
	//수강 관리 실행
	private void runManageSignUp(int menu) {
		switch(menu) {
		case 1:
			//수강 신청
			signUpForLectures();
			break;
		case 2:
			//수강 정정
			updateForLectures();
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//수강 신청
	private void signUpForLectures() {
		
	}
	
	//수강 정정
	private void updateForLectures() {
		
	}
	
	//성적 조회
	private void searchScore() {
		//학번 입력
		System.out.print("학번 입력 : ");
		String stdId = scan.next();
		//객체 생성
		Student studentId = new Student(stdId);
		//serviceimp
		if(!unis.searchStudent(studentId)) {
			System.out.println("등록되지 않은 학번입니다.");
		};
		return;
	}
	
	//교수 사용 메뉴
	private void professorMenu() {
		int menu;
		do {
			printService.printProfessorMenu();
			menu = scan.nextInt();
			runProfessorMenu(menu);
		}while(menu != 3);
	}
	
	//교수 사용 메뉴 실행
	private void runProfessorMenu(int menu) {
		switch(menu) {
		case 1:
			//강의 관리
			manageLecture();
			break;
		case 2:
			//성적 관리
			manageScore();
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
	private void manageLecture() {
		int menu;
		do {
			printService.printManageLecture();
			menu = scan.nextInt();
			runManageLecture(menu);
		}while(menu != 4);
	}
	
	//강의 관리 실행
	private void runManageLecture(int menu) {
		switch(menu) {
		case 1:
			//강의 등록
			addLecture();
			break;
		case 2:
			//강의 수정
			updateLecture();
			break;
		case 3:
			//강의 삭제
			deleteLecture();
			break;
		case 4:
			//돌아가기
			System.out.println("돌아가기.");
		default:
			throw new InputMismatchException();
		}
	}
	
	//강의 등록
	private void addLecture() {
		
	}

	//강의 수정
	private void updateLecture() {
		
	}
	
	//강의 삭제
	private void deleteLecture() {
		
	}
	
	//성적 관리
	private void manageScore() {
		int menu;
		do {
			printService.printManageScore();
			menu = scan.nextInt();
			runManageScore(menu);
		}while(menu != 3);
	}
	
	//성적 관리 실행
	private void runManageScore(int menu) {
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
		if(!unis.matchLectureWithStudent(lecture)) {
			System.out.println("등록된 강의가 없습니다.");
		}
		//화학을 등록 -> 화학을 등록한 학생
		//학생list for문으로 돌려서 lecture랑 비교해서 있으면 출력 학생을 고르면
		System.out.print("학번 선택 : ");
		String studentId = scan.next();
		Student student = new Student(studentId);
		System.out.print("성적 입력 : ");
		int lectureScore  = scan.nextInt();
		Lecture lecture = new Lecture(lectureScore);
		if(!unis.insertScore(studentId, lecture)) {
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
