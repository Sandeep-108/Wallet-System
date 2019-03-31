/**
 * 
 */
package com.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.TransactionHistory;
import com.wallet.model.User;

/**
 * @author sandy
 *
 */
@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

	List<TransactionHistory> findByUser(User user);

}
