
package com.suhas.service.lookup.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Lookup Service Application REST API")
                .description("REST API reference for Lookup Reference Application")
                .termsOfServiceUrl("https://www.linkedin.com/in/suhas-saheer-bb570215/")
                .contact("Suhas Saheer").license("@CopyRight suhaz786@gmail.com")
                .licenseUrl("suhaz786@gmail.com").version("1.0").build();
    }

}
