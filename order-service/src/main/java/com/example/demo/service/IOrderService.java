package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.service.common.TransactionResponse;

public interface IOrderService {

	public TransactionResponse placeOrder(Order order);
}
