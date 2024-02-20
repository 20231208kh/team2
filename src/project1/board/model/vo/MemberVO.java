package project1.board.model.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	String mb_id,mb_pw,mb_email;
	int mb_age;
	String mb_localnum;
	String mb_right;
	
	
	public MemberVO(String mb_id, String mb_pw) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(mb_id, other.mb_id) && Objects.equals(mb_pw, other.mb_pw);
	}
	@Override
	public int hashCode() {
		return Objects.hash(mb_id, mb_pw);
	}

	public MemberVO(String mb_id, String mb_pw, String mb_email, int mb_age, String mb_localnum) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_email = mb_email;
		this.mb_age = mb_age;
		this.mb_localnum = mb_localnum;
	}

}

