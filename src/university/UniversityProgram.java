package university;

import java.util.InputMismatchException;
import java.util.List;
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
			//돌아가기
			System.out.println("돌아가기.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//학생 조회
	private void searchStudent() {
		
	}
	
	//교수 조회
	private void searchProfessor() {
		
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
		System.out.print("등록할 교수 이름 : ");
		String professorName = scan.next();
		System.out.print("등록할 교수 ID : ");
		String professorID = scan.next();
		System.out.print("등록할 교수 전공 : ");
		String professorMajor = scan.next();
		if(usi.addProfessor(professorName, professorID, professorMajor)) {
			System.out.println(professorName+"교수 등록 완료");
			return;
		}
		System.out.println("등록된 ID 입니다.");
	}
	
	//교수 수정 실행
	private void runUpdateProfessor(int subMenu) {
		System.out.print("수정할 교수의 ID 입력 : ");
		String professorID = scan.next();
		Professor tmp = usi.selectUpdateProfessor(professorID);
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
			System.out.print(tmp.getProfessorName()+"교수의 수정할 전공 : ");
			String newMajor = scan.next();
			if(usi.updateProfessorMajor(tmp, newMajor)) {
				System.out.println("전공이 수정되었습니다 : " + newMajor);
				return;
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
		printService.printProfessorList();
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
	private void addLecture(String professorID) {
		scan.nextLine();
		System.out.print("등록할 강의 명 : ");
		String lectureName = scan.nextLine();
		System.out.print("최대 수강인원 : ");
		int lectureMaxCount = scan.nextInt();
		System.out.print("강의 요일 : ");
		String lectureDay = ""+scan.next().charAt(0);
		System.out.print("강의 시작 교시 (1~7) : ");
		int lectureST = scan.nextInt();
		System.out.print("강의 시간 (1~3) : ");
		int lectureLT = scan.nextInt();
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

	private void updateLectureDay(Lecture tmpLecture, String professorID) {
		System.out.print("수정할 강의 요일 : ");
		String newLectureDay = ""+scan.next().charAt(0);
		if(usi.updateLectureDay(tmpLecture,  professorID, newLectureDay)) {
			System.out.println("강의 요일 수정에 성공했습니다.");
			return;
		}
		System.out.println("수정하고자 하는 요일에 겹치는 강의가 있습니다.");
	}

	private void updateLectureTime(Lecture tmpLecture, String professorID) {
		System.out.print("수정할 강의 시작교시 : ");
		int newLectureST = scan.nextInt();
		System.out.print("수정할 강의 시간 : ");
		int newLectureLT = scan.nextInt();
		if(usi.updateLectureTime(tmpLecture, professorID, newLectureST, newLectureLT)) {
			System.out.println("강의 요일 수정에 성공했습니다.");
			return;
		}
		System.out.println("수정하고자 하는 시간에 이미 강의가 등록되어 있습니다.");	
	}

	

	//강의 삭제
	private void deleteLecture() {
		
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
