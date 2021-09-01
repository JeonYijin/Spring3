package com.ae.ae1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {
	@Autowired
	private DataSource dataSource;	
	
	
	//HttpServletRequest request
	//setInsert
	public int setInsert(BankbookDTO bankbookDTO) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement st=null;
		int result = 0;

		try {
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
			
		}
		return result;
		
	}
	
	
	
	
	public ArrayList<BankbookDTO> getList() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		try {
			
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
			
		}
		return ar;
	}
	
	
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		BankbookDTO result = null;
		
		try {
			
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
			
		}
		
		return result;
		
	}
	
}
