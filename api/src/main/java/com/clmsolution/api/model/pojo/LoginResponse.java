package com.clmsolution.api.model.pojo;

public class LoginResponse {
	private int status;
	private String message;
	private LoginUserData data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoginUserData getData() {
		return data;
	}
	public void setData(LoginUserData data) {
		this.data = data;
	}
}
