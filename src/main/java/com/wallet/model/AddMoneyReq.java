package com.wallet.model;
/**
 * 
 * @author sandy
 *
 */
public class AddMoneyReq {
	
	private int walletId;
	private double amount;
	
	public AddMoneyReq() {
		
	}
	public AddMoneyReq(int walletId, double amount) {
		this.walletId = walletId;
		this.amount = amount;
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
	@Override
	public String toString() {
		return "AddMoneyReq [walletId=" + walletId + ", amount=" + amount + "]";
	}
	
	

}
