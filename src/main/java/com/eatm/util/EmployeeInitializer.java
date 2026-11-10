package com.eatm.util;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EmployeeInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		return new Class[] {EmployeeConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
