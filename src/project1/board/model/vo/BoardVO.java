package project1.board.model.vo;

public class BoardVO {
	
	int bo_num;
	String bo_title,bo_detail;
	int bo_bc_num;
	
	public BoardVO(String boardName, String boardDetail, int boardCategoryNum) {
		this.bo_title = boardName;
		this.bo_detail = boardDetail;
		this.bo_bc_num = boardCategoryNum;
	}

	@Override
	public String toString() {
		return "[게시판 번호 : " + bo_num + " ] " + "[게시판 이름 : " + bo_title + " ] " + "[게시판 내용 : " + bo_detail + " ]";
	}
	
}
