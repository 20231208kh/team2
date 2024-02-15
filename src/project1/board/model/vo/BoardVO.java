package project1.board.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	int bo_num;
	String bo_title,bo_detail;
	int bo_bc_num;
}
