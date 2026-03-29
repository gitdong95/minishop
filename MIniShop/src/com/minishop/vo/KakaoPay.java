package com.minishop.vo;

public class KakaoPay implements Payment{
	private String name;
	
	public KakaoPay(){
		this.name = "카카오페이";
	}

	@Override
	public String pay() {
		return name;
	}
	

}
