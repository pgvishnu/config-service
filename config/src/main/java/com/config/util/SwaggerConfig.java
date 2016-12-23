package com.config.util;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.ordering.ResourceListingPositionalOrdering;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 
 * The Class SwaggerConfig.
 * 
 * @author pgvishnu
 *
 */
@Conditional(SwaggerConfig.SwaggerEnabledCondition.class)
@Configuration
@ComponentScan(basePackageClasses = SpringSwaggerConfig.class)
@EnableSwagger
public class SwaggerConfig {

	/** The api info. */
	private ApiInfo apiInfo;

	/** The spring swagger config. */
	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Gets the api info.
	 *
	 * @return the api info
	 */
	public ApiInfo getApiInfo() {
		return apiInfo;
	}

	// @formatter:off
	/**
	 * Gets the swagger spring mvc plugin customization.
	 *
	 * @return the swagger spring mvc plugin customization
	 */
	@Bean
	public SwaggerSpringMvcPlugin getSwaggerSpringMvcPluginCustomization() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(getApiInfo()).includePatterns(".*\\/api\\/.*")
				.apiListingReferenceOrdering(new ResourceListingPositionalOrdering());
		// @formatter:on
	}

	// @formatter:off
	/**
	 * Sets the api info.
	 *
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param termsOfServiceUrl
	 *            the terms of service url
	 * @param contactEmail
	 *            the contact email
	 * @param licenseType
	 *            the license type
	 * @param licenseUrl
	 *            the license url
	 */
	@Inject
	protected void setApiInfo(@Value("Config Service API") String title,
			@Value("Config Service API") String description, @Value("N/A") String termsOfServiceUrl,
			@Value("pgvishnu@gmail.com") String contactEmail, @Value("N/A") String licenseType,
			@Value("N/A") String licenseUrl) {
		// @formatter:on
		apiInfo = new ApiInfo(title, description, termsOfServiceUrl, contactEmail, licenseType, licenseUrl);
	}

	/**
	 * The Class SwaggerEnabledCondition.
	 */
	protected static class SwaggerEnabledCondition implements Condition {

		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			boolean isEnabled = Boolean.valueOf(context.getEnvironment().getProperty("config.swagger.enabled"));
			return isEnabled;
		}

	}

}
