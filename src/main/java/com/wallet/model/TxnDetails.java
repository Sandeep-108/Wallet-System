package com.wallet.model;

import com.wallet.util.Util;
/**
 * 
 * @author sandy
 *
 */
public class TxnDetails {

	private int txnId;
	private String Drcr;
	private String OtherUsername;
	private String TxnDate;
	private String Description;
	
	public TxnDetails(){
		
	}
//Mappeing Constroctor
	public TxnDetails(TransactionHistory txn) {
		this.txnId = txn.getTxnId();
		this.Drcr = txn.getDrCr();
		this.OtherUsername =txn.getPayer_payee()!=null ? txn.getPayer_payee().getName():"Money Add";
		this.TxnDate =Util.formatconvertor(txn.getPostdate());
		this.Description = Util.getDescription(txn);
	}
	public TxnDetails(int txnId, String dR_CR, String otherUsername, String txnDate, String description) {
		this.txnId = txnId;
		Drcr = dR_CR;
		OtherUsername = otherUsername;
		TxnDate = txnDate;
		Description = description;
	}
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public String getDR_CR() {
		return Drcr;
	}
	public void setDR_CR(String dR_CR) {
		Drcr = dR_CR;
	}
	public String getOtherUsername() {
		return OtherUsername;
	}
	public void setOtherUsername(String otherUsername) {
		OtherUsername = otherUsername;
	}
	public String getTxnDate() {
		return TxnDate;
	}
	public void setTxnDate(String txnDate) {
		TxnDate = txnDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "TxnDetails [txnId=" + txnId + ", Drcr=" + Drcr + ", OtherUsername=" + OtherUsername + ", TxnDate="
				+ TxnDate + ", Description=" + Description + "]";
	}
	
	
}
