package com.example.demo.service.common;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionResponse {
	private Integer orderId;
	private Integer pid;
	private String pstatus;
	private String transactionId;
	private Date transactionDate;
	private Double amount;
	private String productName;
	private Integer quantity;
}
