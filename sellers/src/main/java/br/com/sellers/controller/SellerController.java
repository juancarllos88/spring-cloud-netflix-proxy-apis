package br.com.sellers.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		List<String> sellers = Arrays.asList("Juan", "Elton", "Fagner");
		return ResponseEntity.ok().body(sellers);
	}

}
