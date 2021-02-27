package br.com.payments.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		List<String> sellers = Arrays.asList("Pic-Pay", "Cartão", "Pix");
		return ResponseEntity.ok().body(sellers);
	}

}
