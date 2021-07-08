package com.example.demo.service.common;

import java.util.Date;

import lombok.Data;

@Data
public class Payment {

	private Integer pid;
	private String transactionId;
	private String paymentStatus;
	private Date transactionDate;
	private Double amount;
	private Integer orderId;
}
