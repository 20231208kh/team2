package homwork2.bank.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import homwork2.bank.Bank;

public class FileServiceImp implements FileService ,Serializable{
	private static final long serialVersionUID = -1099578898757276127L;
	String fileName = "src/homework2/bank/service/AccountBook.txt";
	
	@Override
	public List<Bank> load() {
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			return (List<Bank>) ois.readObject();
		}
		catch(Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
		return new ArrayList<Bank>() ;
	}

	@Override
	public void save(List<Bank> bankList) {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(bankList);
			oos.close();
		}
		catch(Exception e){
			System.out.println("저장하기에 실패했습니다.");
		}
	}

	

}





