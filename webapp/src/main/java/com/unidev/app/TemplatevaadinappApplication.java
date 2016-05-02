package com.unidev.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class TemplatevaadinappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplatevaadinappApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
		return container -> {
			container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html"));
		};
	}

}
