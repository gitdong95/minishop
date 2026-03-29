package com.minishop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minishop.exception.AddressException;
import com.minishop.vo.AddressVO;

public class AddressDAO {
	private Connection conn;

	public AddressDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(uri, "hr", "hr");
		System.out.println("conn ok");
	}
	// 배송지 등록
	public boolean setAddress(String address, String registerId){
		boolean flag = false;
		
		String sql = "INSERT INTO addresses (address_id, address, register_id) "
				+ "VALUES (seq_address_id.nextval, ?, ?)";
		
		try {
			validateAdress(address, registerId);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, address);
			stmt.setString(2, registerId);
			flag = (stmt.executeUpdate() == 1);
			stmt.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	// 배송지 조회
	public List<AddressVO> getAddress(String registerId){
		List<AddressVO> addressList = new ArrayList<>();
		
		String sql = "SELECT address_id, address, register_id "
				+ "FROM addresses "
				+ "WHERE register_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, registerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				addressList.add(new AddressVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressList;
	}
	// 검증
	public void validateAdress(String address, String registerId) throws AddressException{
		if(address == null||address.length() == 0)
			throw new AddressException("배송지를 입력해주세요");
		if(registerId == null||address.length() == 0)
			throw new AddressException("아이디를 입력해주세요");
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
