package com.cognizant.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.gateway.services.TokenService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tokens")
public class GatewayController {
	@Autowired
	private TokenService tokenService;
	@GetMapping("/sre/v1.0")
	public Mono<String> getSREToken() {
		return tokenService.getToken("keycloak-with-sre-scope");
	}
	@GetMapping("/devopsengineer/v1.0")
	public Mono<String> getDevOpsEngineerToken() {
		return tokenService.getToken("keycloak-with-devopsengineer-scope");
	}
	
}
