package com.wallet.model;

public class PayMoneyReq {
	
	private int payeeWalletId;
	private int PayerWalletId;
	private double amount;
	
	public PayMoneyReq() {
		
	}
	public PayMoneyReq(int payeeWalletId, int payerWalletId, double amount) {
		super();
		this.payeeWalletId = payeeWalletId;
		PayerWalletId = payerWalletId;
		this.amount = amount;
	}
	public int getPayeeWalletId() {
		return payeeWalletId;
	}
	public void setPayeeWalletId(int payeeWalletId) {
		this.payeeWalletId = payeeWalletId;
	}
	public int getPayerWalletId() {
		return PayerWalletId;
	}
	public void setPayerWalletId(int payerWalletId) {
		PayerWalletId = payerWalletId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
