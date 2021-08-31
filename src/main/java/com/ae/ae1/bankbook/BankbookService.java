package com.ae.ae1.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae.ae1.util.DBConnector;
@Service
public class BankbookService {
	
	private BankbookDAO bankbookDAO;
	

	@Autowired
	public void setBankbookDAO(BankbookDAO bankbookDAO) {
		this.bankbookDAO = bankbookDAO;
	}



	public ArrayList<BankbookDTO> getList() {
		ArrayList<BankbookDTO> ar = bankbookDAO.getList();
		
		return ar;
	}
	
}
