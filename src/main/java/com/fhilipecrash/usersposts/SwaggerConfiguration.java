package com.fhilipecrash.usersposts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    final List<Response> globalResponses = Arrays.asList(
        new ResponseBuilder().code("200").description("OK").build(),
        new ResponseBuilder().code("201").description("Created").build(),
        new ResponseBuilder().code("400").description("Bad Request").build(),
        new ResponseBuilder().code("401").description("Unauthorized").build(),
        new ResponseBuilder().code("500").description("Internal Server Error").build()
    );

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Mini Social Media API")
            .description("An example of a mini social media API")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .contact(new Contact("Fhilipe Coelho",
                "https://github.com/fhilipecrash",
                "fhilipecoelho.dev@gmail.com")
            )
            .build();
    }

    @Bean
    public Docket api() throws IOException, URISyntaxException {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.fhilipecrash.usersposts.controller"))
            .paths(PathSelectors.ant("/api/**"))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
            .globalResponses(HttpMethod.GET, globalResponses)
            .globalResponses(HttpMethod.POST, globalResponses)
            .globalResponses(HttpMethod.PUT, globalResponses)
            .globalResponses(HttpMethod.DELETE, globalResponses);
    }
}

