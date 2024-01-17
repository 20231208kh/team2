
package homework3.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;

@Data
public class Lecture {
	
	@NonNull
	int lecnumber; //강의 번호
	@NonNull
	String lecname; //강의 이름
	
	int score; //강의 점수
	
	int acceptnumber=0; //현재 수용 강의 인원
	int maxacceptnumber=20; //최대 수용 강의 인원
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecture other = (Lecture) obj;
		return Objects.equals(lecname, other.lecname) && lecnumber == other.lecnumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lecname, lecnumber);
	}
	
	
	public Lecture(int lecnumber, String lecname) { //강의 번호,이름을 입력받은 것을 집어넣을 생성자
		this.lecnumber = lecnumber;
		this.lecname = lecname;
	}
	
}