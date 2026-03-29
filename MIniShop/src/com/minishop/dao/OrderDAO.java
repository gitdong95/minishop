package com.minishop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minishop.vo.OrderVO;
import com.minishop.vo.Payment;

public class OrderDAO {
	private Connection conn;
	
	public OrderDAO() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");// 핵심은 클래스 네임
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(uri, "hr", "hr");
		System.out.println("conn ok");
	}
	// 특정회원 구매내역 조회
	public List<OrderVO> getOrders(String registerId){
		List<OrderVO> orders = new ArrayList<>();
		
		String sql = "SELECT o.orderlist_id, o.orderlist_date, p.product_name, orderlist_quantity, p.product_price, orderlist_price, orderlist_payment "
				+ "FROM orderlist o, products p, registers r "
				+ "WHERE r.register_id = o.register_id AND o.product_id = p.product_id AND r.register_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, registerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				orders.add(new OrderVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), registerId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	public boolean setOrders(int orderlistQuantity, Payment payment, String registerId, int productId){
		Payment pay = payment;
		boolean flag = false;
		
		String sql1 = "INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, register_id, product_id) "
				+ "VALUES (orderlist_id_seq.nextval, sysdate, ?, ? * (SELECT product_price FROM products WHERE product_id = ?), ?, ?, ?);";
		
		String sql2 = "UPDATE products "
				+ "SET stock = stock - ? "
				+ "WHERE product_id = ?;";
		// 검증코드 필요
		
		try {
			//주문완료
			PreparedStatement stmt = conn.prepareStatement(sql1);
			stmt.setInt(1, orderlistQuantity);
			stmt.setInt(2, orderlistQuantity);
			stmt.setInt(3, productId);
			stmt.setString(4, pay.pay());
			stmt.setString(5, registerId);
			stmt.setInt(6, productId);
			if (stmt.executeUpdate() == 1){
				stmt = conn.prepareStatement(sql2);
				stmt.setInt(1, orderlistQuantity);
				stmt.setInt(2, productId);
				flag = (stmt.executeUpdate() == 1);
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
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
