package com.barok.interview.service.mapper;


import com.barok.interview.domain.Wallet;
import com.barok.interview.dto.BalanceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletMapper {

	public BalanceDto walletToBalanceDto(Wallet wallet) {
		return BalanceDto.builder()
				.balance(wallet.getBalance())
				.build();
	}
}
