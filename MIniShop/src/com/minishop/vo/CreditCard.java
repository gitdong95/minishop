package com.minishop.vo;

public class CreditCard implements Payment {
	private String name;

	public CreditCard(){
		this.name = "신용카드";
	}

	@Override
	public String pay() {
		return name;
	}
}
