package com.spark.bitrade.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.custom")
public class CustomMongoConfig extends MongoTemplateConfig {


    @Primary
    @Bean(name = "mongoTemplate")
    @Override
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(null));
    }

    @Bean(name = "chatMongoTemplate")
    public MongoTemplate getChatMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory("galaxy"));
    }

    @Bean(name = "walletMongoTemplate")
    public MongoTemplate getWalletMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory("wallet"));
    }

}
