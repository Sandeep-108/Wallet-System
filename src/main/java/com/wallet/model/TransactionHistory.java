package com.wallet.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author sandy
 *
 */
@Entity
public class TransactionHistory {
	
	@Id
	@GeneratedValue
	private int txnId;
	@ManyToOne
	@JoinColumn(referencedColumnName="userId")
	private User user;
	private String drCr;
	@ManyToOne
	@JoinColumn(referencedColumnName="userId")
	private User payer_payee;
	private double amount;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date postdate;
	
	public TransactionHistory() {
		
	}
	public TransactionHistory(int txnId, User user, String drCr, User payer_payee, double amount, Date postdate) {
		this.txnId = txnId;
		this.user = user;
		this.drCr = drCr;
		this.payer_payee = payer_payee;
		this.amount = amount;
		this.postdate = postdate;
	}
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDrCr() {
		return drCr;
	}
	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}
	public User getPayer_payee() {
		return payer_payee;
	}
	public void setPayer_payee(User payer_payee) {
		this.payer_payee = payer_payee;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Override
	public String toString() {
		return "TransactionHistory [txnId=" + txnId + ", user=" + user + ", drCr=" + drCr + ", payer_payee="
				+ payer_payee + ", amount=" + amount + ", postdate=" + postdate + "]";
	}
	
	
	
}
