package com.ae.ae1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ae.ae1.util.DBConnector;

public class BankbookDAO {
	
	private DBConnector dbConnector;
	

	public BankbookDAO(DBConnector dbConnector, int num, String name) {
		this.dbConnector = dbConnector;
	}



	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}



	//HttpServletRequest request
	//setInsert
	public int setInsert(BankbookDTO bankbookDTO) {
		Connection con = null;
		PreparedStatement st=null;
		int result = 0;

		try {
			con = dbConnector.getConnect();
			String sql = "Insert INTO BANKBOOK(BOOK_NUM, BOOK_NAME, BOOK_RATE, BOOK_SALE) "
					+ "VALUES(ACCOUT_SEQ.NEXTVAL,?,?,?)";
			st = con.prepareStatement(sql);
//			st.setString(1, request.getParameter("book_name"));
//			st.setDouble(2, Double.parseDouble(request.getParameter("book_rate")) );
//			st.setInt(3, Integer.parseInt(request.getParameter("book_sale")));
			
			st.setString(1,bankbookDTO.getBook_name() );
			st.setDouble(2, bankbookDTO.getBook_rate() );
			st.setInt(3, bankbookDTO.getBook_sale());
			
			result = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(st, con);
		}
		return result;
		
	}
	
	
	
	
	public ArrayList<BankbookDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		try {
			con = dbConnector.getConnect();
			String sql = "SELECT * FROM BANKBOOK";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBook_num(rs.getLong("book_num"));
				bankbookDTO.setBook_name(rs.getString("book_name"));
				bankbookDTO.setBook_rate(rs.getDouble("book_rate"));
				bankbookDTO.setBook_sale(rs.getInt("book_rate"));
				ar.add(bankbookDTO);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}
	
	
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BankbookDTO result = null;
		
		try {
			con = dbConnector.getConnect();
			String sql = "Select * from BANKBOOK WHERE BOOK_NUM=?";
			st = con.prepareStatement(sql);
			st.setLong(1, bankbookDTO.getBook_num());
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new BankbookDTO();
				result.setBook_num(rs.getLong("book_num"));
				result.setBook_name(rs.getString("book_name"));
				result.setBook_rate(rs.getDouble("book_rate"));
				result.setBook_sale(rs.getInt("book_rate"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return result;
		
	}
	
}
