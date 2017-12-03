package com.chaedae.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <h1>Deployment Descriptor</h1>
 * old : web.xml
 * @author ChaeDae
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * Database Configuration
	 * old : root-context.xml
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Servlet Configuration
	 * old : servlet-context.xml
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	/**
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
