package org.fictive.coffeeshop;

import org.fictive.coffeeshop.utils.APIConstant;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = APIConstant.API_ORDER_SERVICE, version = "1.0", description = APIConstant.API_ORDER_SERVICE_SPEC))
@EntityScan("org.fictive.models.entity")
public class OrderBootup {
	public static void main(String[] args) {
		SpringApplication.run(OrderBootup.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
