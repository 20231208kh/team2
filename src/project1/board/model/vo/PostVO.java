package project1.board.model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostVO {	//게시글
	int po_num,po_viewCount;
	
	String po_title,content;
	String po_date;
	int po_notice;
	String po_mb_id; //외래키들
	int po_bo_num,po_pc_num;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		return po_num == other.po_num;
	}



	@Override
	public int hashCode() {
		return Objects.hash(po_num);
	}



	public PostVO(String po_title, String content,String po_mb_id, int po_bo_num, int po_pc_num){

	this.po_title=po_title;
	this.content=content;
	this.po_mb_id=po_mb_id;
	this.po_bo_num=po_bo_num;
	this.po_pc_num=po_pc_num;
	
	}



	
	
	




}
