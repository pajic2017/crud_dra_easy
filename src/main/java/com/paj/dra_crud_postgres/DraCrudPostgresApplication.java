package com.paj.dra_crud_postgres;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DraCrudPostgresApplication {

    //private static final Logger log= (Logger) LoggerFactory.getILoggerFactory(DraCrudPostgresApplication.class.getName());

    private static final java.util.logging.Logger log= Logger.getLogger(DraCrudPostgresApplication.class.getName());

    public static void main(String[] args) {

        SpringApplication.run(DraCrudPostgresApplication.class, args);
        log.info("My interaction with console in DRA CRUD POSTGRES example ###");
    }

}
