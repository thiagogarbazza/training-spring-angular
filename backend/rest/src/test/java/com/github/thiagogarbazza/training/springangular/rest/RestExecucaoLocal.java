package com.github.thiagogarbazza.training.springangular.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

class RestExecucaoLocal {

  private final int PORT = 8080;

  private RestExecucaoLocal() {

  }

  ServletContextHandler servletContextBuilder(final WebApplicationContext webAppContext) {
    ServletContextHandler contextHandler = new ServletContextHandler();

    DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
    ServletHolder springServletHolder = new ServletHolder(dispatcherServlet);
    contextHandler.addServlet(springServletHolder, "/*");
    contextHandler.addEventListener(new ContextLoaderListener(webAppContext));

    return contextHandler;
  }

  void start(WebApplicationContext webAppContext) throws Exception {
    Server server = new Server(PORT);

    server.setHandler(servletContextBuilder(webAppContext));

    server.start();
  }

  public static void main(String[] args) throws Exception {
    new RestExecucaoLocal().start(contextBuilder());
  }

  private static WebApplicationContext contextBuilder() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(RestExecucaoLocalConfiguration.class);
    return context;
  }
}
