package com.wallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
import com.wallet.util.Constants;

/**
 * 
 * @author sandy
 *
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletServiceImpl walletService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * @param AddMoneyReq req
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@PostMapping("/addmoney")
	private ResponseEntity<ResponseDto<Wallet>> addMoneyToWallet(@RequestBody AddMoneyReq req ) throws CustomException{
		MDC.clear();
		MDC.put(Constants.WALLET_ID, String.valueOf(req.getWalletId()));
		log.info("add money request, {}",req);
		int  walletId =req.getWalletId();
		double amount = req.getAmount();
		return walletService.addMoney(walletId, amount);
	}
	/**
	 * 
	 * @param PayMoneyReq req
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@PostMapping("/payMoney")
	private ResponseEntity<ResponseDto<Wallet>> paymoneyToWallet(@RequestBody PayMoneyReq req) throws CustomException{
		MDC.clear();
		MDC.put(Constants.WALLET_ID, String.valueOf(req.getPayeeWalletId()));
		log.info("pay money request, {}",req);
		int payerWalletId = req.getPayerWalletId();
		int payeeWalletId = req.getPayeeWalletId();
		double amount = req.getAmount();
		return walletService.sendMoney(payerWalletId, payeeWalletId, amount);
	}
}
