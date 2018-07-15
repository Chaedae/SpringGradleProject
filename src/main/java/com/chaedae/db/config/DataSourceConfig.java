package com.chaedae.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * <h1>Datasource Configuration</h1>
 * old : root-context.xml > dataSource
 * @author ChaeDae
 */
@Configuration
@PropertySource("classpath:config/props/db.properties")
public class DataSourceConfig {

	@Autowired
	private Environment env;
	
	@Primary
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		
		// Set Database Info
		config.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		config.setJdbcUrl(env.getProperty("jdbc.url"));
		config.setUsername(env.getProperty("jdbc.user"));
		config.setPassword(env.getProperty("jdbc.passwd"));
		
		// Set HikariCP Configuration
		config.setConnectionTimeout(Integer.parseInt(env.getProperty("hikaricp.connection_timeout")));
		config.setMinimumIdle(Integer.parseInt(env.getProperty("hikaricp.minimum_idle")));
		config.setMaximumPoolSize(Integer.parseInt(env.getProperty("hikaricp.maximum_pool_size")));
		config.setIdleTimeout(Integer.parseInt(env.getProperty("hikaricp.idle_timeout")));
		
		return new HikariDataSource(config);
	}
	
	/**
	 * Default Database Schema & data 
	 * @return
	 */
	@Bean
    public DataSourceInitializer dataSourceInitializer() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/config/sql/H2DB-schema.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/config/sql/H2DB-data.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }
}
