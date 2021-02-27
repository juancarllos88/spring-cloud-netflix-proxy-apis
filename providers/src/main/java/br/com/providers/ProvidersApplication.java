package br.com.providers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProvidersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidersApplication.class, args);
	}

}
