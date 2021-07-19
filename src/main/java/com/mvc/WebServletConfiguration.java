package com.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfiguration.class);
		ServletRegistration.Dynamic servDynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servDynamic.setLoadOnStartup(1);
		servDynamic.addMapping("/");
		System.out.println(servletContext.getContextPath());
	}

}
