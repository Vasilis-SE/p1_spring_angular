package com.myback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myback.config.DotEnvConfiguration;



@SpringBootApplication
public class MybackApplication {

        private static final Logger logger = LoggerFactory.getLogger(MybackApplication.class.getName());


        public static void main(String[] args) {
                DotEnvConfiguration dotenvConf = new DotEnvConfiguration();
                dotenvConf.dotenv().entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
                logger.info("Loaded environment variables to the system properties...");

                SpringApplication.run(MybackApplication.class, args);
        }
}
