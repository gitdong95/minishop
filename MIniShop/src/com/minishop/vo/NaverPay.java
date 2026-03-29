package com.minishop.vo;

public class NaverPay implements Payment {
	private String name;
	
	public NaverPay(){
		this.name = "네이버페이";
	}
	@Override
	public String pay() {
		return name;
	}

}
