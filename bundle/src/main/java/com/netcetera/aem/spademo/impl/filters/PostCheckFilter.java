package com.netcetera.aem.spademo.impl.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.servlets.ServletResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet {@link Filter} that checks the SPA-like dynamic calls.
 * 
 * @author andon.sikavica
 */
@SlingFilter(generateComponent = false, generateService = true, order = -700, scope = SlingFilterScope.REQUEST)
@Component(immediate = true, metatype = false)
public class PostCheckFilter implements Filter {

  @Reference
  private ServletResolver servletResolver;

  private Logger logger = LoggerFactory.getLogger(PostCheckFilter.class);

  /**
   * no-operation.
   * 
   * @param filterConfig {@link FilterConfig}.
   * @throws ServletException never.
   */
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  /**
   * TODO: ASI.
   * 
   * @param request {@link ServletRequest}.
   * @param response {@link ServletResponse}.
   * @param chain {@link FilterChain}.
   * @throws IOException
   * @throws ServletException
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;
    Servlet servlet = servletResolver.resolveServlet(slingRequest);
    if (servlet != null && "SlingPostServlet".equals(servlet.getClass().getSimpleName())) {
      logger.info("ASI: SlingPostServlet is handling the request");
    }
    logger.debug("request for {}, with selector {}", slingRequest.getRequestPathInfo().getResourcePath(),
        slingRequest.getRequestPathInfo().getSelectorString());

    chain.doFilter(request, response);
  }

  /**
   * no-operation.
   */
  public void destroy() {
  }

}
