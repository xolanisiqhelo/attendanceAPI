package com.attendanceAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swaager2Config {
	
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors
							.basePackage("com.attendanceAPI.controllers"))
					.paths(PathSelectors.regex("/.*"))
					.build().apiInfo(metaData());
		}

		private ApiInfo metaData() {

			return new ApiInfoBuilder().title("Students information REST API")
					.description("Students information REST API")
					.contact(new Contact("Xolani Siqhelo", "", "xolonisiqhelo2@gmail.com"))
					.license("Apache 2.0")
					.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
					.version("1.0.0")
					.build();
		}
}
