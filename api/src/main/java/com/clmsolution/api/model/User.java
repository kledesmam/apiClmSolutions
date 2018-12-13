package com.clmsolution.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="USUARIO_WEB")
@NamedQuery(name= "User.getUserByUserName",
	query = "select u FROM User u WHERE u.userName = :pLogin")
public class User {
	@Id
	@Column(name="ID")
	private Long ID;
	
	@Column(name="User_Name")
	private String userName;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}

