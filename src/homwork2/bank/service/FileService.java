package homwork2.bank.service;

import java.util.List;

import homwork2.bank.Bank;

public interface FileService {
	List<Bank> load();
	void save(List<Bank> bankList);
}
