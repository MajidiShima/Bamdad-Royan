package com.barok.interview.service;


import com.barok.interview.domain.Transaction;
import com.barok.interview.dto.TransactionInputDto;
import com.barok.interview.dto.TransactionOutputDto;
import com.barok.interview.repository.TransactionRepository;
import com.barok.interview.service.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionService {
	private final TransactionRepository transactionRepository;
	private final TransactionMapper transactionMapper;
	private final WalletService walletService;

	@Transactional
	public TransactionOutputDto save(TransactionInputDto transactionInputDto) {
		log.info("Saving transaction : {}", transactionInputDto);
		Transaction transaction = transactionMapper.transactionInputDtoToTransaction(transactionInputDto);
		transactionRepository.save(transaction);
		walletService.addAmount(transaction.getWallet().getId(), transaction.getAmount());
		return transactionMapper.transactionToTransactionOutputDto(transaction);
	}

	@Transactional(readOnly = true)
	public void calculateTotalAmount() {
		log.info("Calculating total amount date time is: {}", Instant.now());
		Integer integer = transactionRepository.calculateTotalAmount();
		log.info("Total amount : " + integer);
	}
}
