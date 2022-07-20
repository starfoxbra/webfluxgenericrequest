package com.aoki.springwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class GenericController {
	
	@Autowired
	private TransactionService transactionService;
	
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> getEpisodeById(HttpEntity<String> httpEntity) {
        return transactionService.makeTransaction(httpEntity.getBody());
    }

}
