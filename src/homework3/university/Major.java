package homework3.university;

import java.util.Objects;

import lombok.Data;

@Data
public class Major {
	
	int majornum; //전공 번호
	int departname; //전공 이름
	
	@Override
	public String toString() {
		return "학과 [ 학과 번호 = " + majornum+ ", 학과 이름 = " + departname + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Major other = (Major) obj;
		return departname == other.departname && majornum == other.majornum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departname, majornum);
	}
	
	
}
