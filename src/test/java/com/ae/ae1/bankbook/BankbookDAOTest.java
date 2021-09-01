package com.ae.ae1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	@Test
	public void setInsertTest() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBook_name("Spring");
		bankbookDTO.setBook_rate(3.35);
		bankbookDTO.setBook_sale(0);
		int result = bankbookDAO.setInsert(bankbookDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void getSelectTest() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBook_num(1000);
		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		//System.out.println(bankbookDTO.getBook_name());
		assertNotNull(bankbookDTO);
	}
	
	//@Test
	public void getListTest() {
		List<BankbookDTO> ar = bankbookDAO.getList();
		assertNotEquals(0, ar.size());
	
	}

}
