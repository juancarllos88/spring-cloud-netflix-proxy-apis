package br.com.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.dto.PaymentAuthorizedTo;
import br.com.dto.PaymentRejectedTo;
import br.com.model.Card;
import br.com.payments.dto.PaymentRequestTo;
import br.com.repository.CardRepository;

@Service
public class PaymentProcessorService {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentProcessorService.class);
	
	@Value("${payments-processor.activemq.fila.authorized-payments}")
    private String filaPagamentosAutorizados;
	
	@Value("${payments-processor.activemq.fila.rejected-payments}")
    private String filaPagamentosRejeitados;
	
	@Autowired
	private CardRepository repository;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void processingPayment(PaymentRequestTo pagamento) {
		try {
			log.info("Processando Pagamento: {}", pagamento.toString());
			Card card = repository.findByCpf(pagamento.getCpf())
					.orElseThrow(() -> new RuntimeException("CPF não encontado"));
			
			if(!pagamento.getCard().equals(card.getCard()) || !pagamento.getCvv().equals(card.getCvv())) {
				throw new RuntimeException("Dados do cartão estão incosistentes");
			}
			
			if(pagamento.getValue().compareTo(card.getLimite()) > 0) {
				throw new RuntimeException("Cartão com limite insuficiente");
			}else {
				BigDecimal newLimit = card.getLimite().setScale(2, RoundingMode.HALF_EVEN)
						.subtract(pagamento.getValue().setScale(2, RoundingMode.HALF_EVEN));
				card.setLimite(newLimit);
				repository.save(card);
			}
			
			sendToAuthorizedPayments(pagamento.getIdPayment());
		} catch (Exception e) {
			sendToRejectedPayments(e.getMessage(), pagamento.getIdPayment());
		}
			
	}
	
	
	public void sendToRejectedPayments(String reason, String idPayment) {
		PaymentRejectedTo rejected = new PaymentRejectedTo(idPayment, reason);
		jmsTemplate.convertAndSend(filaPagamentosRejeitados, rejected);
		log.info("Pagamento {} enviado para fila {}", idPayment, filaPagamentosRejeitados);
		log.info("Motivo: {}", rejected.getReason());
	}
	
	public void sendToAuthorizedPayments(String idPayment) {
		PaymentAuthorizedTo authorized = new PaymentAuthorizedTo(idPayment, "Pagamento Autorizado");
		jmsTemplate.convertAndSend(filaPagamentosAutorizados, authorized);
		log.info("Pagamento {} enviado para fila {}", idPayment, filaPagamentosAutorizados);
	}
	
	
	
}
