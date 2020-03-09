//package xft.abscloud.manager.datasource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(value = {"xft.abscloud.manager.mapper","xft.abscloud.manager.*.mapper"},
//        sqlSessionTemplateRef  = "mysqlSqlSessionTemplate")  //关联的mapper.xml所在位置
//public class DataSourceConfig {
//	@Bean(name = "mysqlDataSource") //作为一个bean对象并命名
//    @ConfigurationProperties(prefix = "spring.datasource.mysql") //配置文件中，该数据源的前缀
//    @Primary   //用于标记主数据源，除了主数据源外，其余注入文件都不添加该注解
//    public DataSource DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "mysqlSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory SqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//对应mapper.xml的具体位置
//        return bean.getObject();
//    }
//
//    @Bean(name = "mysqlTransactionManager")
//    @Primary
//    public DataSourceTransactionManager TransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "mysqlSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
