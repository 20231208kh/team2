package project1.board.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVO {
	int po_num,po_viewCount;
	String po_title,po_content;
	Date po_date;
	int po_notice;
	String po_mb_id;
	int po_bo_num,po_pc_num;
	@Override
	public String toString() {
		return  po_title  + " 작성자 : " + po_mb_id + " 작성일 : " +  po_date  +" 조회수 " + po_viewCount ;
	}
	
	
}
