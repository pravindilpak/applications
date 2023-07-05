package com.pravin.clock.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author pravin.dilpak
 *
 */

@Order(1)
public class WebServletConfiguration implements WebApplicationInitializer {

	public void onStartup(ServletContext ctx) throws ServletException {

		System.out.println("Load WebServletConfiguration()...");
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringConfig.class);

		webCtx.setServletContext(ctx);

		ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
		dispatcher.setLoadOnStartup(1);
		dispatcher.setAsyncSupported(true);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
