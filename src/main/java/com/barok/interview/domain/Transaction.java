package com.barok.interview.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
public class Transaction implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "date")
	private Instant date = Instant.now();

	@ManyToOne
	@JoinColumn(name = "wallet_id")
	@ToString.Exclude
	private Wallet wallet;
}
