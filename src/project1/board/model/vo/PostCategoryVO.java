package project1.board.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCategoryVO {
	
	int pc_num;
	String pc_title;
	int pc_bo_num;

	public PostCategoryVO(int postCategoryNum) {
		this.pc_num = postCategoryNum;
	}
	
	public PostCategoryVO(String postCategoryName, int boardNum) {
		this.pc_title = postCategoryName;
		this.pc_bo_num = boardNum;
	}

	public PostCategoryVO(int postCategoryNum, String postCategoryName) {
		this.pc_num = postCategoryNum;
		this.pc_title = postCategoryName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostCategoryVO other = (PostCategoryVO) obj;
		return Objects.equals(pc_title, other.pc_title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pc_title);
	}

	@Override
	public String toString() {
		return "[게시글 번호 : " + pc_bo_num + " ] " + "[말머리 번호 : " + pc_num + " ] " + "[카테고리 이름 : " + pc_title + " ]";
	}


}

