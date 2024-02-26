package com.barok.interview.service.mapper;


import com.barok.interview.domain.Transaction;
import com.barok.interview.domain.Wallet;
import com.barok.interview.dto.TransactionInputDto;
import com.barok.interview.dto.TransactionOutputDto;
import com.barok.interview.repository.WalletRepository;
import com.barok.interview.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionMapper {

	private final WalletService walletService;
	public Transaction transactionInputDtoToTransaction(TransactionInputDto dto) {
		Transaction transaction = new Transaction();
		transaction.setAmount(dto.getAmount());
		Wallet walletByUserId = walletService.getWalletByUserId(dto.getUserId());
		transaction.setWallet(walletByUserId);
		return transaction;
	}

	public TransactionOutputDto transactionToTransactionOutputDto(Transaction transaction) {
		return TransactionOutputDto.builder()
				.referenceId(transaction.getId())
				.build();
	}
}
