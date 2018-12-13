package com.clmsolution.api.model.pojo;

public class ValidateUserResponse {
	private int status;
	private String message;
	private ValidateUserData data;
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
	public ValidateUserData getData() {
		return data;
	}
	public void setData(ValidateUserData data) {
		this.data = data;
	}
}
