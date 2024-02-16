package project1.board.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	int po_num,po_viewCount;
	String po_title,po_content;
	String po_date;
	Date date = new Date();
	int po_notice;
	String po_mb_id;
	int po_bo_num,po_pc_num;
	
	
	
	public PostVO(String po_title, String po_content,String po_mb_id, int po_bo_num,
			int po_pc_num) {
		super();
		this.po_title = po_title;
		this.po_content = po_content;
		this.po_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
		this.po_mb_id = po_mb_id;
		this.po_bo_num = po_bo_num;
		this.po_pc_num = po_pc_num;
	}
	
	
}
