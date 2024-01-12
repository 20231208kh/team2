package homwork2.bank.service;



public interface FileService {
	//파일 불러오기
	AccountBookServiceImp load(String fileName);
	//파일 저장하기
	void save(AccountBookServiceImp absi, String fileName);
}
