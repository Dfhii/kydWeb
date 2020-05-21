package dulk.baseMan.service.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;//org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;该包在springboot2.0被取代，目前网上的都是这个springboot1.5的包，所以会一直报错
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@MapperScan(basePackages = "dulk.baseMan.mapper.*")//扫描dao层mapper接口
public class MyBatisConfig {

    /**
     * @return
     * @throws Exception
     * @Primary 必需指定一个且只能有一个主数据源，否则报错
     */
    @Primary
    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")//根据数据源前缀到application.yml读取数据源信息//此处改变前缀可以改变默认数据源//
    public DataSource masterDataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }

    @Bean("slave1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave1")//根据数据源前缀到application.yml读取数据源信息//可以配置更多数据源，到前提是application.yml中存在，而且也需要在枚举类中添加枚举类型
    public DataSource slave1DataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }
    @Bean("slave2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave2")//根据数据源前缀到application.yml读取数据源信息//可以配置更多数据源，到前提是application.yml中存在，而且也需要在枚举类中添加枚举类型
    public DataSource slave2DataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }
    /**
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     * @DataSourceTypeAnno(DataSourceEnum.master)事务方法需要指定数据源
     */
    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                               @Qualifier("slave1DataSource") DataSource slave1DataSource, @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceContextHolder.DataSourceEnum.master, masterDataSource);
        targetDataSources.put(DataSourceContextHolder.DataSourceEnum.slave1, slave1DataSource);
        targetDataSources.put(DataSourceContextHolder.DataSourceEnum.slave2, slave2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(masterDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource,
                                               @Value("mybatis.type-aliases-package") String typeAliasesPackage) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);// 指定实体类所在的包        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/**/*Mapper.xml"));//扫描mapper.xml文件包
        return factoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}