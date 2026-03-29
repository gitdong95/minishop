package test.com.minishop;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.minishop.dao.CustomerRegisterDAO;
import com.minishop.dao.OrderDAO;
import com.minishop.vo.CreditCard;
import com.minishop.vo.KakaoPay;
import com.minishop.vo.NaverPay;

public class DAOUnitTest {
	static CustomerRegisterDAO dao = null;
	static OrderDAO orderDao = null;
	
	@BeforeClass
	public static void 전체_테스트_시작() throws ClassNotFoundException, SQLException{
		System.out.println("전체테스트시작");
		dao = new CustomerRegisterDAO();
		orderDao = new OrderDAO();
	}
	@AfterClass
	public static void 전체_테스트_종료(){
		dao.close();
		orderDao.close();
		System.out.println("전체테스트종료");
	}
	@Test
	public void loginTest(){
		//NO
//		assertTrue(dao.login("gildong1", "1234okok").equals("팔길동"));
		//YES
		assertTrue(dao.login("gildong1", "pass1234").equals("홍길동"));
	}
	@Test
	public void getRegisterIdTest(){
		//NO
		//YES
		assertTrue(dao.getRegisterId("홍길동", "010-1111-1111") != null);
		assertEquals(dao.getRegisterId("홍길동", "010-1111-1111"), "gildong1");
	}
	@Test
	public void setPasswordTest() throws SQLException{
		Connection conn = dao.getConnection();
		conn.setAutoCommit(false);
		//NO
		//YES
		assertTrue(dao.setPassword("gildong1", "pass1234", "1234okok"));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	@Test
	public void setRegisterTest() throws SQLException{
		Connection conn = dao.getConnection();
		conn.setAutoCommit(false);
		//NO
		//assertTrue(dao.setRegister("", "최동석", "12345678", "ehdehd@naver.com", "01088776655"));
		//assertTrue(dao.setRegister("ehdehd", "", "12345678", "ehdehd@naver.com", "01088776655"));
		//assertTrue(dao.setRegister("ehdehd", "최", "12345678", "ehdehd@naver.com", "01088776655"));
		//assertTrue(dao.setRegister("ehdehd", "최동석", "1234567", "ehdehd@naver.com", "01088776655"));
		//assertTrue(dao.setRegister("ehdehd", "최동석", "", "ehdehd@naver.com", "01088776655"));
		//assertTrue(dao.setRegister("ehdehd", "최동석", "12345678", "ehdehd@naver.com", ""));
		//YES
		assertTrue(dao.setRegister("ehdehd", "최동석", "12345678", "ehdehd@naver.com", "01088776655"));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	@Test
	public void getOrdersTest(){
		//NO
		
		//YES
		assertFalse(orderDao.getOrders("gildong10").isEmpty());
		//System.out.println(orderDao.getOrders("gildong10"));
	}
	@Test
	public void setOrderTest() throws SQLException{
		Connection conn = orderDao.getConnection();
		conn.setAutoCommit(false);
		//NO
		//결제수단 미입력
		//assertTrue(orderDao.setOrder(4, null, "gildong1", 1));
		//수량 미입력
		//assertTrue(orderDao.setOrder(0, new KakaoPay(), "gildong1", 1));
		//YES
		assertTrue(orderDao.setOrder(4, new KakaoPay(), "gildong1", 1));
		assertTrue(orderDao.setOrder(4, new NaverPay(), "gildong1", 1));
		assertTrue(orderDao.setOrder(4, new CreditCard(), "gildong1", 1));
		conn.rollback();
		conn.setAutoCommit(true);
	}

}
