package com.pravin.clock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author pravin.dilpak
 * @since 05-07-2023
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.pravin.clock"})
public class SpringConfig implements WebMvcConfigurer{

	public SpringConfig() {
		
		System.out.println("Load SpringConfig()...");
	}
	

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
	public javax.validation.Validator localValidatorFactoryBean() {
	    return new LocalValidatorFactoryBean();
	}
}
