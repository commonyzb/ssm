package com.yzb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.yzb.dao")
@ComponentScan(basePackages = {"com.yzb.config","com.yzb.service"})
@PropertySource("classpath:database.properties")
public class RootConfigure {

    public static final Logger log = Logger.getLogger(RootConfigure.class);

    /*
     * Druid datasource configure
     */
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
//    @Value("${spring.datasource.druid.filters}")
//    private String filters;
//    @Value("${spring.datasource.druid.initialSize}")
//    private int initialSize;
//    @Value("${spring.datasource.druid.minIdle}")
//    private int minIdle;
//    @Value("${spring.datasource.druid.maxActive}")
//    private int maxActive;
//    @Value("${spring.datasource.druid.maxWait}")
//    private int maxWait;
//    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
//    private int timeBetweenEvictionRunsMillis;
//    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
//    private int minEvictableIdleTimeMillis;
//    @Value("${spring.datasource.druid.testWhileIdle}")
//    private boolean testWhileIdle;
//    @Value("${spring.datasource.druid.testOnBorrow}")
//    private boolean testOnBorrow;
//    @Value("${spring.datasource.druid.testOnReturn}")
//    private boolean testOnReturn;
//    @Value("${spring.datasource.druid.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//    @Value("${spring.datasource.druid.maxOpenPreparedStatements}")
//    private int maxOpenPreparedStatements;
//    @Value("${spring.datasource.druid.asyncInit}")
//    private boolean asyncInit;

    /**
     * 配置此bean可将配置文件中的配置使用@Value注解注入
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("dataSource")
    public DataSource druidDataSource() {
        log.info("init druid datasource ...");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.userName);
        druidDataSource.setPassword(this.password);
        druidDataSource.setDriverClassName(this.driverClassName);
//        druidDataSource.setInitialSize(this.initialSize);
//        druidDataSource.setMinIdle(this.minIdle);
//        druidDataSource.setMaxActive(this.maxActive);
//        druidDataSource.setMaxWait(this.maxWait);
//        druidDataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
//        druidDataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
//        druidDataSource.setTestWhileIdle(this.testWhileIdle);
//        druidDataSource.setTestOnBorrow(this.testOnBorrow);
//        druidDataSource.setTestOnReturn(this.testOnReturn);
//        druidDataSource.setPoolPreparedStatements(this.poolPreparedStatements);
//        druidDataSource.setMaxOpenPreparedStatements(this.maxOpenPreparedStatements);
//        druidDataSource.setAsyncInit(this.asyncInit);
//        try {
//            druidDataSource.setFilters(this.filters);
//        } catch (SQLException e) {
//            log.error("druid configuration initialization filter", e);
//        }
        return druidDataSource;
    }

    /**
     * Mybatis configure
     */
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource, @Qualifier("mybatisSetting") org.apache.ibatis.session.Configuration configuration) throws Exception {
        log.info("mybatis configuration initialization...");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        sqlSessionFactoryBean.setConfiguration(configuration());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.yzb.entity");
        return sqlSessionFactoryBean;
    }

    @Bean("mybatisSetting")
    public org.apache.ibatis.session.Configuration configuration(){
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
