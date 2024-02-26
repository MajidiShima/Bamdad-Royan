package com.barok.interview.service;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyScheduler {
	private final TransactionService transactionService;

	@Scheduled(cron = "0 0 0 * * *")
//	@Scheduled(cron = "0 * * * * *")
	public void calculateTotalAmount() {
		transactionService.calculateTotalAmount();
	}
}
