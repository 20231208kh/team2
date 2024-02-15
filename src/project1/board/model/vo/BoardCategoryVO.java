package project1.board.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardCategoryVO {
	
	int bc_num;
	String bc_title;
	
	public BoardCategoryVO(String boardCategory) {
		this.bc_title = boardCategory;
	}
	
	public BoardCategoryVO(int boardCategoryNum, String boardCategoryName) {
		this.bc_num = boardCategoryNum;
		this.bc_title = boardCategoryName;
	}
	
	@Override
	public String toString() {
		return "[카테고리 번호 : " + bc_num + " ] " + "[카테고리 이름 : " + bc_title + " ]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardCategoryVO other = (BoardCategoryVO) obj;
		return Objects.equals(bc_title, other.bc_title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bc_title);
	}

}
