package com.aoki.springwebflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class TransactionService {

	private final WebClient webClient;

	public TransactionService(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("http://localhost:8081/post").build();
	}
	
	  public Mono<String> makeTransaction(String requestBody) {
		  return webClient.post()
				    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
				    .accept(MediaType.APPLICATION_JSON)
				    .bodyValue(requestBody)
				    .retrieve()
				    .bodyToMono(String.class);
	    }

}
