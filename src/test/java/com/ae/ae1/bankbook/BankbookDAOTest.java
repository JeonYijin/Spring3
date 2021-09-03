package com.ae.ae1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	//@Test
	public void setUpdate() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBook_name("note20");
		bankbookDTO.setBook_rate(2.3);
		bankbookDTO.setBook_sale(1);
		bankbookDTO.setBook_num(87L);
		int result =bankbookDAO.setUpdate(bankbookDTO);
		assertEquals(1, result);
		
	}
	
	//@Test
	public void setDeleteTest() {
		int result = bankbookDAO.setDelete(1203L);
		assertEquals(1, result);
	}
	
	
	@Test
	public void setInsertTest() throws Exception{
		
		Random random = new Random();
		for(int i=0; i<200; i++) {
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBook_name("BookName"+i);
			int rate = random.nextInt(400);
			bankbookDTO.setBook_rate(rate/100.0);
			bankbookDTO.setBook_sale(random.nextInt(2));
			int result = bankbookDAO.setInsert(bankbookDTO);	
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("FINISH =================");
		
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
	/*public void getListTest() {
		List<BankbookDTO> ar = bankbookDAO.getList();
		assertNotEquals(0, ar.size());*/
	
	//}

	
	
}
