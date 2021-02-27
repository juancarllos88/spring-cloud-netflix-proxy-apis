package br.com.providers.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providers")
public class ProviderController {

	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		List<String> sellers = Arrays.asList("Americanas", "Submarino", "Ali-Express");
		return ResponseEntity.ok().body(sellers);
	}

}
