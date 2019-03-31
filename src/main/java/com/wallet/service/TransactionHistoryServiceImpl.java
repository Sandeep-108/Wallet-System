package com.wallet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wallet.model.ResponseDto;
import com.wallet.model.TxnDetails;
import com.wallet.model.User;
import com.wallet.repository.TransactionHistoryRepository;
import com.wallet.repository.UserRepository;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	@Autowired
	private TransactionHistoryRepository txnHistoryRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<ResponseDto<List<TxnDetails>>> getTxnHistory(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		List<TxnDetails> txnList = txnHistoryRepository.findByUser(user).stream()
				.map(TxnDetails::new).collect(Collectors.toList());
		ResponseDto<List<TxnDetails>> txnDto =new ResponseDto<>("0", "Txn List", txnList);
		return new ResponseEntity<ResponseDto<List<TxnDetails>>>(txnDto, HttpStatus.OK);
	}
}