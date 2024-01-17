package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

//교수 클래스에서는 교수와 관련된 정보만 취금
@Data
public class Professor {
	
	//교수 [name, id, major(), lecture[ lecture(title,count(0->21)>maxcount,score) ] ]
			
	//학생 [lecture(교수),count1] 학생2 [lecture(count2) ] 학생20(count20)  학생21 ()
			
	//교수 lectureList[lecture(count++)]
			
	//String으로 수정
	int professorId;
	//성함
	String professorName;
	//동명이인 일 때 처리할 번호
	//교수님 전공
	String professorMajor;
	//전공 이름을 받아오는 인스턴스
	//과목 정보 저장할 list
	List<Lecture> lectureList = new ArrayList<Lecture>();

	@Override
	public int hashCode() {
		return Objects.hash(professorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return professorId == other.professorId;
	}
	
	//교수 고유번호랑 교수님 이름 강의정보 입력받아오는 생성자
	public Professor(int professorId, String professorName, String major, List<Lecture> lectureList) {
		this.professorId = professorId;
		this.professorName = professorName;
		this.professorMajor = major;
		this.lectureList = lectureList;
	}
	
	public Professor(List<Lecture> lectureList) {
		this.lectureList = lectureList;
	}

	@Override
	public String toString() {
		return "[professorId]" + "[성함: " + professorName + " ]" + "[전공 : " + professorMajor + " ]";
	}
	/*
	- 기본 기능
	 *   - 교수 관리
	 *   교수 정보(이름, 전공)
	 *   - 동명이인 관리
	 *   동명이인이지만 전공은 다르다. 전공별 번호로 구분가능
	 *   동명이인이면서 전공도 같다. 전공 교수님별 고유번호 등록
	 *     - 교수 등록/수정/삭제
	*/
	
	
}
