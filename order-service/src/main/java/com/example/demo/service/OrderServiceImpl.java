package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Order;
import com.example.demo.repo.OrderRepository;
import com.example.demo.service.common.Payment;
import com.example.demo.service.common.TransactionResponse;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orepo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${payment.url}")
	private String url;

	@Value("${payment.pricePerUnit}")
	private String pricePerUnit;

	@Override
	public TransactionResponse placeOrder(Order order) {
		
		// set the TOTAL_PRICE of the products
		order.setPrice(Double.parseDouble(pricePerUnit) * order.getQuantity());

		// save the Transaction Order Request in the DB
		Order savedOrder = orepo.save(order);

		// set the payment amount EQUAL to the TOTAL PRICE OF ORDERS
		Payment payment = new Payment();
		payment.setAmount(savedOrder.getPrice());
		payment.setOrderId(savedOrder.getOrderId());

		// call the service from payment controller to get the saved Payment
		Payment savedPayment = restTemplate.postForObject(url, payment, Payment.class);

		// send back the transaction response
		return new TransactionResponse(savedOrder.getOrderId(), savedPayment.getPid(), savedPayment.getPaymentStatus(),
				savedPayment.getTransactionId(), savedPayment.getTransactionDate(), savedPayment.getAmount(),
				savedOrder.getProductName(), savedOrder.getQuantity());
	}

}
