package com.iiht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZullApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ZullApiGateway.class, args);
	}
	
	/*
	 * @Bean public RoutingAndGatewayFilters simpleFilter() { return new
	 * RoutingAndGatewayFilters(); }
	 */

	 
	 @Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
				}
			};
		}
//	 
//		@Bean
//		@Primary
//		public CorsFilter corsFilter() {
//		    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		    final CorsConfiguration config = new CorsConfiguration();
//		    config.setAllowCredentials(false);
//		    config.setAllowCredentials(true);
//		    config.addAllowedOrigin("*");
//		    config.addAllowedHeader("*");
//		    config.addAllowedMethod("*");
//		    source.registerCorsConfiguration("*", config);
//		    return new CorsFilter(source);
//		}
}
