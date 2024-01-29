
package homework3.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;

@Data
public class Lecture {
	

	int lecnumber; //강의 번호

	String lecname; //강의 이름
	
	int score; //강의 점수
	
	int acceptnumber=0; //현재 수용 강의 인원
	int maxacceptnumber=20; //최대 수용 강의 인원
	
	
	
	
}