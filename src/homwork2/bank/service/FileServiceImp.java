package homwork2.bank.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileServiceImp implements FileService ,Serializable{
	private static final long serialVersionUID = -1099578898757276127L;
	
	
	@Override
	// 파일 불러오기
	public AccountBookServiceImp load(String fileName) {
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			return (AccountBookServiceImp) ois.readObject();
		}
		catch(Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
		return new AccountBookServiceImp();
	}

	@Override
	// 파일 저장하기
	public void save(AccountBookServiceImp absi, String fileName) {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(absi);
			oos.close();
		}
		catch(Exception e){
			System.out.println("저장하기에 실패했습니다.");
		}
	}

}





