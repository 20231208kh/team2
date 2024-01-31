package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Prac {
	
	private String id,name;
	private int num;
	List<PracList> list = new ArrayList<PracList>();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prac other = (Prac) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Prac(String id) {
		super();
		this.id = id;
	}

	public Prac(String id, String name, int num, List<PracList> list) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.list = list;
	}

	@Override
	public String toString() {
		return "큰 리스트 [id=" + id + ", name=" + name + ", num=" + num + ", list=" + list + "]\n";
	}
	
	
}
