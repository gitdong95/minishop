package com.minishop.vo;

public class AddressVO {
	private int addressId;
	private String address;
	private String registerId;
	
	public AddressVO(int addressId, String address, String registerId) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.registerId = registerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getRegisterId() {
		return registerId;
	}

	@Override
	public String toString() {
		return "[주소아이디=" + addressId + ", 주소=" + address + ", 회원아이디=" + registerId + "]";
	}
	
	
}
