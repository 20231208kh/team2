package project1.board.model.vo;

public class PostCategoryVO {
	
	int pc_num;
	String pc_title;
	int pc_bo_num;
	
	public PostCategoryVO(String postCategoryName, int boardNum) {
		this.pc_title = postCategoryName;
		this.pc_bo_num = boardNum;
	}

}
