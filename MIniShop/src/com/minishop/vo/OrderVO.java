package com.minishop.vo;

public class OrderVO {
	private int orderNO;
	private String orderDate;
	private String productName;
	private int orderQuantity;
	private int productPrice;
	private int orderPrice;
	private String orderPayment;
	private String orderAddress;
	private String customerRegisterId;
	
	public OrderVO(int orderNO, String orderDate, String productName, int orderQuantity, int productPrice, int orderPrice, String orderPayment, String orderAddress, String customerRegisterId) {
		super();
		this.orderNO = orderNO;
		this.orderDate = orderDate;
		this.productName = productName;
		this.orderQuantity = orderQuantity;
		this.productPrice = productPrice;
		this.orderPrice = orderPrice;
		this.orderPayment = orderPayment;
		this.orderAddress = orderAddress;
		this.customerRegisterId = customerRegisterId;
	}

	public int getOrderNO() {
		return orderNO;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getProductName() {
		return productName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public String getOrderPayment() {
		return orderPayment;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public String getCustomerRegisterId() {
		return customerRegisterId;
	}

	@Override
	public String toString() {
		return "[주문번호=" + orderNO + ", 주문날짜=" + orderDate + ", 물품이름=" + productName
				+ ", 주문수량=" + orderQuantity + ", 물품가격=" + productPrice + ", 총 가격=" + orderPrice
				+ ", 결제수단=" + orderPayment + ", 배송지=" + orderAddress + ", 회원 아이디="
				+ customerRegisterId + "]";
	}


	
}
