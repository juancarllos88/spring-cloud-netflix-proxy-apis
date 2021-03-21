package br.com.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.payments.dto.PaymentRequestTo;
import br.com.service.PaymentProcessorService;

@Component
public class PaymentProcessorListener {

	@Autowired
	private PaymentProcessorService service;

	private static final Logger log = LoggerFactory.getLogger(PaymentProcessorListener.class);

	private static final String QUEUE_PAYMENTS = "payments";

	@JmsListener(destination = QUEUE_PAYMENTS)
	public void onReceiverQueue(PaymentRequestTo pagamento) {
		log.info("Recebendo pagamento da fila {}", QUEUE_PAYMENTS);
		service.processingPayment(pagamento);
	}

}
