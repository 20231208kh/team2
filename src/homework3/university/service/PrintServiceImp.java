
package homework3.university.service;

public class PrintServiceImp implements PrintService {

	//교수 메뉴 시작
	
	@Override
	public void printMainMenu() {		
		
		System.out.println("-------메뉴-------");
		System.out.println("1. 교수 메뉴");
		System.out.println("2. 학생 메뉴");
		System.out.println("3. 대학교 조회 메뉴 ");
		System.out.println("4.프로그램 종료");
		System.out.print(" 메뉴 선택 : ");
	}

	@Override
	public void printProfessorMenu() {
		
		System.out.println("----교수 메뉴---");
		System.out.println("1. 교수 관리 ");
		System.out.println("2. 교수가 학생에게 주는 성적 관리 ");
		System.out.println("3. 교수 전공 관리 ");
		System.out.println("4. 교수 강의 관리 ");
		System.out.println("5. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
	}
	
	@Override
	public void printProfessorManageMenu(){
		
		System.out.println("----교수 관리---");
		System.out.println("1. 교수 추가");
		System.out.println("2. 교수 수정");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	@Override
	public void printProfessorFixedMenu() {
		
		System.out.println("----교수 수정---");
		System.out.println("1.교수 고유 번호 수정");
		System.out.println("2.교수 나이 수정");
		System.out.println("3.교수 이름 수정");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
	}
	
	
	@Override
	public void printScoreManagementMenu() {
		
		System.out.println("----교수가 학생에게 주는 성적 관리---");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	@Override
	public void printProfessorMajorManageMentMenu() {
		
		System.out.println("----교수 전공 관리---");
		System.out.println("1. 전공 추가");
		System.out.println("2. 전공 수정");
		System.out.println("3. 전공 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	public void printProfessorLectureManagementMenu() {
		
		System.out.println("----교수 강의 관리---");
		System.out.println("1. 강의 추가");
		System.out.println("2. 강의 수정");
		System.out.println("3. 강의 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
		
	}
	
	//교수 메뉴 끝	
	
	//학생 메뉴 시작
	
	@Override
	public void printStudentMenu() {
		
		System.out.println("----학생 메뉴---");
		System.out.println("1. 학생 관리 ");
		System.out.println("2. 학생 수강 강의 관리 ");
		System.out.println("3. 프로그램 종료 ");
		System.out.print("메뉴 선택 : ");
		
	}
	
	@Override
	public void printStudentManagementMenu() {
		
		System.out.println("----학생 관리---");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	@Override
	public void printStudentFixedMenu()
	{
		System.out.println("----학생 수정---");
		System.out.println("1.학생 학번 수정");
		System.out.println("2.학생 나이 수정");
		System.out.println("3.학생 이름 수정");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	@Override
	public void printStudentSubjectsManagementMenu() {
		
		System.out.println("----학생 수강 강의 관리---");
		System.out.println("1. 학생 수강 강의 추가");
		System.out.println("2. 학생 수강 강의 수정");
		System.out.println("3. 학생 수강 강의 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}
	
	//학생 메뉴 끝

	//대학교 조회 메뉴 시작
	@Override
	public void universeSearchMenu()
	{
		System.out.println("----대학교 조회 메뉴----"); 
		System.out.println("1. 전체 조회");
		System.out.println("2. 학생별 조회"); 
		System.out.println("3. 교수별 조회"); 
		System.out.println("4. 뒤로 가기");
		System.out.print(" 메뉴 선택 : ");
		
	}

	@Override
	public void printExit() {
		System.out.println("================");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("================");
	}


	//학생 조회
	@Override
	public void StudentSearchMenu() {
		
	}
	
	//교수 조회
	@Override
	public void professorSearchMenu() {
		
	}
	

	
}