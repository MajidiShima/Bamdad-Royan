package com.barok.interview.controller;

import com.barok.interview.dto.BalanceDto;
import com.barok.interview.service.WalletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController extends BaseController {

	private final WalletService walletService;

	@GetMapping("/get-balance/{userId}")
	public ResponseEntity<BalanceDto> getBalance(@PathVariable Long userId) {
		log.debug("REST request to get balance for user id : {}", userId);
		try {
			return success(walletService.getBalance(userId));
		} catch (Exception e) {
			return failure(e);
		}
	}


}
