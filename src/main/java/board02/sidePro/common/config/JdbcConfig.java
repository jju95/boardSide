package board02.sidePro.common.config;

import board02.sidePro.common.utils.PropertiesManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@Configuration
@MapperScan(value="board02.sidePro.mapper")
@EnableCaching
public class JdbcConfig {

    @Autowired
    private PropertiesManager propertiesManager;

    @Autowired
    private ApplicationContext context;

    public JdbcConfig(PropertiesManager propertiesManager, ApplicationContext context){
        this.propertiesManager = propertiesManager;
        this.context = context;
    }

    private Map<String, String> dataSource;

    @Bean
    public DataSource mysqlDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dataSource.get("driver-class-name"));
        dataSourceBuilder.url(dataSource.get("jdbc-url"));
        dataSourceBuilder.username(dataSource.get("username"));
        dataSourceBuilder.password(dataSource.get("password"));

        return dataSourceBuilder.build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mysqlDataSource());


        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
        factoryBean.setMapperLocations(res);

        factoryBean.setTypeAliasesPackage("board02.sidePro.*");

        return factoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionTemplate;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @PostConstruct
    public void init(){
        dataSource = propertiesManager.getDatasource();
    }
}
