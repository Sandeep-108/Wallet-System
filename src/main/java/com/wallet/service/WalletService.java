package com.wallet.service;

import org.springframework.http.ResponseEntity;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.Wallet;

public interface WalletService {
	
	public ResponseEntity<ResponseDto<Wallet>> addMoney(int walletId, double amount) throws CustomException;
	
	public ResponseEntity<ResponseDto<Wallet>> sendMoney(int walletId, int payeeWalletId, double amount) throws CustomException;

}
