package com.swagger.config;

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
 * @ClassName: MySwaggerConfig
 * @Description: TODO(Swagger配置)
 * @author vaneu(zhaoxiong1003@qq.com)
 * @date 2017年2月16日 下午4:56:14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		 return new ApiInfoBuilder()
//	                .title("")
	                .description("测试接口Api")
	                .termsOfServiceUrl("127.0.0.1")
	                .version("1.0")
	                .build();
	}
}
