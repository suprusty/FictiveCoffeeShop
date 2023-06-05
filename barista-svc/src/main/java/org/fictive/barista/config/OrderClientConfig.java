package org.fictive.barista.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class OrderClientConfig {

	private static final Logger logger = LogManager.getLogger(OrderClientConfig.class);

	final static WebClient webClient = WebClient.create("http://order-svc:8080");

	public static void processOrder(Long orderID) {
		try {
			Mono<Void> responseMono = webClient.delete().uri("/coffeeshop/orders/" + orderID)
					.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Void.class);

			responseMono.subscribe(success -> {
				logger.info("Resource Deleted successfully" + orderID);
			}, error -> {
				logger.error("Error: " + orderID + error.getMessage());
			});
		} catch (Exception exp) {
			logger.error("Error: " + exp);
		}
	}
}
