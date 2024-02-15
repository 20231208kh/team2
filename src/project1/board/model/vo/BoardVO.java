package project1.board.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	
	int bo_num;
	String bo_title,bo_detail;
	int bo_bc_num;
	
	public BoardVO(String boardName, String boardDetail, int boardCategoryNum) {
		this.bo_title = boardName;
		this.bo_detail = boardDetail;
		this.bo_bc_num = boardCategoryNum;
	}

	public BoardVO(int boardNum, String boardName) {
		this.bo_num = boardNum;
		this.bo_title = boardName;
	}
	
	@Override
	public String toString() {
		return "[카테고리 번호 : " + bo_bc_num + " ] " + "[게시판 번호 : " + bo_num + " ] " + "[게시판 이름 : " + bo_title + " ] " + "[게시판 내용 : " + bo_detail + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bo_title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(bo_title, other.bo_title);
	}

}
