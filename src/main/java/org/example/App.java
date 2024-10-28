package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App 
{
    public static void main( String[] args )
    {
        Dotenv dotenv = Dotenv.configure().load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("SHOW_SQL", dotenv.get("SHOW_SQL"));
        System.setProperty("HIBERNATE_DIALECT", dotenv.get("HIBERNATE_DIALECT"));
        System.setProperty("DDL_AUTO", dotenv.get("DDL_AUTO"));

        SpringApplication.run(App.class, args);
    }
}
