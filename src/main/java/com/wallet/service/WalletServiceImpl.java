package com.wallet.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.TransactionHistory;
import com.wallet.model.User;
import com.wallet.model.Wallet;
import com.wallet.repository.TransactionHistoryRepository;
import com.wallet.repository.WalletRepository;
import com.wallet.util.Constants;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	
	@Override
	public ResponseEntity<ResponseDto<Wallet>> addMoney(int walletId, double amount) throws CustomException {
		Wallet wallet = walletRepository.findById(walletId).orElse(null);
		User user = wallet.getUser();
		if(amount<0) 
			throw new CustomException(Constants.INVALID_AMOUNT, Constants.W1001_MSG);
		wallet.setAmount(wallet.getAmount()+amount);
		walletRepository.save(wallet);
		TransactionHistory txn = new TransactionHistory();
		txn.setAmount(amount);
		txn.setDrCr("CR");
		txn.setPostdate(new Date());
		txn.setUser(user);
		transactionHistoryRepository.save(txn);
		ResponseDto<Wallet> walletDto =new ResponseDto<>("0","Money Added",wallet);
		return new ResponseEntity<>(walletDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<Wallet>> sendMoney(int payerWalletId, int payeeWalletId, double amount) throws CustomException {
		 if(payerWalletId == payeeWalletId)
			  throw new CustomException(Constants.SAME_WALLET, Constants.W1002_MSG);
		if(amount<0) 
			throw new CustomException(Constants.INVALID_AMOUNT, Constants.W1001_MSG);
		Wallet payerWallet =walletRepository.findById(payerWalletId).orElse(null);
		Wallet payeeWallet =walletRepository.findById(payeeWalletId).orElse(null);
//Debit part
		if(payerWallet.getAmount()<amount)
			throw new CustomException(Constants.LOW_BALANCE, Constants.W1003_MSG);
		payerWallet.setAmount(payerWallet.getAmount() - amount);
		walletRepository.save(payerWallet);
		TransactionHistory debitTxn =new TransactionHistory();
		debitTxn.setUser(payerWallet.getUser());
		debitTxn.setDrCr("DR");
		debitTxn.setPostdate(new Date());
		debitTxn.setAmount(amount);
		debitTxn.setPayer_payee(payeeWallet.getUser());
		transactionHistoryRepository.save(debitTxn);
//Credit part
		payeeWallet.setAmount(payeeWallet.getAmount() + amount);
		walletRepository.save(payeeWallet);
		TransactionHistory creditTxn =new TransactionHistory();
		creditTxn.setUser(payeeWallet.getUser());
		creditTxn.setDrCr("CR");
		creditTxn.setAmount(amount) ;
		creditTxn.setPostdate(new Date());
		creditTxn.setPayer_payee(payerWallet.getUser());
		transactionHistoryRepository.save(creditTxn);
		ResponseDto<Wallet> walletDto =new ResponseDto<>("0","Payment Success",payerWallet);
		return new ResponseEntity<>(walletDto, HttpStatus.OK);
	}

}
