package test.com.minishop;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.minishop.dao.AddressDAO;
import com.minishop.dao.CustomerRegisterDAO;
import com.minishop.dao.OrderDAO;
import com.minishop.vo.CreditCard;
import com.minishop.vo.KakaoPay;
import com.minishop.vo.NaverPay;

public class DAOUnitTest {
	static CustomerRegisterDAO cDao = null;
	static OrderDAO oDao = null;
	static AddressDAO aDao = null;
	
	@BeforeClass
	public static void 전체_테스트_시작() throws ClassNotFoundException, SQLException{
		System.out.println("전체테스트시작");
		cDao = new CustomerRegisterDAO();
		oDao = new OrderDAO();
		aDao = new AddressDAO();
	}
	
	@AfterClass
	public static void 전체_테스트_종료(){
		cDao.close();
		oDao.close();
		aDao.close();
		System.out.println("전체테스트종료");
	}
	
	@Test
	public void setRegisterTest() throws SQLException{
		Connection conn = cDao.getConnection();
		conn.setAutoCommit(false);
		//NO
		// 아이디 x
		//assertTrue(cDao.setRegister("", "최동석", "12345678", "ehdehd@naver.com", "01088776655"));
		// 이름 x
		//assertTrue(cDao.setRegister("ehdehd", "", "12345678", "ehdehd@naver.com", "01088776655"));
		// 이름 2글자 미만
		//assertTrue(cDao.setRegister("ehdehd", "최", "12345678", "ehdehd@naver.com", "01088776655"));
		// 비밀번호 x
		//assertTrue(cDao.setRegister("ehdehd", "최동석", "", "ehdehd@naver.com", "01088776655"));
		// 비밀번호 8자리 미만
		//assertTrue(cDao.setRegister("ehdehd", "최동석", "1234567", "ehdehd@naver.com", "01088776655"));
		// 핸드폰번호 x
		//assertTrue(cDao.setRegister("ehdehd", "최동석", "12345678", "ehdehd@naver.com", ""));
		//YES
		assertTrue(cDao.setRegister("ehdehd", "최동석", "12345678", "ehdehd@naver.com", "01088776655"));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	
	@Test
	public void loginTest(){
		// NO
		// 아이디 틀림
		//assertTrue(cDao.login("chulsoo99", "chul1234!").equals("김철수"));
		// 비밀번호 틀림
		//assertTrue(cDao.login("chulsoo77", "chul7777!").equals("김철수"));
		// YES
		assertTrue(cDao.login("chulsoo77", "chul1234!").equals("김철수"));
	}
	
	@Test
	public void getRegisterIdTest(){
		// NO
		// 이름 틀림
		//assertEquals(cDao.getRegisterId("이영기", "010-9871-2354"), "younghee02");
		// 핸드폰번호 틀림
		//assertEquals(cDao.getRegisterId("이영희", "010-4444-2354"), "younghee02");
		// YES
		assertTrue(cDao.getRegisterId("김철수", "010-4562-1289") != null);
		assertEquals(cDao.getRegisterId("이영희", "010-9871-2354"), "younghee02");
	}
	
	@Test
	public void setPasswordTest() throws SQLException{
		Connection conn = cDao.getConnection();
		conn.setAutoCommit(false);
		// NO
		// 아이디 틀림
		//assertTrue(cDao.setPassword("chulsoo44", "chul1234!", "12345678"));
		// 비밀번호 틀림
		//assertTrue(cDao.setPassword("chulsoo77", "chul1111!", "12345678"));
		// YES
		assertTrue(cDao.setPassword("chulsoo77", "chul1234!", "12345678"));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	
	@Test
	public void getOrdersTest(){
		// NO
		// 아이디 잘못 입력
		//assertFalse(oDao.getOrders("chulsoo88").isEmpty());
		// YES
		assertFalse(oDao.getOrders("chulsoo77").isEmpty());
		// 주문목록 확인
		//System.out.println(oDao.getOrders("chulsoo77"));
	}
	
	@Test
	public void setOrderTest() throws SQLException{
		Connection conn = oDao.getConnection();
		conn.setAutoCommit(false);
		// NO
		// 결제수단 미입력
		//assertTrue(oDao.setOrder(4, null, "chulsoo77", 1, 1));
		// 수량 미입력
		//assertTrue(oDao.setOrder(0, new NaverPay(), "chulsoo77", 1, 1));
		// 배송지 선택x
		//assertTrue(oDao.setOrder(4, new NaverPay(), "chulsoo77", 1, 0));
		// YES
		assertTrue(oDao.setOrder(4, new NaverPay(), "chulsoo77", 1, 1));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	
	@Test
	public void setAddressTest() throws SQLException {
		Connection conn = aDao.getConnection();
		conn.setAutoCommit(false);
		// NO
		// 아이디x
		//assertTrue(aDao.setAddress("인천시부평구후정동로68", null));
		// 배송지x
		//assertTrue(aDao.setAddress("", "chulsoo77"));
		// YES
		assertTrue(aDao.setAddress("인천시부평구후정동로68", "chulsoo77"));
		conn.rollback();
		conn.setAutoCommit(true);
	}
	
	@Test
	public void getAddressTest(){
		// NO
		// 아이디 잘못입력
		//assertFalse(aDao.getAddress("chulsoo9999").isEmpty());
		// YES
		assertFalse(aDao.getAddress("chulsoo77").isEmpty());
		// 배송지 출력
		//System.out.println(aDao.getAddress("chulsoo77"));
	}

}
