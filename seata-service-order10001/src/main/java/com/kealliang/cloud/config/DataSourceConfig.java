package com.kealliang.cloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 配置seata代理的数据源，否则全局事务将不生效
 * @author lsr
 * @ClassName DataSourceConfig
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@MapperScan("com.kealliang.**.dao")
@Configuration
public class DataSourceConfig {

    /*@Value("${spring.application.name}")
    private String appName;*/

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    /**
     * init durid datasource
     *
     * @Return: druidDataSource  datasource instance
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 这里的DataSourceProxy使用的是seata的！
     * @author lsr
     * @description dataSourceProxy
     * @Date 2020/4/19
     */
    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource){
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }

    // 因为我使用的是MybatisPlus，所以需要注入此部分
    /*@Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSourceProxy proxy) throws IOException {
        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
        mybatisPlus.setDataSource(proxy);
        mybatisPlus.setVfs(SpringBootVFS.class);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        mybatisPlus.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        //使用ID_WORKER_STR，因为前后端分离使用整形，前端JS会有精度丢失
        dbConfig.setIdType(IdType.ID_WORKER_STR);
        globalConfig.setDbConfig(dbConfig);
        mybatisPlus.setGlobalConfig(globalConfig);
        MybatisConfiguration mc = new MybatisConfiguration();
        // 对于完全自定义的mapper需要加此项配置，才能实现下划线转驼峰
        mc.setMapUnderscoreToCamelCase(true);
        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        mybatisPlus.setConfiguration(mc);
        return mybatisPlus;
    }*/

    /*@Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner(this.appName, "keal_tx_group");
    }*/

}
