package br.mmc.spotippos.config.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true)
                .groupName("spotippos-api-info")
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.mmc.spotippos"))
                .paths(postPaths())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API Spotippos",
                "API que disponibiliza endpoints para criacao de imovel nas provincias de Spotippos",
                "1.0",
                "Terms of Service",
                new Contact("Suporte MMC", "http://fale-conosco.mmc.com.br/portal/faleconosco",
                        "suporte@mmc.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/spotippos/imovel.*"));
    }
}
