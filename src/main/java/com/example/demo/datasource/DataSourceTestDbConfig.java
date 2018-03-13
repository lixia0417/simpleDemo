package com.example.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据源配置(后台数据配置源)
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao", sqlSessionTemplateRef = "testDbSqlSessionTemplate")
public class DataSourceTestDbConfig {

	@Value("${spring.datasource.testDb.url}")
	private String dbUrl;

	@Value("${spring.datasource.testDb.username}")
	private String username;

	@Value("${spring.datasource.testDb.password}")
	private String password;

	@Value("${spring.datasource.testDb.driverClassName}")
	private String driverClassName;

	@Value("${spring.datasource.testDb.initialSize}")
	private int initialSize;

	@Value("${spring.datasource.testDb.minIdle}")
	private int minIdle;

	@Value("${spring.datasource.testDb.maxActive}")
	private int maxActive;

	@Value("${spring.datasource.testDb.maxWait}")
	private int maxWait;

	@Value("${spring.datasource.testDb.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.testDb.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.testDb.validationQuery}")
	private String validationQuery;

	@Value("${spring.datasource.testDb.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.testDb.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.testDb.testOnReturn}")
	private boolean testOnReturn;

	@Value("${spring.datasource.testDb.filters}")
	private String filters;

	@Bean(name = "testDbDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.testDb")
	public DataSource testDataSource() {
		// return DataSourceBuilder.create().build();
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(this.dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		// configuration
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		try {
			datasource.setFilters(filters);
		} catch (SQLException e) {
			System.err.println("druid configuration initialization filter:" + e);
			e.printStackTrace();
		}
		return datasource;
	}

	@Bean(name = "testDbSqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDbDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		return bean.getObject();
	}

	@Bean(name = "testDbTransactionManager")
	public DataSourceTransactionManager testTransactionManager(@Qualifier("testDbDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "testDbSqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("testDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
