package com.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.User;
import com.wallet.model.Wallet;
import com.wallet.repository.UserRepository;
import com.wallet.repository.WalletRepository;
import com.wallet.util.Constants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public ResponseEntity<ResponseDto<User>> addNewUser(User user) {
		Wallet wallet =new Wallet();
		User saveUser = userRepository.save(user);
		wallet.setUser(user);
		walletRepository.save(wallet);
		user.setWallet(wallet);
		ResponseDto<User> usetDto =new ResponseDto<>("0","User added successfuly",saveUser);
		return new ResponseEntity<>(usetDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> userLogIn(String email, String password) throws CustomException {
		
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user == null)
			throw new CustomException(Constants.USER_LOGIN_FAILED,Constants.U1001_MSG);
		ResponseDto<User> usetDto =new ResponseDto<>("0","Login successfuly successfuly",user);
		return new ResponseEntity<>(usetDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> viewUserProfile(int userId) throws CustomException {
		User user = userRepository.findById(userId).orElse(null);
		if(user == null)
			throw new CustomException(Constants.USER_NOT_FOUND,Constants.U1002_MSG);
		user.setWallet(walletRepository.findByUser(user));
		ResponseDto<User> usetDto =new ResponseDto<>("0","User Profile",user);
		return new ResponseEntity<>(usetDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> updateUserProfile(User user) throws  CustomException {
		User getUser = userRepository.findById(user.getUserId()).orElse(null);
		if(getUser ==null)
			throw new CustomException(Constants.USER_NOT_FOUND,Constants.U1002_MSG);
		getUser =userRepository.save(user);
		ResponseDto<User> usetDto =new ResponseDto<>("0","profile update successfully successfuly",getUser);
		return new ResponseEntity<>(usetDto, HttpStatus.OK);
	}


}
