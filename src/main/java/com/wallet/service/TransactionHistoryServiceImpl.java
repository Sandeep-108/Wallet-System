package com.wallet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wallet.model.ResponseDto;
import com.wallet.model.TxnDetails;
import com.wallet.model.User;
import com.wallet.repository.TransactionHistoryRepository;
import com.wallet.repository.UserRepository;
/**
 * 
 * @author sandy
 *
 */
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	@Autowired
	private TransactionHistoryRepository txnHistoryRepository;
	@Autowired
	private UserRepository userRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public ResponseEntity<ResponseDto<List<TxnDetails>>> getTxnHistory(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		List<TxnDetails> txnList = txnHistoryRepository.findByUser(user).stream()
				.map(TxnDetails::new).collect(Collectors.toList());
		ResponseDto<List<TxnDetails>> txnDto =new ResponseDto<>("0", "Txn List", txnList);
		log.info("Txn history Res ponse {}",txnDto);
		return new ResponseEntity<ResponseDto<List<TxnDetails>>>(txnDto, HttpStatus.OK);
	}
}
