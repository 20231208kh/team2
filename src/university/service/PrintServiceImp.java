package university.service;


import java.util.List;

import university.Professor;

public class PrintServiceImp implements PrintService {
	UniversityService usi = new UniversityServiceImp();

	
	@Override
	public void printMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 교수 메뉴");
		System.out.println("2. 학생 메뉴");
		System.out.println("3. 학사 메뉴");
		System.out.println("4. 프로그램 종료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void printStudentMenu() {
		System.out.println("-------학생메뉴-------");
		System.out.println("1. 수강신청");
		System.out.println("2. 성적조회");
		System.out.println("3. 뒤로가기");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printProfessorMenu() {
		System.out.println("-------교수메뉴-------");
		System.out.println("1. 강의관리");
		System.out.println("2. 성적관리");
		System.out.println("3. 뒤로가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printUniversityMenu() {
		System.out.println("-------학사메뉴-------");
		System.out.println("1. 교수 관리");
		System.out.println("2. 학생 관리");
		System.out.println("3. 전공 관리");
		System.out.println("4. 조회");

		System.out.println("5. 뒤로 가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void printManageProfessor() {
		System.out.println("-------교수관리-------");
		System.out.println("1. 교수 등록");
		System.out.println("2. 교수 수정");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printUpdateProfessor() {
		System.out.println("-------교수수정-------");
		System.out.println("1. 교수 이름 수정");
		System.out.println("2. 교수 ID 수정");
		System.out.println("3. 교수 전공 수정");
		System.out.println("4. 뒤로가기");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printManageStudent() {
		System.out.println("-------학생관리-------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");

		System.out.println("4. 뒤로 가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printManageMajor() {
		System.out.println("-------전공관리-------");
		System.out.println("1. 전공 등록");
		System.out.println("2. 전공 수정");
		System.out.println("3. 전공 삭제");

		System.out.println("4. 뒤로 가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printManageLecture() {
		System.out.println("-------강의관리-------");
		System.out.println("1. 강의 등록");
		System.out.println("2. 강의 수정");
		System.out.println("3. 강의 삭제");

		System.out.println("4. 뒤로 가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printManageSignUp() {
		System.out.println("-------수강신청-------");
		System.out.println("1. 수강 신청");

		System.out.println("2. 수강 취소");
		System.out.println("3. 뒤로가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printSearch() {
		System.out.println("--------조회--------");
		System.out.println("1. 교수 조회");
		System.out.println("2. 학생 조회");

		System.out.println("3. 뒤로가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printManageScore() {
		System.out.println("-------성적메뉴-------");
		System.out.println("1. 성적 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 뒤로 가기");

		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printExitMenu() {
		System.out.println("-----------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("-----------------");
	}

	@Override

	public void manageUpdateStudent() {
		System.out.println("-------학생 수정-------");
		System.out.println("1. 이름 수정");
		System.out.println("2. 나이 수정");
		System.out.println("3. 학년 수정");
		System.out.println("4. 전공 수정");
    System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
  }
    
	//등록된 교수 번호 붙어 출력
	public void printProfessorList() {
		usi.sendProfessorList().stream().forEach(p->{
			System.out.println((usi.sendProfessorList().indexOf(p)+1)+". " + p.getProfessorName() + " / 담당학과 : " 
			+ p.getPorfessorBTM().getMajorName()+" / 교수전공 : " + p.getProfessorMajor() + " / ID : "+p.getProfessorId());
		});
	}

	@Override
	//등록된 전공 번호 붙여 출력
	public void printMajorList() {
		usi.sendMajorList().stream().forEach(m->{
			System.out.println((usi.sendMajorList().indexOf(m)+1) + ". " + m.getMajorName());
		});
	}

	@Override
	public void printManageUpdateLecture() {
		System.out.println("-------강의수정-------");
		System.out.println("1. 강의명 수정");
		System.out.println("2. 최대 수강인원 수정");
		System.out.println("3. 강의 요일 수정");
		System.out.println("4. 강의 시간 수정");
		System.out.println("5. 뒤로가기");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
		
	}


	//교수별 등록된 강의 출력
	@Override
	public void printProfessorLectureList(Professor tmp) {
		tmp.getLectureList().stream().forEach(l->{
			System.out.println((tmp.getLectureList().indexOf(l)+1)+". " +l);
		});
	}
}

