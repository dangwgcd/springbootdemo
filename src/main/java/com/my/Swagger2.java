//package com.my;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Created by wt on 2017/12/4.
// */
//@Configuration//通过@Configuration注解，让Spring来加载该类配置
//@EnableSwagger2//再通过@EnableSwagger2注解来启用Swagger2
//public class Swagger2 {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.my"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("RESTful APIs")
//                .description("SpringBootDemo中使用Swagger2构建RESTful APIs")
//                .termsOfServiceUrl("http://www.51jiabo.com")
//                .contact("wt")
//                .version("1.0")
//                .build();
//    }
//}
