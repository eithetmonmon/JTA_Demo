package com.may.phyo.configuration;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;

public class JtaConfiguration {

    @Bean
    public UserTransaction atomikoUserTransaction() throws Throwable{
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(100);
        return userTransactionImp;
    }
    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikoUserTransactionManager() throws Throwable{
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(UserTransaction atomikoUserTransaction,
                                                         UserTransactionManager atomikoUserTransactionManager){
        return new JtaTransactionManager(atomikoUserTransaction,atomikoUserTransactionManager);
    }
}
