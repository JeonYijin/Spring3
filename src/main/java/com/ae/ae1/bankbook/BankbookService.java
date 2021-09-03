package com.ae.ae1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae.ae1.util.Pager;

@Service
public class BankbookService {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	public int setUpdate(BankbookDTO bankbookDTO) {
		return bankbookDAO.setUpdate(bankbookDTO);
	}
	
	public int setDelete(Long book_num) {
		return bankbookDAO.setDelete(book_num);
	}
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		return bankbookDAO.getSelect(bankbookDTO);
	}

	public List<BankbookDTO> getList(Pager pager){
		pager.makeRow();
		pager.makeNum();
		return bankbookDAO.getList(pager);
	}
	
	public int setInsert(BankbookDTO bankbookDTO) {
		return bankbookDAO.setInsert(bankbookDTO);
	}
	
}
