package com.my.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import com.my.common.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class HxjbAppDataSourceConfig {

    @Value("${hxjbApp.datasource.url}")
    private String url;

    @Value("${hxjbApp.datasource.username}")
    private String user;

    @Value("${hxjbApp.datasource.password}")
    private String password;

    @Value("${hxjbApp.datasource.driverClassName}")
    private String driverClass;

    @Autowired
    private DBProperties dbProperties;

    @Autowired
    private MybatisProperties mybatisProperties;

    @Bean(name = "hxjbAppDataSource")
    public DataSource hxjbAppDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(Integer.parseInt(dbProperties.getInitialSize()));
        dataSource.setMinIdle(Integer.parseInt(dbProperties.getMinIdle()));
        dataSource.setMaxActive(Integer.parseInt(dbProperties.getMaxActive()));
        dataSource.setMaxWait(Long.parseLong(dbProperties.getMaxWait()));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(dbProperties.getTimeBetweenEvictionRunsMillis()));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(dbProperties.getMinEvictableIdleTimeMillis()));
        dataSource.setValidationQuery(dbProperties.getValidationQuery());
        dataSource.setTestWhileIdle(Boolean.parseBoolean(dbProperties.getTestWhileIdle()));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(dbProperties.getTestOnBorrow()));
        dataSource.setTestOnReturn(Boolean.parseBoolean(dbProperties.getTestOnReturn()));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(dbProperties.getPoolPreparedStatements()));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(dbProperties.getMaxPoolPreparedStatementPerConnectionSize()));
        dataSource.setFilters(dbProperties.getFilters());
        return dataSource;
    }

    @Bean(name = "hxjbAppTransactionManager")
    public DataSourceTransactionManager hxjbAppTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(hxjbAppDataSource());
    }

    @Bean(name = "hxjbAppSqlSessionFactory")
    public SqlSessionFactory hxjbAppSqlSessionFactory(@Qualifier("hxjbAppDataSource") DataSource hxjbAppDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hxjbAppDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource(mybatisProperties.getConfigLocation()));
        sessionFactory.setTypeAliasesPackage(dbProperties.getTypeAliasesPackage());
        return sessionFactory.getObject();
    }


    @Bean(name = "hxjbAppBaseDao")
    public BaseDao hxjbAppBaseDao() throws Exception {
        return new BaseDao(hxjbAppSqlSessionFactory(hxjbAppDataSource()));
    }
}