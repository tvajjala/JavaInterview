package com.suretouch.web.context;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.suretouch.core.bootstrap.ApplicationProcessor;

public class SureTouchContextListener extends ContextLoaderListener {

	@Override
	public WebApplicationContext initWebApplicationContext(
			ServletContext servletContext) {
		WebApplicationContext context = super.initWebApplicationContext(servletContext);

		ApplicationProcessor processor = (ApplicationProcessor) context
				.getBean("applicationProcessor");

		processor.init();

		return context;
	}

}
