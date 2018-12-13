package com.clmsolution.api.model.pojo;

public class ValidateUserData {
	private Boolean new_pass;
	private Boolean exist;
	private String email;
	public Boolean getNew_pass() {
		return new_pass;
	}
	public void setNew_pass(Boolean new_pass) {
		this.new_pass = new_pass;
	}
	public Boolean getExist() {
		return exist;
	}
	public void setExist(Boolean exist) {
		this.exist = exist;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
