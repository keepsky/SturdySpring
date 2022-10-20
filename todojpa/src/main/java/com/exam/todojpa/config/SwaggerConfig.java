package com.exam.todojpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {

	private static final String API_NAME = "ToDO API";
	private static final String API_VERSION = "1.0.0";
	private static final String API_DESCRIPTION = "specification for todo service";
	
	@Bean
	public Docket todosApi() {
		return getDocket("todos", Predicates.or(PathSelectors.regex("/api/todos.*")));
	}

	@Bean
	public Docket allApi() {
		return getDocket("all", Predicates.or(PathSelectors.any()));
	}
	
	public Docket getDocket(String groupName, Predicate<String> predicate) {
		// TODO Auto-generated method stub
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
			    .groupName(groupName).select()
			    .apis(RequestHandlerSelectors.basePackage("com.exam.todojpa")).paths(predicate)
			    .apis(RequestHandlerSelectors.any()).paths(predicate)
			    .build();
	}
	
	private ApiInfo apiInfo() {
		  return new ApiInfoBuilder()
				  .title(API_NAME)
				  .description(API_DESCRIPTION)
				  .version(API_VERSION)
				  .build();
	 }
}
