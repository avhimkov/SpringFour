package ch13;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ImportResource("classpath:META-INF/datasource-tx-jpa.xml")
@ComponentScan(basePackages = {"ch13"})
@Profile("test")
public class ServiceTestConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").build();
    }
    @Bean(name = "databaseTester")
    public DataSourceDatabaseTester dataSourceDatabaseTester(){
        DataSourceDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource());
        return databaseTester;
    }

    @Bean(name = "xlsDataFileLoader")
    public XlsDataFileLoader xlsDataFileLoader(){
        return new XlsDataFileLoader();
    }

}
