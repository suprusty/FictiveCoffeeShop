package org.fictive.barista;

import org.fictive.barista.utils.APIConstant;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = APIConstant.API_BARISTA_SERVICE, version = "1.0", description = APIConstant.API_BARISTA_SERVICE_SPEC))
@EntityScan("org.fictive.models.entity")
public class BaristaBootup {
	public static void main(String[] args) {
		SpringApplication.run(BaristaBootup.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("OpenApiController").packagesToScan("org.fictive.barista.controller")
				.build();
	}
}
