package com.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * The config application class.
 * @author pgvishnu
 *
 */

@SpringBootApplication
public class ConfigApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
	
    /**
     * 	H2 database registration
     * @return the ServletRegistrationBean
     */
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}

}
