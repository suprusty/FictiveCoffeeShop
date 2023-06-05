package org.fictive.coffeeshop.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class BaristaClientConfig {
	private static final Logger logger = LogManager.getLogger(BaristaClientConfig.class);

	final static WebClient webClient = WebClient.create("http://barista-svc:8081");

	public static void processOrder(Long orderID) {
		try {
			Mono<Void> responseMono = webClient.put().uri("/barista/task/process/" + orderID)
					.contentType(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Void.class);

			responseMono.subscribe(success -> {
				logger.info("Resource updated successfully" + orderID);
			}, error -> {
				logger.error("Error: " + orderID + error.getMessage());
			});
		} catch (Exception exp) {
			logger.error("Error: " + exp);
		}
	}
}
