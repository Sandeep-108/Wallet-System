package com.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.exception.CustomException;
import com.wallet.model.AddMoneyReq;
import com.wallet.model.PayMoneyReq;
import com.wallet.model.ResponseDto;
import com.wallet.model.Wallet;
import com.wallet.service.WalletServiceImpl;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletServiceImpl walletService;
	
	@PostMapping("/addmoney")
	private ResponseEntity<ResponseDto<Wallet>> addMoneyToWallet(@RequestBody AddMoneyReq req ) throws CustomException{
		int  walletId =req.getWalletId();
		double amount = req.getAmount();
		return walletService.addMoney(walletId, amount);
	}
	
	@PostMapping("/payMoney")
	private ResponseEntity<ResponseDto<Wallet>> paymoneyToWallet(@RequestBody PayMoneyReq req) throws CustomException{
		int payerWalletId = req.getPayerWalletId();
		int payeeWalletId = req.getPayeeWalletId();
		double amount = req.getAmount();
		return walletService.sendMoney(payerWalletId, payeeWalletId, amount);
	}
}
