package com.example.demoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test", "gray", "prod"})
public class SwaggerConfiguration {
    /**
     * apiInfo() create API info
     * select() return an instance of ApiSelectorBuilder to control apis to be showed by Swagger
     * in this demo, we use package path to control apis on show
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * create API base info
     * you can visit http://127.0.0.7:9876/doc.html after server has been started
     *
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("framework-demo")
                .description("")
                .termsOfServiceUrl("https://github.com/starkerry")
                .contact(new Contact("yebinxing", "", "starkerry2011@gmail.com"))
                .version("1.0")
                .build();
    }
}
