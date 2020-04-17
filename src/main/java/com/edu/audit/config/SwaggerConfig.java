package com.edu.audit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/1/16 11:13
 * @Version: v1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //分隔符定义
    private static final String splitor = ";";

    @Bean
    public Docket authorityApi() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("权限管理")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.audit.authority"))
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    public Docket businessDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("业务管理")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.audit.business"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket logDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("日志管理")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.audit.sysLog"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket testDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试接口")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.audit.test"))
                .paths(PathSelectors.any())
                .build();
    }


    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工程跟踪审计管理系统开发接口文档")
                .description("工程跟踪审计管理系统开发毕业设计")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
