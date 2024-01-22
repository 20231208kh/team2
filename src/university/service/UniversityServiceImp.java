package university.service;

import java.util.ArrayList;
import java.util.List;

import university.Lecture;
import university.Professor;

public class UniversityServiceImp implements UniversityService {
	List<Professor> professorList = new ArrayList<Professor>();
	List<Lecture> lectureList = new ArrayList<Lecture>();

	@Override
	public boolean addStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByProfessorMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentMajor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchByStudentId() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLecture() {
		
		return false;
	}

	@Override
	public boolean updateLecture() {
		
		return false;
	}
	
	public boolean printProfessorSearch() {
		
		return false;
	}

	@Override
	public boolean searchAllProfessor() {
		
		    
		      
		      for(int i=0; i<professorList.size(); i++)
		      {
		    	  professorList.get(i);
		      }
		      	return true;
		      
		      
//		      //indexOf
//		      int index = majorList.indexOf(majorName);
//		      System.out.print(majorList.get(index).printMajorCount()); 
		      
//		      if(majorList.contains(majorName)){
//		         Stream<Major> stream = majorList.stream();
//		         //filter(majorName)
//		         stream.filter(m->m.equals(majorName)).forEach(m->System.out.print(m));
//		         return true;
//		      }
		      
		   
	}
	
	

}
