package com.bilawal.demo.configuration;

import com.bilawal.demo.DB;
import com.bilawal.demo.DevDB;
import com.bilawal.demo.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean(){
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
