package com.netcetera.aem.spademo.impl.services;

import javax.servlet.http.HttpServletRequest;

import org.apache.sling.api.SlingHttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class RequestService {

	private static final String HEADER_X_REQUEST_SOURCE = "X-Request-Source";
	
	private static final String HEADER_X_REQUEST_SOURCE_DYNAMIC_CALL = "spa-ajax";
	
    public boolean isDynamicCall() {
        return HEADER_X_REQUEST_SOURCE_DYNAMIC_CALL.equalsIgnoreCase(getRequest().getHeader(HEADER_X_REQUEST_SOURCE));
    }
    
    private SlingHttpServletRequest getRequest() {
    	RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    	if (requestAttributes != null && requestAttributes instanceof ServletRequestAttributes) {
    		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
    		if (request instanceof SlingHttpServletRequest) {
    			return (SlingHttpServletRequest) request;
    		}
    	}
    	throw new IllegalStateException("Method called outside of request scope.");
    }

}
