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
	
	//전공별 조회 실행
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
	
	//학생 이름으로 조회
	private void searchStudentName() {
		//학번 입력
		System.out.print("학생 이름 입력 : ");
		String stdName = scan.next();
		//객체 생성
		Student studentName = new Student();
		//serviceimp
		unis.searchByStudentId(studentName);
		return;
		
	}
	
	//학번으로 조회
	private void searchStudentId() {
		//학번 입력
		System.out.print("학번 입력 : ");
		String stdId = scan.next();
		//객체 생성
		Student studentId = new Student();
		//serviceimp
		unis.searchByStudentId(studentId);
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
		unis.searchByMajor(majorName);
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
		
	}
	
	//성적 수정
	private void updateScore() {
		
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
