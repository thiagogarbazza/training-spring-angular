package com.github.thiagogarbazza.training.springangular.rest;

import lombok.extern.apachecommons.CommonsLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@CommonsLog
class EmbeddedJetty {

  private final Server server;

  public EmbeddedJetty(final int port) {
    this.server = new Server(port);
  }

  public void run() {
    log.info("Starting...");
    server.setHandler(servletContextBuilder());

    try {
      server.start();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void stop() {
    try {
      server.stop();
      server.join();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private ContextHandler servletContextBuilder() {
    ServletContextHandler contextHandler = new ServletContextHandler();

    final WebApplicationContext webApplicationContext = webApplicationContextBuilder();
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
    ServletHolder springServletHolder = new ServletHolder(dispatcherServlet);
    contextHandler.addServlet(springServletHolder, "/*");
    contextHandler.addEventListener(new ContextLoaderListener(webApplicationContext));

    return contextHandler;
  }

  private static WebApplicationContext webApplicationContextBuilder() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(RestExecucaoLocalConfiguration.class);
    return context;
  }
}
