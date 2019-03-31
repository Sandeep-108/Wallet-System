package com.wallet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wallet.model.TransactionHistory;

public class Util {
	
	
	public static String formatconvertor(Date date)  {
		SimpleDateFormat df =new SimpleDateFormat("MMM-dd-yy HH:mm:ss");
		String dateString = df.format(date);
		return  dateString;
	}

	public static String getDescription(TransactionHistory txn) {
		if(txn.getDrCr().equals("CR") && null == txn.getPayer_payee())
			return "money Added To wallet";
		else if(txn.getDrCr().equals("CR"))
			return "Amount Recived from "+txn.getPayer_payee().getName();
		else 
			return "Amount Send To "+ txn.getPayer_payee().getName();
	}

}
