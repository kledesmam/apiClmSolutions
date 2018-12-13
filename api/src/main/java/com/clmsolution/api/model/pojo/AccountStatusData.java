package com.clmsolution.api.model.pojo;

public class AccountStatusData {
	private String code;
	private String name;
	private String type;
	private AccountStatusDTO data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AccountStatusDTO getData() {
		return data;
	}
	public void setData(AccountStatusDTO data) {
		this.data = data;
	}
}
