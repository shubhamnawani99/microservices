package com.example.demo.service.common;

import com.example.demo.model.Order;

import lombok.Data;

@Data
public class TransactionRequest {
	private Order order;
}
