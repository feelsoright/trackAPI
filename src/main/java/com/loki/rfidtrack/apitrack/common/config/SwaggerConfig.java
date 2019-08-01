package com.loki.rfidtrack.apitrack.common.config;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Loki.C
 * @date:Created in 2019/7/29 17:34
 * @description:
 * @modified by:
 * @version:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
    	 ParameterBuilder ticketPar = new ParameterBuilder();
         List<Parameter> pars = new ArrayList<Parameter>();
         ticketPar.name("Authorization").description("认证token")
                 .modelRef(new ModelRef("string")).parameterType("header")
                 //header中的ticket参数非必填，传空也可以
                 .required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
         pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RFID-API")
                .description("powered by Loki.C")
                .termsOfServiceUrl("http://www.boyun.com/")
                .version("1.0")
                .build();
    }
}