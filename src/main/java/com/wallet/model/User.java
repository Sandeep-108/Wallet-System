package com.wallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="User")
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String name;
	private String password;
	private String email;
	
	@Transient
	@OneToOne(
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private Wallet myWallet;
	
	public User() {
	}
	public User(int userId, String name, String password, String email, Wallet wallet) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.myWallet = wallet;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Wallet getWallet() {
		return myWallet;
	}
	public void setWallet(Wallet wallet) {
		this.myWallet = wallet;
	}
	
	
}
