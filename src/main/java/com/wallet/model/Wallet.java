package com.wallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author sandy
 *
 */
@Entity
public class Wallet {
	
	@Id
	@GeneratedValue
	private int walletId;
	private double amount;
	
	@JsonIgnore
	 @OneToOne( cascade=CascadeType.ALL)
	 @JoinColumn(referencedColumnName="userId" ,nullable = false)
	private User user;
	
	public Wallet() {
		
	}
	public Wallet(int walletId, double amount, User user) {
		this.walletId = walletId;
		this.amount = amount;
		this.user = user;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", amount=" + amount + ", user=" + user + "]";
	}
	
	

}
