package com.wallet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wallet.model.ResponseDto;
import com.wallet.model.TransactionHistory;
import com.wallet.model.TxnDetails;

public interface TransactionHistoryService {

	ResponseEntity<ResponseDto<List<TxnDetails>>> getTxnHistory(int userId);
}
