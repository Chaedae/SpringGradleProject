package com.chaedae.db.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.chaedae" })
public class HibernateConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	
    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws Exception {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSourceConfig.dataSource());
        factoryBean.setPackagesToScan(new String[] {"com.chaedae.model"});
        
        Properties props = new Properties();
        props.load(applicationContext.getResource("classpath:/config/props/hibernate.properties").getInputStream());
        
        factoryBean.setHibernateProperties(props);
        return factoryBean;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
	
}
