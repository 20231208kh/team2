package university.service;

public class PrintServiceImp implements PrintService {
	
	@Override
	public void printMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 교수 메뉴");
		System.out.println("2. 학생 메뉴");
		System.out.println("3. 학사 메뉴");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}
	
	@Override
	public void printStudentMenu() {
		System.out.println("-------학생메뉴-------");
		System.out.println("1. 수강신청");
		System.out.println("2. 성적조회");
		System.out.println("3. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printProfessorMenu() {
		System.out.println("-------교수메뉴-------");
		System.out.println("1. 강의관리");
		System.out.println("2. 성적관리");
		System.out.println("3. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printUniversityMenu() {
		System.out.println("-------학사메뉴-------");
		System.out.println("1. 교수 관리");
		System.out.println("2. 학생 관리");
		System.out.println("3. 전공 관리");
		System.out.println("4. 조회");
		System.out.println("5. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}
	
	@Override
	public void printManageProfessor() {
		System.out.println("-------교수관리-------");
		System.out.println("1. 교수 등록");
		System.out.println("2. 교수 수정");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printManageStudent() {
		System.out.println("-------학생관리-------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printManageMajor() {
		System.out.println("-------전공관리-------");
		System.out.println("1. 전공 등록");
		System.out.println("2. 전공 수정");
		System.out.println("3. 전공 삭제");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printManageLecture() {
		System.out.println("-------강의관리-------");
		System.out.println("1. 강의 등록");
		System.out.println("2. 강의 수정");
		System.out.println("3. 강의 삭제");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printManageSignUp() {
		System.out.println("-------수강신청-------");
		System.out.println("1. 수강 신청");
		System.out.println("2. 수강 정정");
		System.out.println("3. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printSearch() {
		System.out.println("--------조회--------");
		System.out.println("1. 교수 조회");
		System.out.println("2. 학생 조회");
		System.out.println("3. 전공 조회");
		System.out.println("4. 강의 조회");
		System.out.println("5. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printManageScore() {
		System.out.println("-------성적메뉴-------");
		System.out.println("1. 성적 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printExitMenu() {
		System.out.println("-----------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("-----------------");
	}
	
	public void printProfessorSearch() {
		System.out.println("--------교수 조회--------");
		System.out.println("1. 교수 전체 조회");
		System.out.println("2. 교수 번호 조회");
		System.out.println("3. 교수 이름 조회");
		System.out.println("4. 교수 강의 조회");
		System.out.println("5. 종료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
		
	}

}