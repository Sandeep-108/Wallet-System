package com.wallet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.model.ResponseDto;
import com.wallet.model.TxnDetails;
import com.wallet.service.TransactionHistoryServiceImpl;

/**
 * 
 * @author sandy
 *
 */

@RestController
@RequestMapping("/transaction")
public class TransactionHistory {
	
	@Autowired
	private TransactionHistoryServiceImpl transactionHistoryService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
/**
 * 
 * @param userId
 * @return ResponseEntity
 */
	@GetMapping("/user")
	public ResponseEntity<ResponseDto<List<TxnDetails>>> getTxnHistory(@RequestParam int userId){
		log.info("Get Txn History Request with user id {}",userId);
		return transactionHistoryService.getTxnHistory(userId);
	}
}
