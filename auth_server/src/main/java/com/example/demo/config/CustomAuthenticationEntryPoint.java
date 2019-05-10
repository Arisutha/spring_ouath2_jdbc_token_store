package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
			throws IOException, ServletException {
		logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
		String message = "";
        
        if(e.getClass() == BadCredentialsException.class) {
			message = "Wrong username or password";
		} else {
			message = "Sorry, You're not authorized to access this resource.";
		}
        
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, message);
		
	}

}
