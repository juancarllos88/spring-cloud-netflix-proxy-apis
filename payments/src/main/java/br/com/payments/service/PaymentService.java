package br.com.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.payments.dto.PaymentRequestTo;

@Service
public class PaymentService {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	@Value("${payments.activemq.fila}")
    private String filaPagamentos;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void payment(PaymentRequestTo request) {
		request.setIdPayment(UUID.randomUUID().toString());
		log.info("Enviando pagamento {} para fila {}", request.toString(), filaPagamentos);
		jmsTemplate.convertAndSend(filaPagamentos, request);
		log.info("Pagamento Enviado com sucesso");
		
	}

}
