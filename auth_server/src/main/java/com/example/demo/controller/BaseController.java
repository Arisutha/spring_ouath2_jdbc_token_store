package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class BaseController {

	protected static final Log LOG = LogFactory.getLog("FLOW_LOG");
	
	protected ObjectMapper objectMapper = new ObjectMapper();
}
