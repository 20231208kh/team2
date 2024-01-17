package homework3.university;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homework3.university.service.PrintServiceImp;
import program.Program;

public class UniversityProgram implements Program{
	private Scanner scan=new Scanner(System.in);
	private final int EXIT=4;	
	private  PrintServiceImp printService = new PrintServiceImp();	// 메뉴판 클래스
	
	
	@Override
	public void run() {
		
		int menu=0;
		
		do {
			printMenu();
			try {
				menu=scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e)
			{
					System.out.println("잘못된 메뉴 선택입니다.");
					scan.nextLine();
			}
		}while(menu!=EXIT);
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			professorMenu(); //교수 메뉴
			break;
		case 2:
			studentMenu(); // 학생 메뉴
			break;
		case 3:
			universeSearchMenu(); // 대학교 조회 메뉴
			break;
		case 4:
			exitMenu(); //프로그램 종료
			break;
		default:
			throw new InputMismatchException();
		}
		
		
	}

	private void professorMenu() { //교수 메뉴 
		
		printService.printProfessorMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
			case 1:
				professorManagement();
				break;
			case 2:
				professorGiveScore();
				break;
			case 3:
				professorMajorManagement();
				break;
			case 4:
				professorLectureManagement();
				break;
			case 5:
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			default:
				throw new InputMismatchException();
			}
		
	}
	

	//교수 관리
	private void professorManagement() {
		printService.printProfessorManageMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
			case 1:
				addProfessor(); //교수 추가
				break;
			case 2:
				setProfessor(); //교수 수정
				break;
			case 3:
				deleteProfessor(); //교수 삭제
				break;
			case 4:
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			default:
				throw new InputMismatchException();
			}
		
		
	}
	
	//교수 관리: 교수 추가
	private void addProfessor() {	
		
	
	}
	
	//교수 관리: 교수 수정
	private void setProfessor() { 
		printService.printProfessorFixedMenu();
		int menu=scan.nextInt();
		
		switch(menu) {
		case 1:
			setProfessorId(); //교수 번호 수정
			break;
		case 2:
			setProfessorAge(); //교수 나이 수정
			break;
		case 3:
			setProfessorName(); //교수 이름 수정
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	//교수 수정: 교수 번호 수정
	private void setProfessorId() {
		
	}

	//교수 수정: 교수 나이 수정
	private void setProfessorAge() {
		
	}

	 //교수 수정: 교수 이름 수정
	private void setProfessorName() {
		
	}

	 //교수 관리: 교수 삭제
	private void deleteProfessor() {
		
	}

	//교수 학생에게 주는 성적 관리
	private void professorGiveScore() {
		
		printService.printScoreManagementMenu();
		int menu=scan.nextInt();
		
		switch(menu) {
		case 1:
			addScore(); //성적 추가
			break;
		case 2:
			setScore(); //성적 수정
			break;
		case 3:
			deleteScore(); //성적 삭제
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		
	}
}
	
	
	//교수가 학생에 주는 성적 관리 : 성적 추가
	private void addScore() {
		
	}

	//교수가 학생에 주는 성적 관리 : 성적 수정
	private void setScore() {
		
	}
	
	//교수가 학생에 주는 성적 관리 : 성적 삭제
	private void deleteScore() {
		
	}
	
	//교수 전공 관리
	private void professorMajorManagement() {
		
		printService.printProfessorMajorManageMentMenu();
		int menu=scan.nextInt();
		
			switch(menu) {
				case 1:
					addMajor(); //전공 추가
					break;
				case 2:
					setMajor();//전공 수정
					break;
				case 3:
					deleteMajor(); //전공 삭제
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					throw new InputMismatchException();
				
			}
	
	}

	//교수 전공 관리: 전공 추가
	private void addMajor() {
		
	}

	//교수 전공 관리: 전공 수정
	private void setMajor() {
		
	}

	//교수 전공 관리: 전공 삭제
	private void deleteMajor() {
		
	}
	
		//교수 강의 관리
		private void professorLectureManagement() {
			printService.printProfessorLectureManagementMenu();
			int menu=scan.nextInt();
			
				switch(menu) {
					case 1:
						addLecture(); //강의 추가
						break;
					case 2:
						setLecture();//강의 수정
						break;
					case 3:
						deleteLecture(); //강의 삭제
						break;
					case 4:
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					default:
						throw new InputMismatchException();
				
				}
		
		}
	
	
	//교수 강의 관리: 강의 추가
	private void addLecture() {
			
		
		}

	//교수 강의 관리: 강의 수정
	private void setLecture() {
			
		
		}

	//교수 강의 관리: 강의 삭제
	private void deleteLecture() {
			
		
		}

	private void managestudent() {
		// TODO Auto-generated method stub
		
	}
	
	//학생 메뉴
	private void studentMenu() { 
		printService.printStudentMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
				case 1:
					manageStudent(); //학생 관리
					break;
				case 2:
					mangageStudentLecture(); //학생 수강 강의 관리
					break;
				case 3:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					throw new InputMismatchException();
		}
		
	}

	//학생 관리
	private void manageStudent() {
		printService.printStudentManagementMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
				case 1:
					addStudent(); //학생 추가
					break;
				case 2:
					setStudent(); //학생 수정
					break;
				case 3:
					deleteStudent(); //학생 삭제
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					throw new InputMismatchException();
			}
	}
	
	//학생 관리: 학생 추가
	private void addStudent() {
	
	}

	//학생 관리: 학생 수정
	private void setStudent() {
		printService.printStudentFixedMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
				case 1:
					addStudent(); //학생 학번 수정
					break;
				case 2:
					setStudent(); //학생 나이 수정
					break;
				case 3:
					deleteStudent(); //학생 이름 수정
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					throw new InputMismatchException();
			}
		
	}

	//학생 관리: 학생 삭제
	private void deleteStudent() {
		
	}

	//학생 수강 강의 관리
	private void mangageStudentLecture() {
		printService.printStudentSubjectsManagementMenu();
		int menu = scan.nextInt();
		
			switch(menu) {
			
				case 1:
					addStudentLecture(); //학생 수강 강의 추가
					break;
				case 2:
					setStudentLecture(); //학생 수강 강의 수정
					break;
				case 3:
					deleteStudentLecture(); //학생 수강 강의 삭제
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					throw new InputMismatchException();
			}
	}
	
	//학생 수강 강의 관리: 학생 수강 강의 추가
	private void addStudentLecture() {
		
	}

	//학생 수강 강의 관리: 학생 수강 강의 수정
	private void setStudentLecture() {
		
	}

	//학생 수강 강의 관리: 학생 수강 강의 삭제
	private void deleteStudentLecture() {
		
	}
		
	//대학교 조회 메뉴
	private void universeSearchMenu() {
		printService.universeSearchMenu();
		int menu = scan.nextInt();
			
		switch(menu) {
				
					case 1:
						searchAll(); //전체 조회
						break;
					case 2:
						searchProfessor(); //교수 조회
						break;
					case 3:
						searchStudent(); //학생 조회
						break;
					case 4:
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					default:
						throw new InputMismatchException();
					
			}
			
	}
	
	//대학교 조회 메뉴: 전체 조회
	private void searchAll() {
		
	}

	//대학교 조회 메뉴: 교수 조회
	private void searchProfessor() {
		
	}

	//대학교 조회 메뉴: 학생 조회
	private void searchStudent() {
		
	}

	@Override
	public void printMenu() {

		printService.printMainMenu();
		
	}

	@Override
	public void exitMenu() {
		
		printService.printExit();
			
	}
}