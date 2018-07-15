package com.chaedae.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.chaedae.db.config.HibernateConfig;

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
		return new Class[] { HibernateConfig.class};
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
	 * Servlet RequestMapping
	 * old : servlet-mapping > url-pattern
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	/**
	 * Servlet Filter
	 * old : filter
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true, true);

		return new Filter[] { characterEncodingFilter };
	}
	
}
