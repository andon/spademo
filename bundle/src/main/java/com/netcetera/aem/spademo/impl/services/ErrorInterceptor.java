package com.netcetera.aem.spademo.impl.services;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ErrorInterceptor implements MethodInterceptor {
	
	@Resource
	private RequestService requestService;
	
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		if (requestService.isDynamicCall()) {
			try {
				return methodInvocation.proceed();
			} catch (ConferenceException e) {
				JsonObject json = new JsonObject();
				json.addProperty("errorMessage", e.getMessage());
				return new Gson().toJson(json);
			} catch (Exception e) {
				JsonObject json = new JsonObject();
				json.addProperty("errorUrl", "404.html");
				return new Gson().toJson(json);
			}
		}
		
		return methodInvocation.proceed();
	}

}
