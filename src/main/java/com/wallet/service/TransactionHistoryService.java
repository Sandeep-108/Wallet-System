package com.wallet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wallet.model.ResponseDto;
import com.wallet.model.TransactionHistory;
import com.wallet.model.TxnDetails;
/**
 * 
 * @author sandy
 *
 */
public interface TransactionHistoryService {
	/**
	 * 
	 * @param userId
	 * @return ResponseEntity
	 */
	ResponseEntity<ResponseDto<List<TxnDetails>>> getTxnHistory(int userId);
}
