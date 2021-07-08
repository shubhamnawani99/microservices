package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.IPaymentService;

@RequestMapping(value = "/payment")
@RestController
public class PaymentController {

	@Autowired
	IPaymentService pservice;

	/*
	 * @URL:  http://localhost:8002/payment/makePayment
	 * 
	 * @Data: {"amount":10002.21}
	 */
	@PostMapping(value = "/makePayment")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
		Payment paymentDone = pservice.makePayment(payment);
		return new ResponseEntity<Payment>(paymentDone, HttpStatus.CREATED);
	}
}
