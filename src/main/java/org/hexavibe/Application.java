package org.hexavibe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //TODO UTests, Logs, Exception to REST, Profile config(JPA or Mongo), Put in different jars
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
