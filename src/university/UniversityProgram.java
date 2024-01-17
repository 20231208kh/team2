package university;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;
import university.service.PrintService;
import university.service.PrintServiceImp;

public class UniversityProgram implements Program{
	private PrintService printService = new PrintServiceImp();
	Scanner scan = new Scanner(System.in);
	int EXIT = 4;
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
		}while(menu!=EXIT);
	}

	/* 대학생 관리 프로그램을 작성하세요.

	 * - 기본 기능
	 *   - 교수 관리
	 *   교수 정보(이름, 전공)
	 *   - 동명이인 관리
	 *   동명이인이지만 전공은 다르다. 전공별 번호로 구분가능
	 *   동명이인이면서 전공도 같다. 전공 교수님별 고유번호 등록
	 *     - 교수 등록/수정/삭제
	 *   
	 *   
	 *   - 학생 관리
	 *   학생 정보(이름, 학번, 전공)
	 *   - 동명이인 관리
	 *   동명이인이지만 전공은 다르다. 전공별 번호로 구분가능
	 *   동명이인이면서 전공도 같다. 전공별 고유번호(학번) 등록
	 *     - 학생 등록/수정/삭제
	 *   - 과 관리 : 학생 전공은 과, 학부는 없다고 가정
	 *     - 과 등록/수정/삭제
	 *	   - 전공별 정원
	 *
	 *
	 *   - 강의 관리
	 *   등록시 필요 변수
	 *   교수 이름 / 전공 / 시간 / 제목 / 학점 / 학년별
	 *   
	 *   전공별 강의
	 *   - 전공수업 등록시 교수님 번호와 이름을 입력해서 교수님 전공과 다른 전공 선택시 등록 실패
	 *   - 교양수업?..ㅋㅋ
	 *   시간별 관리
	 *   - 교수님 강의 등록시 시간 겹치면(완전히 겹치거나 걸치거나) 등록 실패
	 *   - 교수님 학년별 수업 등록
	 *   
	 *     - 강의 등록/수정/삭제
	 *     - 전공별 강의 등록.
	 *     - 전공 강의별 식별번호
	 *   
	 *   lecture
	 *   
	 *   lectureName , grade(3), score, maxCount, count 
	 *   
	 *   1. 교수 강의등록 lecture(클래스)  -> lectureList -> 학생이랑 공유할건가 아니면 따로 가지고있고 서로 값을 할때마다 수정할것인가 
	 *   
	 *  student (lectureName) 
	 *  
	 *  -> score, maxCount, grade
	 *   
	 *   
	 *   
	 *   
	 *   교수가 [강의] 등록 -> 
	 *   강의 정원, 강의 성적 입력
	 *   
	 *   (0/20) -> (1/20) -> (0/20)
	 *   
	 *   
	 *   
	 *   학생이 [강의]를 신청 ->
	 *   
	 *   학생(강의(성적)) 
	 *   
	 *   신청, 수정, 삭제
	 *   
	 *   
	 *   
	 *   
	 *   - 수강 관리 (정원관리)
	 *   등록시 필요 변수
	 *   교수 이름 / 전공 / 시간 / 제목 / 학점
	 *   
	 *   시간(요일, 시간) 겹치면 신청 실패.
	 *   인원 다 차면 신청 실패.
	 *   무관한 전공(식별번호로 관리) 신청시 신청 실패.
	 *   학점(18학점)다 차면 학점 넘어감
	 *   
	 *     - 수강 신청/성적관리
	 *     - 전공을 선택한다 ->
	 *     - 전공 강의별 등록된 식별번호, 강의명, 출력
	 *     - 출력된 정보 선택
	 *     - 
	 *     
	 *     
	 *   - 조회
	 *     /- 성적 조회/학과 조회 등
	 */
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//교수 메뉴(로그인)
			professorMenu();
			break;
		case 2:
			//학생 메뉴(로그인)
			studentMenu();
			break;
		case 3:
			//학교 메뉴
			universityMenu();
			break;
		case 4:
			//프로그램 종료
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//학교 사용 메뉴
	private void universityMenu() {
		int menu;
		do {
			printService.printUniversityMenu();
			menu = scan.nextInt();
			runUniversityMenu(menu);
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
		int menu;
		do {
			printService.printSearch();
			menu = scan.nextInt();
			runSearch(menu);
		}while(menu != 3);
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
			searchStudentList();
			break;
		case 3:
			//돌아가기
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//학생 조회
	private void searchStudentList() {
		int menu;
		do {
			printService.printSearchStudent();
			menu = scan.nextInt();
			runSearchStudentList(menu);
		}while(menu != 3);
	}
	
	//조회 메뉴
	private void runSearchStudentList(int menu) {
		switch(menu) {
		case 1:
			//전체조회
			searchAllStudent();
			break;
		case 2:
			searchByStudentMajor();
			//전공별
				//학년별(1, 2, 3, 4)
				//성적별 이름별 sort가능하지 않을까요
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//전공별 학생 조회
	private void searchByStudentMajor() {
		
	}
	
	//전체 학생 조회
	private void searchAllStudent() {
		
	}

	//교수 조회
	private void searchProfessor() {
		int menu;
		do {
			printService.printSearchProfessor();
			menu = scan.nextInt();
			runSearchProfessor(menu);
		}while(menu != 3);
	}

	private void runSearchProfessor(int menu) {
		switch(menu) {
		case 1:
			//전체조회
			searchAllProfessor();
			break;
		case 2:
			searchByProfessorMajor();
			//전공별
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//전공별 조회
	private void searchByProfessorMajor() {
		//전공별 조회
	}

	//전체 조회
	private void searchAllProfessor() {
		
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
			//전공 추가
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
	
	//전공 삭제
	private void deleteMajor() {
		
	}
	
	//전공 수정
	private void updateMajor() {
		
	}
	
	//전공 추가
	private void addMajor() {
		
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
			//학생 추가
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
	
	//학생 삭제
	private void deleteStudent() {
		
	}
	
	//학생 수정
	private void updateStudent() {
		
	}
	
	//학생 추가
	private void addStudent() {
		
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
	
	//교수관리실행
	private void runManageProfessor(int menu) {
		switch(menu) {
		case 1:
			//교수 추가
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
	
	//교수 삭제
	private void deleteProfessor() {
		
	}
	
	//교수 수정
	private void updateProfessor() {
		
	}
	
	//교수 추가
	private void addProfessor() {
		
	}
	
	//학생 사용 메뉴
	private void studentMenu() {
		int menu;
		do {
			printService.printStudentMenu();
			menu = scan.nextInt();
			runStudentMenu(menu);
		}while(menu != 4);
	}
	
	//학생 사용 메뉴 실행
	private void runStudentMenu(int menu) {
		switch(menu) {
		case 1:
			manageSingUp();
			break;
		case 2:
			break;
		case 3:
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
			break;
		case 2:
			//정정
			break;
		case 3:
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//교수 사용 메뉴
	private void professorMenu() {
		int menu;
		do {
			printService.printProfessorMenu();
			menu = scan.nextInt();
			runProfessorMenu(menu);
		}while(menu != 4);
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
		}while(menu != 5);
	}

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
			//성적 관리(성적관리 들어가면 1. 성적등록 / 2. 성적수정)
			manageScore();
			break;
		case 5:
			//돌아가기
			System.out.println("돌아가기.");
		default:
			throw new InputMismatchException();
		}
	}
	
	//강의 삭제
	private void deleteLecture() {
		
	}

	//강의 수정
	private void updateLecture() {
		
	}
	
	//강의 추가
	private void addLecture() {
		
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
	
	//성적 수정
	private void updateScore() {
		
	}
	
	//성적 등록
	private void insertScore() {
		
	}
	
	@Override
	public void printMenu() {
		printService.printMenu();
	}

}
