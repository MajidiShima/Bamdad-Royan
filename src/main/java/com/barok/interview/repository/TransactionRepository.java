package com.barok.interview.repository;

import com.barok.interview.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT SUM(t.amount) FROM Transaction t")
	Integer calculateTotalAmount();
}
