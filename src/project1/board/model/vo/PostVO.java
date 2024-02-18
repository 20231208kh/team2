package project1.board.model.vo;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
	int po_num,po_viewCount;
	String po_title,po_content;
	String po_date;
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
	
	

	

	public PostVO(String po_title, String po_content,String po_mb_id, int po_pc_num,int po_notice){	//공지사항 작성 1번(po_notice), 게시글 작성 0번(po_notice)

	this.po_title=po_title;
	this.po_content=po_content;
	this.po_mb_id=po_mb_id;
	this.po_pc_num=po_pc_num;
	this.po_notice=po_notice;
	
	}

	
}
