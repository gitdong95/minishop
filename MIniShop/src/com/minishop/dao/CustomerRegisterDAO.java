package com.minishop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.minishop.exception.RegisterException;

public class CustomerRegisterDAO {
	private Connection conn;
	
	public CustomerRegisterDAO() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");// 핵심은 클래스 네임
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(uri, "hr", "hr");
		System.out.println("conn ok");
	}
	// 회원가입
	public boolean setRegister(String registerId, String name, String password, String email, String phoneNumber){
		boolean flag = false;
		String sql = "INSERT INTO registers (register_id, register_name, password, email, phone_number) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			validateRegister(registerId, name, password, phoneNumber);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, registerId);
			stmt.setString(2, name);
			stmt.setString(3, password);
			stmt.setString(4, email);
			stmt.setString(5, phoneNumber);
			
			flag = (stmt.executeUpdate() == 1);
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RegisterException e){
			e.printStackTrace();
		}
		return flag;
	}
	
	// 로그인
	public String login(String registerId, String password) {
		String sql = "SELECT register_name "
				+ "FROM registers "
				+ "WHERE register_id = ? AND password = ?";
		String name = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, registerId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				name = rs.getString(1);
			rs.close(); stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	// 아이디 찾기
	public String getRegisterId(String name, String phonNumber){
		String registerId = null;
		String sql = "SELECT register_id "
				+ "FROM registers "
				+ "WHERE register_name = ? AND phone_number = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, phonNumber);
			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				registerId = rs.getString(1);
			rs.close(); stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return registerId;
	}
	// 비밀번호 변경
	public boolean setPassword(String registerId, String password, String newPassword) {
		boolean flag = false;
		String sql = "UPDATE registers "
				+ "SET password = ? "
				+ "WHERE register_id = ? AND PASSWORD = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newPassword);
			stmt.setString(2, registerId);
			stmt.setString(3, password);
			flag = (stmt.executeUpdate() == 1);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	private void validateRegister(String registerId, String name, String password, String phoneNumber) throws RegisterException {
		if (registerId == null || registerId.length() == 0)
			throw new RegisterException("아이디는 필수 입니다.");
		if (name == null || name.length() == 0)
			throw new RegisterException("이름은 필수 입니다.");
		if (name.length() <= 1)
			throw new RegisterException("이름은 2자 이상입니다.");
		if (password == null || password.length() == 0)
			throw new RegisterException("비밀번호는 필수 입니다.");
		if (password.length() < 8)
			throw new RegisterException("비밀번호는 8자리 이상입니다.");
		if (phoneNumber == null || phoneNumber.length() == 0)
			throw new RegisterException("핸드폰 번호는 필수입니다.");
		if (phoneNumber.length() < 11)
			throw new RegisterException("핸드폰 번호는 11자리로 입력해주세요");
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void close(){
		try {
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
