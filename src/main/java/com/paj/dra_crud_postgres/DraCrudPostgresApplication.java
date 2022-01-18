package com.paj.dra_crud_postgres;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DraCrudPostgresApplication {

    //Logger log= (Logger) LoggerFactory.getILoggerFactory(DraCrudPostgresApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(DraCrudPostgresApplication.class, args);
    }

}
