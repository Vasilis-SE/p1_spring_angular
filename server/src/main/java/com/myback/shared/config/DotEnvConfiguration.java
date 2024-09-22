package com.myback.shared.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DotEnvConfiguration {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                     .directory("server/env")
                     .filename(".env")
                     .load();    
    }
}
