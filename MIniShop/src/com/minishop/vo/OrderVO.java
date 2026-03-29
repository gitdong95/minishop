package com.minishop.vo;

public class OrderVO {
	private int orderNO;
	private String orderDate;
	private String productName;
	private int orderQuantity;
	private int productPrice;
	private int orderPrice;
	private String orderPayment;
	private String customerRegisterId;


	public OrderVO(int orderNO, String orderDate, String productName, int orderQuantity, int productPrice, int orderPrice, String orderPayment, String customerRegisterId) {
		super();
		this.orderNO = orderNO;
		this.orderDate = orderDate;
		this.productName = productName;
		this.orderQuantity = orderQuantity;
		this.productPrice = productPrice;
		this.orderPrice = orderPrice;
		this.orderPayment = orderPayment;
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


	public String getCustomerRegisterId() {
		return customerRegisterId;
	}


	@Override
	public String toString() {
		return "[orderNO=" + orderNO + ", orderDate=" + orderDate + ", productName=" + productName
				+ ", orderQuantity=" + orderQuantity + ", productPrice=" + productPrice + ", orderPrice=" + orderPrice
				+ ", orderPayment=" + orderPayment + ", customerRegisterId=" + customerRegisterId + "]";
	}

	
}
