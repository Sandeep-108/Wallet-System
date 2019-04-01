package com.wallet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
/**
 * 
 * @author sandy
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public ResponseEntity<ResponseDto<User>> addNewUser(User user) {
		Wallet wallet =new Wallet();
		User saveUser = userRepository.save(user);
		wallet.setUser(user);
		walletRepository.save(wallet);
		user.setWallet(wallet);
		ResponseDto<User> userDto =new ResponseDto<>("0","User added successfuly",saveUser);
		log.info("Register user response {}",userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> userLogIn(String email, String password) throws CustomException {
		
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user == null)
			throw new CustomException(Constants.USER_LOGIN_FAILED,Constants.U1001_MSG);
		ResponseDto<User> userDto =new ResponseDto<>("0","Login successfuly successfuly",user);
		log.info("Login user response {}",userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> viewUserProfile(int userId) throws CustomException {
		User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(Constants.USER_NOT_FOUND,Constants.U1002_MSG));
		user.setWallet(walletRepository.findByUser(user));
		ResponseDto<User> userDto =new ResponseDto<>("0","User Profile",user);
		log.info("View Profile response {}",userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<User>> updateUserProfile(User user) throws  CustomException {
		User getUser = userRepository.findById(user.getUserId()).orElseThrow(() -> new CustomException(Constants.USER_NOT_FOUND,Constants.U1002_MSG));
		getUser =userRepository.save(user);
		ResponseDto<User> userDto =new ResponseDto<>("0","profile update successfully successfuly",getUser);
		log.info("Edit Profile response {}",userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}


}
