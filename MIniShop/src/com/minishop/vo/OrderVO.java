package com.minishop.vo;

public class OrderVO {
	private int orderNO;
	private String orderDate;
	private String productName;
	private int orderPrice;
	private String customerRegisterId;
	
	public OrderVO(int orderNO, String orderDate, String productName, int orderPrice, String customerRegisterId) {
		super();
		this.orderNO = orderNO;
		this.orderDate = orderDate;
		this.productName = productName;
		this.orderPrice = orderPrice;
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

	public int getOrderPrice() {
		return orderPrice;
	}

	public String getCustomerRegisterId() {
		return customerRegisterId;
	}

	@Override
	public String toString() {
		return "[orderNO=" + orderNO + ", orderDate=" + orderDate + ", productName=" + productName
				+ ", orderPrice=" + orderPrice + ", customerRegisterId=" + customerRegisterId + "]";
	}
	
	
}
