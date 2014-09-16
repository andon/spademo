package com.netcetera.aem.spademo.impl.services;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Method interceptor, that should be attached to all the controller methods. If
 * it finds out that the methods is invoked for a dynamic call, then it should
 * handle properly in case of an errors.
 * 
 * @author andon.sikavica
 */
public class ErrorInterceptor implements MethodInterceptor {

  @Resource
  private RequestService requestService;

  // CHECKSTYLE:OFF allowing Throwable
  /**
   * 
   * @param methodInvocation {@link MethodInvocation}.
   * @return {@link Object} the result from the method invocation.
   * @throws Throwable When its not dynamic call and the original call throws an
   *           error.
   */
  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    // CHECKSTYLE:ON
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
