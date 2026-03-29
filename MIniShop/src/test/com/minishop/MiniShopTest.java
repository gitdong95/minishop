package test.com.minishop;

import java.sql.SQLException;

import com.minishop.dao.CustomerRegisterDAO;

public class MiniShopTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CustomerRegisterDAO dao = null;
		dao = new CustomerRegisterDAO();
		
		System.out.println(dao.login("gildong1", "1234okok"));
	}
	
}
