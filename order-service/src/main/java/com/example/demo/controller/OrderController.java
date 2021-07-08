package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.IOrderService;
import com.example.demo.service.common.TransactionResponse;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private IOrderService oservice;

	/*
	 * @URL: http://localhost:8001/order/placeOrder
	 * 
	 * @Data: {"productName":"Phone", "quantity": 10}
	 */
	@PostMapping(value = "/placeOrder")
	public ResponseEntity<TransactionResponse> saveOrder(@RequestBody Order order) {
		TransactionResponse savedOrder = oservice.placeOrder(order);
		return new ResponseEntity<TransactionResponse>(savedOrder, HttpStatus.CREATED);
	}
}
