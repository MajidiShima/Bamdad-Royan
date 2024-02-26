package com.barok.interview.service;

import com.barok.interview.domain.Wallet;
import com.barok.interview.dto.BalanceDto;
import com.barok.interview.exception.CustomException;
import com.barok.interview.repository.WalletRepository;
import com.barok.interview.service.mapper.WalletMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Transactional(readOnly = true)
    public BalanceDto getBalance(Long userId) {
        log.info("Getting balance for user id {}", userId);
        Wallet wallet = walletRepository.findByUserId(userId).orElseThrow(new CustomException("Wallet not found"));
        return walletMapper.walletToBalanceDto(wallet);
    }

    @Transactional(readOnly = true)
    public Wallet getWalletByUserId(Long userId) {
        log.info("Getting wallet for user id {}", userId);
        return walletRepository.findByUserId(userId).orElseThrow(new CustomException("Wallet not found"));
    }

    @Transactional
    public void addAmount(Long walletId, Integer amount) {
        log.info("Adding amount {} to wallet with id {}", amount, walletId);
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(new CustomException("Wallet not found"));
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);
    }
}

