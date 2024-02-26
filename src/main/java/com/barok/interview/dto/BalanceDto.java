package com.barok.interview.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class BalanceDto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private int balance;
}
