package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@EnableResourceServer
@Configuration
public class ResourceServerConfiguration implements ResourceServerConfigurer {

	@Value("${resource_id.product_api}")
	private String productApi;

	@Autowired
	private TokenStore jdbcTokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(productApi).tokenStore(jdbcTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new SimpleCorsFilter(), ChannelProcessingFilter.class);
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('READ')")
			.antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('WRITE')")
			.antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('WRITE')")
			.antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('WRITE')")
			.antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('WRITE')");
			/*.and()
			.headers().addHeaderWriter((request, response) -> {
				response.addHeader("Access-Control-Allow-Origin", "*");
				if (request.getMethod().equals("OPTIONS")) {
					response.setHeader("Access-Control-Allow-Methods",request.getHeader("Access-Control-Request-Method"));
					response.setHeader("Access-Control-Allow-Headers",request.getHeader("Access-Control-Request-Headers"));
				}else {
					
				}
			});*/

	}

}
