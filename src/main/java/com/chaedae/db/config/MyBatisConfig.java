package com.chaedae.db.config;

import java.io.Serializable;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.**.dao", annotationClass = Mapper.class)
public class MyBatisConfig extends DataSourceConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	
    @Bean(name = "sqlSession")
    public SqlSessionFactoryBean getSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.dataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/sqlmap/config/mybatis-config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.chaedae");
        sqlSessionFactoryBean.setTypeAliasesSuperType(Serializable.class);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/mapper/**/*.xml"));

        return sqlSessionFactoryBean;
    }
 
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager() throws Exception {
    		return new DataSourceTransactionManager(this.dataSource());
    }
}
