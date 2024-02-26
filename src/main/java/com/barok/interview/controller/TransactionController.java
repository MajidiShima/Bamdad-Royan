package com.barok.interview.controller;

import com.barok.interview.dto.BalanceDto;
import com.barok.interview.dto.TransactionInputDto;
import com.barok.interview.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController extends BaseController {

	private TransactionService transactionService;

	@PostMapping("/add-money")
	public ResponseEntity<BalanceDto> getBalance(@RequestBody TransactionInputDto dto) {
		log.debug("REST request to add money dto : {}", dto);
		try {
			return success(transactionService.save(dto));
		} catch (Exception e) {
			return failure(e);
		}
	}





}
