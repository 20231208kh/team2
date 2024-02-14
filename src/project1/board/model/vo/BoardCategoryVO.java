package project1.board.model.vo;



public class BoardCategoryVO {
	
	int bc_num;
	String bc_title;
	
	public BoardCategoryVO(String boardCategory) {
		this.bc_title = boardCategory;
	}

	@Override
	public String toString() {
		return "[카테고리 번호 : " + bc_num + " ] " + "[카테고리 이름 : " + bc_title + " ]";
	}
	
	
}
