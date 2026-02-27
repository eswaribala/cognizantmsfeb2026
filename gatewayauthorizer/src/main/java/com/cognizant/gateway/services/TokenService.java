package com.cognizant.gateway.services;

import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class TokenService {
	
	private ReactiveOAuth2AuthorizedClientManager authManager;
	
	// Constructor injection of ReactiveClientRegistrationRepository and ServerOAuth2AuthorizedClientRepository
	public TokenService(ReactiveClientRegistrationRepository repository,
			ServerOAuth2AuthorizedClientRepository authClientRepo) {
		// Configure the ReactiveOAuth2AuthorizedClientProvider to support client credentials grant type
		ReactiveOAuth2AuthorizedClientProvider reactiveOAuth2AuthorizedClientProvider = 
				ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
				.clientCredentials().build();
		// Create a DefaultReactiveOAuth2AuthorizedClientManager with the provided repositories and the configured provider
		DefaultReactiveOAuth2AuthorizedClientManager defaultReactiveOAuth2AuthorizedClientManager = 
				new DefaultReactiveOAuth2AuthorizedClientManager(repository, authClientRepo);
		defaultReactiveOAuth2AuthorizedClientManager.setAuthorizedClientProvider
		(reactiveOAuth2AuthorizedClientProvider);
		// Assign the configured DefaultReactiveOAuth2AuthorizedClientManager to the authManager field
		this.authManager = defaultReactiveOAuth2AuthorizedClientManager;
		
	}
	
	public Mono<String> getToken(String clientRegistrationId) {
		//
		OAuth2AuthorizeRequest auth2AuthorizeRequest = OAuth2AuthorizeRequest
				.withClientRegistrationId(clientRegistrationId)
				.principal("gateway").build();
		// Use the authManager to authorize the request and retrieve the access token value
		return this.authManager.authorize(auth2AuthorizeRequest)
				.map(auth2AuthorizedClient -> auth2AuthorizedClient.getAccessToken()
						.getTokenValue());
		
	}
	
	
	

}
