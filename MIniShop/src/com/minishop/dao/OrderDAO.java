package com.minishop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minishop.vo.OrderVO;

public class OrderDAO {
	private Connection conn;
	
	public OrderDAO() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");// 핵심은 클래스 네임
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(uri, "hr", "hr");
		System.out.println("conn ok");
	}
	
	public List<OrderVO> getOrders(String registerId){
		List<OrderVO> orders = new ArrayList<>();
		
		String sql ="SELECT order_no, order_date, product_name, order_price "
				+ "FROM orders "
				+ "WHERE register_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, registerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				orders.add(new OrderVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), registerId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
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
