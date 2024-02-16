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
	String po_pc_title;
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer(po_title);
		
		int limit = 20;
		
		sb.setLength(limit);
		sb.append("...");
		
		if(po_pc_title == null) {
			return sb  + " [작성자: " + po_mb_id + "][" +  po_date  +"] 조회수(" + po_viewCount+ ")" ;
		}
		return "["+po_pc_title+"]"+ sb  + " [작성자: " + po_mb_id + "][" +  po_date  +"] 조회수(" + po_viewCount+ ")" ;

	}
	
	
}
