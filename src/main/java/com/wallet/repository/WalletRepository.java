/**
 * 
 */
package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.User;
import com.wallet.model.Wallet;

/**
 * @author sandy
 *
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	Wallet findByUser(User user);

}
