package com.example.demo.config;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using  = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception{

	private static final long serialVersionUID = -5782823924423415216L;

	public CustomOauthException(String msg) {
		super(msg);
	}

}
