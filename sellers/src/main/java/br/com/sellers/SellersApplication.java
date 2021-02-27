package br.com.sellers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SellersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellersApplication.class, args);
	}

}
