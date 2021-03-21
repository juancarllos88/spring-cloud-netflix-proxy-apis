package br.com.payments.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.payments.dto.PaymentRequestTo;
import br.com.payments.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		List<String> sellers = Arrays.asList("Pic-Pay", "Cartão", "Pix");
		return ResponseEntity.ok().body(sellers);
	}
	
	@PostMapping
	public ResponseEntity<String> payment(@RequestBody PaymentRequestTo request){
		service.payment(request);
		return ResponseEntity.ok().body("Aguarde a confirmação do pagamento");
	}

}
