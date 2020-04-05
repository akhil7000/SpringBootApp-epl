package com.football.epl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class EplApplication {

	public static void main(String[] args) {
		SpringApplication.run(EplApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}

	private static ApiInfo apiDetails() {
		String implementationVersion = EplApplication.class.getPackage().getImplementationVersion();
		return new ApiInfo(
				"EPL APPLICATION SERVICE API",
				"Everything about EPL Football Teams and Players",
				implementationVersion,
				"",
				new springfox.documentation.service.Contact("Akhil Cherian", "", "akhil7000@gmail.com"),
				"EPL Application reference docs",
				"",
				Collections.emptyList());
	}




}
