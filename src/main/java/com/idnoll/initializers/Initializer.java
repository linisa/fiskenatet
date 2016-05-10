package com.idnoll.initializers;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext annotationContext = new AnnotationConfigWebApplicationContext();
		annotationContext.register(WebConfiguration.class);
		
		annotationContext.setServletContext(servletContext);
		
		registerHiddenHttpMethodFilter(servletContext);
		
		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(annotationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

	private void registerHiddenHttpMethodFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
		filterDynamic.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD),false,DISPATCHER_SERVLET_NAME);
		
	}

}
