package university.service;



import java.util.List;

import university.Lecture;
import university.Professor;

public class PrintServiceImp implements PrintService {
	

	

	@Override
	public void printMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 교수 메뉴");
		System.out.println("2. 학생 메뉴");
		System.out.println("3. 학사 메뉴");

		System.out.println("4. 프로그램 안내");
		System.out.println("5. 프로그램 종료");
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
		System.out.println("3. 전공 조회");
		System.out.println("4. 강의 조회");
		System.out.println("5. 종료");
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

	
	public void printProfessorSearch() {
		System.out.println("--------교수 조회--------");
		System.out.println("1. 교수 전체 조회");
		System.out.println("2. 교수 이름에 해당하는 교수 강의 조회");
		System.out.println("3. 전공에 해당하는 교수 이름 조회");
		System.out.println("4. 교수 강의에 해당되는 현재 정원 조회");
		System.out.println("5. 돌아가기");
	}

	@Override
	public void printSearchStudentMenu() {
		System.out.println("-----학생조회메뉴-----");
		System.out.println("1. 학번으로 조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("3. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void printSearchMajorMenu() {
		System.out.println("-------전공조회-------");
		System.out.println("1. 전공별 교수 조회");
		System.out.println("2. 전공별 학생 조회");
		System.out.println("3. 전공 정보 조회");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.println("메뉴 선택 : ");
	}


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
	public void printProfessorList(List<Professor> tmp) {
		tmp.stream().forEach(p->{
			System.out.println((tmp.indexOf(p)+1)+". " + p.getProfessorName() + 
			" / 교수전공 [ " + p.getProfessorMajor() + " ] / ID : "+p.getProfessorId());
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
	
	//등록된 강의리스트 출력
	@Override
	public void printLectureList(List<Lecture> tmp) {
		tmp.stream().forEach(l->{
			System.out.println((tmp.indexOf(l)+1)+". " +l);
		});
	}

	@Override
	public void printSignUpError(int errorCode) {
		switch(errorCode) {
		case 1: System.out.println("등록된 강의가 없습니다."); break;
		case 2: System.out.println("번호를 잘못 입력했습니다."); break;
		case 3: System.out.println("시간이 겹치는 강의가 있습니다"); break;
		case 4: System.out.println("신청시 최대 수강 학점을 초과합니다."); break;
		case 5: System.out.println("동일한 과목의 강의를 이미 수강 중 입니다."); break;
		default:
			System.out.println("잘못된 에러코드 : " + errorCode);
		}
	}

	@Override
	public void printDeleteForLecturesError(int errorCode) {
		switch(errorCode) {
		case 1: System.out.println("번호를 잘못 입력했습니다."); break;
		case 2: System.out.println("존재하는 강의가 아닙니다."); break;
		case 3: System.out.println("강의를 등록한 교수가 없습니다."); break;
		default:
			System.out.println("잘못된 에러코드 : " + errorCode);
		}
	}

	@Override
	public void infoProgram() {
		System.out.println("-----------------프로그램 이용안내---------------------");
		System.out.println("1. 학사관리에서, 학생의 추가 혹은 교수의 추가를 위해서는\n전공의 추가가 선행 되어야 한다.");
		System.out.println("2. 학번의 경우 6개의 고유번호를 프로그램이 지정해주고, 이용자가 직접 2자리를 입력한다.");
		System.out.println("   이때, 8개의 번호가 모두 같은 객체가 이미 존재하는 경우를 중복으로 지정한다.");
		System.out.println("3. 학번의 경우 입학년도 4자리는 불변, 나머지 4자리는 가변으로 값의 변경를 필수적으로");
		System.out.println("   요구하는 메서드에서 변경할 수 있다.");
		System.out.println("4. 교수는 객체 생성시에 입력한 id로, 학생은 객체 생성시에 입력한 학번으로 로그인 하여");
		System.out.println("   리스트에 담긴 자신의 객체에 접근할 수 있다.");
		System.out.println("5. 수강신청의 경우, 같은 요일 + 같은 시간에 진행되는 서로 다른 강의를 수강할 수 없다.");
		System.out.println("6. 수강신청의 경우, 강의의 진행 시간 1시간당 1학점으로, 학생은 최대 21학점까지 수강 가능하다.");
	}
	
}


