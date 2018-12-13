package com.clmsolution.api.model.pojo;

import java.util.List;

public class AccountStatusResponse {
	private int status;
	private String message;
	private List<AccountStatusData> data;
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
	public List<AccountStatusData> getData() {
		return data;
	}
	public void setData(List<AccountStatusData> data) {
		this.data = data;
	}
}
