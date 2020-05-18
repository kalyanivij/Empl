package com.rs.esi.request;

public class UserVO {

	private int userId;

	private NameVO nameVo;

	private ContactVO contactVo;

	private AddressVO addressVo;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public NameVO getNameVo() {
		return nameVo;
	}

	public void setNameVo(NameVO nameVo) {
		this.nameVo = nameVo;
	}

	public ContactVO getContactVo() {
		return contactVo;
	}

	public void setContactVo(ContactVO contactVo) {
		this.contactVo = contactVo;
	}

	public AddressVO getAddressVo() {
		return addressVo;
	}

	public void setAddressVo(AddressVO addressVo) {
		this.addressVo = addressVo;
	}

}
