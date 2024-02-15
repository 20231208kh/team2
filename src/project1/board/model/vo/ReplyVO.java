package project1.board.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyVO {
	int re_num;
	String re_content;
	Date re_date;
	String re_mb_id;
	int re_po_num;
	@Override
	public String toString() {
		return  re_mb_id +" : " + re_content + " ("+re_date+")"  ;
	}
	
	
	
}
