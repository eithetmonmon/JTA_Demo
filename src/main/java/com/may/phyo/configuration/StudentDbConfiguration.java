package com.may.phyo.configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories(basePackages = {"com.may.phyo.db.student.dao"},
        entityManagerFactoryRef = "studentEntityManagerFactory")

public class StudentDbConfiguration {




    @Bean
    public DataSource studentDataSource() throws SQLException{
        MysqlXADatasource mysqlXADatasource = new MysqlXADataSource();
        mysqlXADatasource.setURL("jdbc:mysql://localhost:3306/spring_student");
        mysqlXADatasource.setUser("root");
        mysqlXADatasource.setUser("admin");
        mysqlXADatasource.setPinGlobalTxToPhysicalConnection(true);


        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADatasource);
        atomikosDataSourceBean.setUniqueResourceName("studentDB");
        return atomikosDataSourceBean;


    }
}
