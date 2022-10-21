package com.exam.todojpa.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
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
    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build();
    }
    
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
    
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
    
	public Docket getDocket(String groupName, Predicate<String> predicate) {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext())) // bearer인증 설정
                .securitySchemes(Arrays.asList(apiKey())) // bearer 인증 설정 
				.apiInfo(apiInfo())
				.groupName(groupName).select()
				.apis(RequestHandlerSelectors.basePackage("com.exam.todojpa")).paths(predicate)
				.apis(RequestHandlerSelectors.any()).build();
	}
	
	private ApiInfo apiInfo() {
		  return new ApiInfoBuilder()
				  .title(API_NAME)
				  .description(API_DESCRIPTION)
				  .version(API_VERSION)
				  .build();
	 }
}
